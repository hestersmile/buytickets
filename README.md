# buytickets
电影票售卖系统/管理系统

##背景
由于先前主要的涉猎范围是移动端开发(Android)，并没有相关java web 的开发经验。利用了业余的时间大致学习了一下spring mvc+mybatis 模式。

##功能架构

整个系统采用的springmvc框架 持久层采用的是mybatis 数据库是MariaDB 缓存数据库是redis 部署在centos7下
整个功能包括用户模块 和 管理员模块 
* 用户模块包含 登陆、查看所有电影列表、搜索电影、购买电影票、成功后发邮件
* 管理员模块包含电影模块、用户模块、订单模块三个主体部分
 * 电影模块包括：增删改查电影信息
 * 用户模块包括：查删用户信息 
 * 订单模块包括：查看所有订单 查看某个电影所有订单 查询用户的所有订单

##存在问题

* 1、并未按照要求利用jdo、jpa实现数据持久层
* 2、qq、微博互联的功能也未完成，提交的申请一直有问题
* 3、安全性能差 

##注意
管理员账号（hestersmile）密码（123456） 普通用户测试账号admin 密码 admin （也可以自己注册）
