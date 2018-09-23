# sharding-jdbc-first
This is a  demo of sharding database and table using sharding jdbc
## how to start?
1. 创建两个数据库 ds_0 和 ds_1
2. 每个库分表创建两个表t_order_0和t_order_1,sql语句如下：<br/>
DROP TABLE IF EXISTS t_order_0; 
CREATE TABLE t_order_0 ( 
order_id bigint(20) NOT NULL, 
user_id bigint(20) NOT NULL, 
PRIMARY KEY (order_id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin; 
3. 下载代码，修改DateSourceConfig类里的username，password即可启动
> 参考文章地址：https://blog.csdn.net/tianyaleixiaowu/article/details/70242971
