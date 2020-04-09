#### Soekct和WebSocket的关系
区别域|Socket|WebSocket
:---:|:---:|:---:|
是什么|非协议，传输控制层接口|协议
协议类型|不是协议|WebSocket
用途|Socket是应用层与TCP/IP协议族通信的中间软件抽象层，它是一组接口，提供一套调用TCP/IP协议的API，是为了方便使用TCP或UDP而抽象出来的一层|HTML5新增的用于长连接的协议(模拟Socket协议)
网络层|应用层和传输控制层之间的一组接口|应用层
通信信道|x|全双工
#### WebSocket和Http的关系

区别域|Http|WebSocket
:---:|:---:|:---:|
协议|基于TCP|基于TCP
是否可靠|可靠|可靠
网络层|应用层|应用层
通信信道|单工|全双工
连接过程|浏览器发起连接|握手连接(Http协议握手)
传输过程|x|使用握手连接建立以后形成的TCP信道
联系|x|WebSocket在建立握手时，数据是通过Http来传输的，连接建立之后，真正传输时是不需要Http协议的

在WebSocket中，只需要服务器和浏览器通过HTTP协议进行一个握手的动作，然后单独建立一条TCP的通信通道进行数据的传送。
WebSocket连接的过程是：

首先，客户端发起http请求，经过3次握手后，建立起TCP连接；http请求里存放WebSocket支持的版本号等信息，如：Upgrade、Connection、WebSocket-Version等；
然后，服务器收到客户端的握手请求后，同样采用HTTP协议回馈数据；
最后，客户端收到连接成功的消息后，开始借助于TCP传输信道进行全双工通信。
