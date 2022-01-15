---
title: Generic-Webhook-Trigger
tags: 
- Jenkins
- hook
- webhook
date: 2022-01-16 00:38:07
id: 1642264687866989800
---
# 摘要

jenkins 自动构建

# 环境准备

- jenkins-2.289.3

# Jenkins

## 插件安装

| name                    | version |
| ----------------------- | ------- |
| Pipeline                | 2.6     |
| Generic Webhook Trigger | 1.79    |

## API Token

### 进入 Configure

![image-20220116004839500](assets/images/image-20220116004839500.png)

### 生成 API Token

生成 API Token 后记住这两个值，后面有用

![image-20220116013731667](assets/images/image-20220116013731667.png)





## 创建 job

![image-20220116011401743](assets/images/image-20220116011401743.png)

## Generic Webhook Trigger

![image-20220116011605502](assets/images/image-20220116011605502.png)

## Hello World

Pipeline script 我们直接用 Hello World 就好

# gitlab

## Outbound requests

![image-20220116010620942](assets/images/image-20220116010620942.png)

## 创建项目

![image-20220116005750577](assets/images/image-20220116005750577.png)



## Integrations

![image-20220116012109073](assets/images/image-20220116012109073.png)

## URL

```
http://admin:11713304e6422e73e7a972f61df4b050c1@192.168.19.10:8080/generic-webhook-trigger/invoke
```

![image-20220116013006535](assets/images/image-20220116013006535.png)

# Test

Test → Push events 后出现：

![image-20220116013206535](assets/images/image-20220116013206535.png)

并且 Jenkins 开始构建任务



