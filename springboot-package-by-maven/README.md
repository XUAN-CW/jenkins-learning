---
title: springboot-package-by-maven
tags: 
- Jenkins
- maven
- package
date: 2022-01-17 06:23:30
id: 1642371811009915300
---
# 摘要

使用 maven 打包 spring boot 项目

# 准备工作

## 实验条件

- jenkins-2.289.3 
- gitlab-ce_12.4.2-ce.0 
- [apache-maven-3.6.3-bin.tar.gz](https://dlcdn.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz) 

## 前置知识

-  Jenkins 使用 pipeline clone gitlab 上的代码

# hello-springboot

准备一个 spring boot 的 hello world 项目即可

## 创建项目

IDEA 中使用 [spring initializer](https://start.spring.io/) 创建项目，选择 **2.3.2.RELEASE** 版本（创建完了再改也行），勾选 **Web → Spring Web** 

## HelloController.java

```java
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "hello spring boot!";
    }
}
```

## 创建仓库

把 hello-springboot 项目作为一个仓库，在  hello-springboot 文件夹下使用 Git Bash 执行 `git init .` 即可





