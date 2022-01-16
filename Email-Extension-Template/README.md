---
title: Email-Extension-Template
tags: 
- Jenkins
- Email
date: 2022-01-16 18:57:41
id: 1642330661350248100
---
# 摘要



# 环境准备

- jenkins-2.289.3
- [邮件授权码](#邮件授权码) 

# 邮件授权码

## 开启邮件服务

![image-20220116191203181](assets/images/image-20220116191203181.png)

## 获取授权码

![image-20220116190802729](assets/images/image-20220116190802729.png)

# jenkins 发送邮件

## 插件安装

| name                     | version |
| ------------------------ | ------- |
| Pipeline                 | 2.6     |
| Email Extension Template | 1.4     |

## Jenkins设置邮箱相关参数

进入 Manage Jenkins → Configure System ，设置如下参数：

| 配置项                           | 配置                   |
| -------------------------------- | ---------------------- |
| SMTP server                      | smtp.qq.com            |
| Default user e-mail suffix       | @qq.com                |
| Use SMTP Authentication → 用户名 | 你的邮箱               |
| Use SMTP Authentication → 密码   | 授权码，不是 QQ 密码！ |
| SMTP Port                        | 587                    |





## 测试

















