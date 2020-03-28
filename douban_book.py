import os
import re
import time
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait
from twisted.python.compat import raw_input
import pymysql

def spider_each(soup,tag):
	global book_id
	global mycursor
	global mydb
	global comment_id
	soup = soup.find('div', id = 'wrapper')
	title = soup.find('h1').find('span', property="v:itemreviewed").text.strip()
	cover = soup.find('div', id="mainpic" ).find('a')['href'].strip()
	info = str(soup.find('div', id = "info")).split("<br/>")
	author =''
	press = ''
	year = ''
	for i in info:
		if re.search('作者',i) is not None:
			author = re.search(r"<a(.*)>([\s\S]*)</a>",i).group(2).strip()
		if re.search('出版社',i) is not None:
			press = re.search(r"</span>([\s\S]*)",i).group(1).strip()
		if re.search('出版年',i) is not None:
			year = re.search(r"</span>([\s\S]*)",i).group(1).strip()
	score = soup.find('strong', class_ = "ll rating_num ").text.strip()
	content_des = soup.find('div', id = "link-report").find('div', class_ = "intro").text
	content_des = re.sub(r'<a([\s\S]*)</a>',"",content_des)
	content_des = re.sub(r'</p>',"\n",re.sub(r'<p>',"",content_des)).strip()
	author_des = soup.find("div", class_ = "indent ").find("div", class_ = "intro").text
	author_des = re.sub(r'<a([\s\S]*)</a>',"",author_des)
	author_des = re.sub(r'</p>' , "\n" , re.sub(r'<p>' , "" , author_des)).strip()
	print(title)
	# print(cover)
	# print(author)
	# print(press)
	# print(year)
	# print(score)
	# print(content_des)
	# print(author_des)

	sql1 = 'insert into book (id,title,cover,author,press,pyear,score,content_des,author_des,book_type) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);'
	try:
		mycursor.execute(sql1 ,
		                 [book_id , title , cover , author , press , year , score , content_des , author_des , tag])

	except:
		return

	comment_list = soup.find("div", id = 'comments').find_all('li', class_="comment-item")
	for i in comment_list:
		content = i.find('p' , class_ = 'comment-content').find('span').text
		p_name = i.find('span', class_ = 'comment-info').find('a').text
		p_score = 4
		try:
			p_score = int(re.search(r'allstar([\s\S]*) rating',str(i.find('span', class_ = 'comment-info'))).group(1))/10
		except:
			continue
		p_time = i.find('span', class_ = 'comment-info').find_all('span')[1].text
		praise = int(i.find('span', class_ = 'comment-vote').find('span', class_ = "vote-count").text)
		sql2 = 'insert into comments (id,book_id,content,p_name,p_score,p_time,praise) values (%s,%s,%s,%s,%s,%s,%s);'
		try:
			mycursor.execute(sql2 , [comment_id , book_id , content , p_name , p_score , p_time , praise])
			comment_id = comment_id + 1
		except:
			continue

	book_id = book_id + 1
	mydb.commit()
	# time.sleep(8)

def spider_in_tag(url,tag):
	global book_id
	driver = webdriver.Chrome()
	driver.get(url)
	soup = BeautifulSoup(driver.page_source , "lxml")
	list = soup.find_all('a', class_ = 'nbg')
	for i in list:
		print(str(book_id)+"     "+i['href']+"   "+tag)
		driver.quit()
		driver = webdriver.Chrome()
		try:
			driver.get(i['href'])
		except:
			driver.quit()
			driver = webdriver.Chrome()
			time.sleep(5)

		soup = BeautifulSoup(driver.page_source , "lxml")
		try:
			spider_each(soup , tag)
		except:
			continue

def prepareDB():
	global mydb
	mydb = pymysql.connect(
		host = "localhost" ,
		user = "root" ,
		passwd = "root",
		charset = 'utf8'
	)
	global mycursor
	mycursor = mydb.cursor()
	mycursor.execute("DROP DATABASE IF EXISTS `agile`")
	mycursor.execute("CREATE DATABASE agile")
	mycursor.close()
	mydb.close()
	mydb = pymysql.connect(
		host = "localhost" ,
		user = "root" ,
		passwd = "root" ,
		charset = 'utf8',
		database = 'agile'
	)
	mycursor = mydb.cursor()
	sql1 = """
	CREATE TABLE book (
	id INT PRIMARY KEY ,
	title CHAR(100) NOT NULL,
	cover CHAR(100) NOT NULL,
	author CHAR(100) NOT NULL,
	press CHAR(100) NOT NULL,
	pyear CHAR(100) NOT NULL,
	score DOUBLE NOT NULL,
	content_des TEXT NOT NULL,
	author_des TEXT NOT NULL,
	book_type CHAR(10) NOT NULL
	)ENGINE=innodb DEFAULT CHARSET=utf8;"""

	sql2 = """
		CREATE TABLE comments (
		id INT PRIMARY KEY ,
		book_id INT,
		content TEXT NOT NULL,
		p_name CHAR(100) NOT NULL,
		p_score DOUBLE NOT NULL,
		p_time CHAR(100) NOT NULL,
		praise int NOT NULL
		)ENGINE=innodb DEFAULT CHARSET=utf8;"""

	mycursor.execute(sql1)
	mycursor.execute(sql2)

if __name__ == '__main__':
	base_url = 'https://book.douban.com/tag/'
	type = ['小说','言情','历史','教育','旅行','散文','哲学','旅行','美食','商业','编程']
	prepareDB()
	book_id = 0
	comment_id = 0
	mycursor
	mydb
	for i in type:
		spider_in_tag(base_url+i,i)
	# driver = webdriver.Chrome()
	# driver.get('https://book.douban.com/subject/34617780/')
	# spider_each(BeautifulSoup(driver.page_source , "lxml") , 'tag')