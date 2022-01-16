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

| 配置项                           | 配置                     |
| -------------------------------- | ------------------------ |
| System Admin e-mail address      | ${你的邮箱}              |
| SMTP server                      | smtp.qq.com              |
| Default user e-mail suffix       | @qq.com                  |
| Use SMTP Authentication          | 勾选此项                 |
| Use SMTP Authentication → 用户名 | ${你的邮箱}              |
| Use SMTP Authentication → 密码   | ${授权码} 不是 QQ 密码！ |
| SMTP Port                        | 587                      |

![image-20220116195907883](assets/images/image-20220116195907883.png)

## 测试

1. 点击 **Test configuration by sending test e-mail** 
2. 输入一个邮箱
3. 点击 **Test configuration** 

如果能够收到邮件，则说明配置成功

![image-20220116200351928](assets/images/image-20220116200351928.png)

# 按照模板发送邮件

你可以在 Manage Jenkins → Configure System 中设置邮件发送的配置，比如何时发送邮件、发送邮件的模板。在这里我更推荐把邮件模板跟代码放在一起，然后使用 pipeline 控制邮件的发送

















