import pymysql
import csv
import re

file_path = "data.csv"
table_name = "export"
csv_file=open(file_path)
csv_reader_lines = csv.reader(csv_file)

db = pymysql.connect(host="localhost", port=3306,user="root",
                          passwd="root",db="agile",charset='utf8')
cur = db.cursor()

i = 0

re1 = re.compile(r'(?<=出版社: ).+?(?= )')
re2 = re.compile(r'(?<=出版年: ).+?(?= )')

next(csv_reader_lines)
list = []
for row in csv_reader_lines:
    title = row[0]
    cover = row[1]
    press = re1.findall(row[2])[0]
    date = re2.findall(row[2])[0]
    author = row[3]
    describe = row[4]
    tags = row[6]+","+row[7]+","+row[8]+","+row[9]+","+row[10]+","+row[11]+","+row[12]+","+row[13]
    print(title)
    # print(cover)
    # print(press)
    # print(date)
    # print(author)
    # print(describe)
    # print(tags)
    tem = (cover , title , author , date , press , describe , tags)
    list.append(tem)
    i+=1
print("共"+i+"条数据")
sql = "INSERT INTO book(id,cover,title,author,`date`,press,`describe` ,tags) VALUES (0,%s,%s,%s,%s,%s,%s,%s)"
cur.executemany(sql,list)
db.commit()