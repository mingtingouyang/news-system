# news-system
[![GitHub issues](https://img.shields.io/github/issues/mingtingouyang/news-system)](https://github.com/mingtingouyang/news-system/issues)
[![GitHub forks](https://img.shields.io/github/forks/mingtingouyang/news-system)](https://github.com/mingtingouyang/news-system/network)
[![GitHub license](https://img.shields.io/github/license/mingtingouyang/news-system)](https://github.com/mingtingouyang/news-system/blob/master/LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/mingtingouyang/news-system)](https://github.com/mingtingouyang/news-system/stargazers)

- [介绍](#介绍)
  - [后台管理](#后台管理)
  - [PC 端](#PC端)
  - [手机端](#手机端)
- [使用](#使用)
- [备注](#备注)

## 介绍
该系统基于 Servlet 和 Jsp 编写，拥有完整的新闻管理系统的功能，包括了三个模块：后台管理模块、PC 端用户模块、手机端用户模块，并且基于过滤器编写了登录验证功能。

### 后台管理
后台管理系统中，包括了以下功能：

1. 管理员的管理，包括添加管理员，修改密码、头像、基础信息和状态；
2. 用户的管理，包括了查看、添加、修改用户信息，更改用户的状态等功能；
3. 文章的管理，包括了添加、修改文章的功能，并使用了富文本编辑器插件；
4. 数据统计，统计了新闻网页各个板块的访问量，并用 bootstrap 插件画出饼图。

> 访问地址：[后台管理页面](http://ozaaa.cn/TodayNews/admin/index)
>
> username:admin
>
> password:admin

### PC端
PC 端页面不需要登录直接可以访问，页面直接展示的是数据库中最新的新闻数据，点击标题可以查看新闻详情。

> 访问地址：[PC 端页面](http://ozaaa.cn/TodayNews)

### 手机端
手机端的功能较为丰富，包括以下功能：

1. 登录系统，包括新用户的注册；
2. 使用 weui 插件设计界面，卡片式新闻列表；
3. 包含好友系统，可以通过用户名添加好友；
4. 包含朋友圈系统，只能查看好友的朋友圈；
5. 新闻详情包含评论系统，用户可以查看所有用户的评论。

> 访问地址：[手机端页面](http://ozaaa.cn/TodayNews/mobile)

## 使用
只需要修改 jdbc.util.JdbcUtil 下的数据库链接参数即可使用，编译环境为 JDK 1.8，服务器使用的式 Tomcat。

可以用 dataBase 目录下的 sql 文件创建表，数据库名字为 todaynews，基于 mysql。

## 备注
该系统为个人以学习为目的开发，请使用的朋友们不要恶意修改数据，如果有意见欢迎提出，谢谢！
