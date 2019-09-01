# spring-boot-micro-demo

#### 项目介绍
spring-boot-micro-demo
单个微服务基本项目结构

用到spring boot ，mybatis，undertow，druid，logback日志归档（仅prod环境），提供swagger接口文档,基础代码自动生成

#### 软件架构
软件架构说明

commom--公共包

config--配置文件

controller--控制器-api入口

dao--数据库访问层

service--业务服务层

##### 通用集成服务
邮件异步发送

#### 安装教程

1. xxxx
2. xxxx
3. xxxx

#### 使用说明

1. 配置数据库，修改生成器生成代码路径信息和表信息，生成代码
2. 启动注册中心consul
3. 启动主程序

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### 无状态token需要考虑的问题

- 1.用户主动注销token
处理方案：
保存主动注销的token到redis，设置自动过期时间为token剩余有效期，每个请求检查token是否在redis中
具体流程：
1. 用户请求注销 token 123456
2. 将 123456 , 存入 redis 用户注销队列，记为 QueueLogout , 每个 token 过期时间是 token 的剩余有效时间
3. 对每个请求，根据用户名 检查 token 是否在 QueueLogout 中，如果在，返回 token 过期，要求重新登陆

- 2.系统主动过期token
将用户名添加到 系统过期用户队列 SystemExpire ，用户重新登陆后，移除队列
具体流程：
1. 系统注销用户 A
2. 添加用户 A 到 系统过期用户队列
3. 对每个请求， 根据用户名，检查 用户名是否在 SystemExpire 中， 如果在，返回 token 过期，要求重新登陆，用户重新登陆后，移除队列

