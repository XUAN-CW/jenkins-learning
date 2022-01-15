---

title: jenkins-clone-repo-by-pipeline
tags: 
date: 2022-01-15 15:40:03
id: 1642232403144740200
---
# 摘要

jenkins 使用 pipeline 克隆仓库

# 环境准备

## jenkins

安装好 jenkins-2.289.3 

## gitlab

想要 clone 代码，那代码总得有个地方放吧。你可能想到了 GitHub ，这确实是一种方案，但估计没有哪家公司会把自家的机密代码放到 GitHub 上，因此这里的代码仓库我们选择 **gitlab-ce:12.4.2-ce.0** 。gitlab 自行安装，这里不过多赘述

#  git 仓库准备

## Create a project

到 gitlab 中创建一个 **jenkins-clone-demo-repo** 仓库，顺便勾选 **Initialize repository with a README** ：

![image-20220115214014997](assets/images/image-20220115214014997.png)

# Jenkins clone 仓库

## 添加凭据

Manage Jenkins → Manage Credentials → 添加凭据



## 安装插件 pipeline







































