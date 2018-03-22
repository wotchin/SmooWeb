# SmooWeb

|build|failed|
|-----|------|
|state|developing|

## 说明
SmooWeb原名TinyHttp,是一种轻量级的，基于Java SE的Web框架；
应用场景主要是微服务相关,主要面对并发事件的处理与响应。

## 主要特点
* 基于线程池以及NIO技术;
* 使用注解的方式路由;
* 支持RESTful风格;
* 配合nginx优秀的静态文件下载效率,实现动静分离机制;
* 没有采用传统的MVC设计模式,使用了完全前后端分离的设计思想;
* 在API设计上,融合了Node,mochi,Spring,playframework等框架的特点,易于上手;
* 框架结构很简单,完全可以自己二次开发,定制.

## 性能测试
使用ApacheBench进行并发性能测试:
```shell
ab -c 10 -t 100 http://127.0.0.1:9000/
```
测试结果:

```
Benchmarking 127.0.0.1 (be patient)
Completed 5000 requests
Completed 10000 requests
Completed 15000 requests
Completed 20000 requests
Completed 25000 requests
Completed 30000 requests
Completed 35000 requests
Completed 40000 requests
Completed 45000 requests
Completed 50000 requests
Finished 50000 requests


Server Software:        inyHttp/1.0
Server Hostname:        127.0.0.1
Server Port:            9000

Document Path:          /
Document Length:        10 bytes

Concurrency Level:      10
Time taken for tests:   2.609 seconds
Complete requests:      50000
Failed requests:        0
Total transferred:      6200000 bytes
HTML transferred:       500000 bytes
Requests per second:    19164.92 [#/sec] (mean)
Time per request:       0.522 [ms] (mean)
Time per request:       0.052 [ms] (mean, across all concurrent requests)
Transfer rate:          2320.75 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0  12.9      0    1023
Processing:     0    0   0.9      0      41
Waiting:        0    0   0.8      0      41
Total:          0    0  13.0      0    1030

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      0
  90%      1
  95%      1
  98%      2
  99%      2
 100%   1030 (longest request)
```

对比Node.js的结果是:

```
Benchmarking 127.0.0.1 (be patient)
Completed 5000 requests
Completed 10000 requests
Completed 15000 requests
Completed 20000 requests
Completed 25000 requests
Completed 30000 requests
Completed 35000 requests
Completed 40000 requests
Completed 45000 requests
Completed 50000 requests
Finished 50000 requests


Server Software:        
Server Hostname:        127.0.0.1
Server Port:            8080

Document Path:          /
Document Length:        0 bytes

Concurrency Level:      10
Time taken for tests:   6.234 seconds
Complete requests:      50000
Failed requests:        0
Non-2xx responses:      50000
Total transferred:      5350000 bytes
HTML transferred:       0 bytes
Requests per second:    8020.06 [#/sec] (mean)
Time per request:       1.247 [ms] (mean)
Time per request:       0.125 [ms] (mean, across all concurrent requests)
Transfer rate:          838.03 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.0      0       1
Processing:     0    1   0.8      1      17
Waiting:        0    1   0.8      1      17
Total:          0    1   0.8      1      17

Percentage of the requests served within a certain time (ms)
  50%      1
  66%      1
  75%      1
  80%      1
  90%      2
  95%      2
  98%      4
  99%      5
 100%     17 (longest request)
```

而面向并发编程的Erlang写成的web框架mochiweb的QPS仅为3000.

## TODO:
1. Session
2. Cookie
3. 文件上传
4. Filter
5. 日志
6. WebSocket
7. 多并发模型选择:协程,线程池,Netty
8. 前端AJAX异步渲染库
9. Nginx动静分离实现
10. 其他
