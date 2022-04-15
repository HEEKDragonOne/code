# JavaWEB实现爬取网站动态数据并实现数据可视化

### 数据库
MongoDB、Redis、MySQL

### 爬取数据
JSoup

### 功能实现
Redis：实现验证码过期   
MongoDB：存储爬取数据   
MySQL：存储用户数据   
Ajax：实现前后端数据交互   
Echarts：实现数据可视化

### 使用注意
MongoDB：需创建数据库NoSQL，创建集合（表）beijing   
MySQL：创建数据库NoSQL、表Users

### 文件内容描述
#### 1.webapp目录
1. index.jsp用来实现首页登录界面。
2. TestGetData.jsp用来展示可视化数据页面。
3. static/jsp/getCode.jsp用来验证码登录。

#### 2.resources目录
数据库配置文件

#### 3.重要文件内容描述
##### 3.1.controller
TestGetDataServlet.java实现收到前端页面请求后，从数据库读取数据、处理数据并将数据变成JSON格式，并将其返回到数据展示页面。
##### 3.2.dao
CheckUserLife.java实现MySQL中用户是否存在。
##### 3.3.entity
TestGetDataEntity.java实现爬取后的数据处理完成后收入作用，并存储入数据库。
##### 3.4.servlet
CodeServlet.java实现验证码登录功能代码实现。
LoginServlet.java实现用户用户名、密码登录功能代码实现。
RegisterServlet.java实现通过手机号生成验证码。
##### 3.5.utils
各种数据库的工具类。
##### 3.6.webdata
BJdata.java用来爬取获取数据和存入list集合中，并调用方法ourDataSpark.DataFX()进行数据传递。
ourDataSpark.java用来处理获取的数据并将其数据存入MongoDB数据库。
