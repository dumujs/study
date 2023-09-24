# 接口设计风格
## 传统
user/getById?id=1 method get;
user/update method post;
user/deleteByID?id=1 method get;
user/add method post;
## rest风格
    url定位资源  
http://localhost:8080/user/1 get 获取
http://localhost:8080/user post 新增
http://localhost:8080/user/1 delete 删除
http://localhost:8080/user put 修改
 
