在线图书管系统需求：
—客户
1.主页笔记更新记录展示
2.图书馆书籍展示 需要爬虫（版权问题暂时不需要在线阅读）
3.收藏图书到收藏夹
4.在线笔记本
5.个人中心
登陆权限问题
用户访问控制

—管理员
6. 用户管理
7. 图书管理

—数据分析
8. 用户个人的阅读历史数据和笔记数据的分析
9. 系统为用户群体的阅读和笔记数据的分析

迭代一 
1 2 3 4 5 6 7 基本功能的实现
迭代二
迭代一功能的完善 和 8  9功能的实现

前端技术栈
1.Vue.js
2.ElementUI
3.axios

后端技术栈
1.SpringBoot
2.SpringData + JPA
3.MySQL
4.Shiro

#数据库说明
data.csv 为豆瓣图书数据

zgq.sql 为 zztx修改后的数据库表结构模板

import_data.py 为python3下处理数据并导入数据库的数据处理代码

data.sql为包含图书数据的数据库文件

<font color=#FF0000 face="微软雅黑" size="4">
上面的话都不用管，要导入数据库执行data.sql就行
</font>

<font color=#FF0000 face="微软雅黑" size="4">
参考命令：mysql -u root -p agile < data.sql
</font>