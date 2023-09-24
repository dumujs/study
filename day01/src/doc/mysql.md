# MySql
## 1 安装
- 下载地址https://dev.mysql.com/downloads/mysql/  window下载第一个 需要oracle网站账号
- 解压包就是安装
- 配置环境变量（安装目录） D:\Program Files\mysql-8.0.34-winx64\mysql-8.0.34-winx64\bin
## 2 初始化mysql
### 管理员打开cmd
```shell
    mysql
    # 输出 ERROR 2003 (HY000): Can't connect to MySQL server on 'localhost:3306' (10061)
    # 出现以上错误表示安装成功
    mysqld --initialize-insecure # 运行生成data文件夹
    mysqld --install #安装mysql服务
    net start mysql # 启动服务
    net stop mysql # 停止服务
    mysqladmin -u root password 1234 # 设置密码
    mysql -uroot -p1234 #登陆mysql 或者 mysql -uroot -p 密码密文模式登陆
    exit 退出登陆
```
   
## 3 卸载
```shell
mysqld remove mysql
#然后删除目录
```
   
## 4 MySql连接语法
```shell
#mysql -u用户名 -p密码 [-h数据库IP地址 -P端口]
#端口默认3306  ip默认127.0.0.1
```

## 5 关系型数据库 相互关联的二维表
5.1 cmd 登陆连接mysql
cmd mysql create 数据库名;
5.2 注释
单行 -- #
多行 /* 注释 */
## 6数据库语言
### DDL
6.1 定义数据库
```shell
show databases;
create doc db01; #不可重复
create doc if not exists db01; #不存在就创建
#use 数据库名称;
select doc(); #查看数据库名称
drop doc if not exists db01;
```
6.2 定义表
```shell
create table user(
     id integer primary key,
     username linestring not null,
     age integer not null,
     gender linestring not null,
     name linestring not null
);
```
   

### DML
### DQL
### DCL