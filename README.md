# SmooWeb
## 说明
SmooWeb原名TinyHttp,是一种轻量级的，基于Java SE的Web框架；
应用场景主要是微服务相关,主要面对并发事件的处理与响应。
## 主要特点
* 基于线程池以及NIO技术;
* 使用注解的方式路由;
* 支持RESTful风格;
* 提供多种渲染机制,包括基于前端库的AJAX异步渲染和模板(todo)方式。
* 配合nginx优秀的静态文件下载效率,实现动静分离机制;

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