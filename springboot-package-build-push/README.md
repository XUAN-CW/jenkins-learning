---
title: springboot-package-build-push
tags: 
date: 2022-01-17 08:54:43
id: 1642380883850073800
---
# 摘要

Jenkins 中使用 maven 打包 spring boot 项目，打成 docker 镜像后 push 到 docker 仓库

# 准备工作

## 实验条件

- jenkins-2.289.3 
- gitlab-ce_12.4.2-ce.0  (访问 http://192.168.19.10:8000/ 可见管理界面，账号为 **root** ，密码为 **rootroot** )
- harbor-offline-installer-v1.9.2.tgz (访问 http://192.168.19.10:85/ 可见管理界面，账号为 **admin** ，密码为 **Harbor12345** )

## 前置知识

-  Jenkins 使用 maven 打包 springboot 项目
