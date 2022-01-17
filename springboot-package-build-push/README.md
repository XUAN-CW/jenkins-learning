---
title: springboot-package-build-push
tags: 
date: 2022-01-17 08:54:43
id: 1642380883850073800
---
# 摘要

Jenkins 中使用 maven 打包 spring boot 项目，打成 docker 镜像后 push 到 docker 仓库

# 准备工作

1. 安装 jenkins-2.289.3 
   - 访问 http://192.168.19.10:8080/ 可见管理界面，账号为 **admin** ，密码为 **admin** 
2.  安装 gitlab-ce_12.4.2-ce.0 
    -  访问 http://192.168.19.10:8000/ 可见管理界面，账号为 **root** ，密码为 **rootroot** 
3. 安装 apache-maven-3.6.3-bin.tar.gz
   - Jenkins 服务器能够使用 maven 打包 springboot 项目 ！！！
   - Jenkins 服务器能够使用 maven 打包 springboot 项目 ！！！
   - Jenkins 服务器能够使用 maven 打包 springboot 项目 ！！！
3. 安装 harbor-offline-installer-v1.9.2.tgz 
   - 访问 http://192.168.18.10:85/ 可见管理界面，账号为 **admin** ，密码为 **Harbor12345** 
   - Jenkins 服务器能够成功地 push 镜像到 harbor 仓库！！！
   - Jenkins 服务器能够成功地 push 镜像到 harbor 仓库！！！
   - Jenkins 服务器能够成功地 push 镜像到 harbor 仓库！！!

# hello-springboot

## 创建项目

IDEA 中使用 [spring initializer](https://start.spring.io/) 创建项目，选择 **2.3.2.RELEASE** 版本（创建完了再改也行），勾选 **Web → Spring Web** ，路径选择 clone 下来的项目

## HelloController.java

创建一个 controller 就够了

```java
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "hello spring boot!";
    }
}
```

## dockerfile

在项目根路径下创建 **dockerfile** ，内容如下：

```dockerfile
# FROM java:8
FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
# 这个地方要与配置文件中的 server.port y
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

## dockerfile-maven-plugin

这是项目的核心，详情可见 [官网](https://github.com/spotify/dockerfile-maven) ，在这里我们用它来build 、push 镜像。使用方法就是在 pom.xml 中添加插件：

```xml
            <plugin>
                <groupId>com.spotify</groupId>
                <artifactId>dockerfile-maven-plugin</artifactId>
                <version>1.4.13</version>
                <configuration>
                    <repository>192.168.18.10:85/library/${project.artifactId}</repository>
                    <tag>${project.version}</tag>
                    <username>admin</username>
                    <password>Harbor12345</password>
                    <buildArgs>
                        <JAR_FILE>target/${project.build.finalName}.jar</JAR_FILE>
                    </buildArgs>
                </configuration>
            </plugin>
```

# pipeline

创建名为 springboot-package-build-push-demo-job 的 pipeline 、 clone 代码之类的不废话了，直接给出最终 script 。执行完成后可见 harbor 仓库多了一个由 hello-springboot 项目打包出来的镜像

```sh
pipeline {
    agent any

    stages {
        stage('clone') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '0d41310d-a4b9-4c28-bc22-c28849deda15', url: 'http://192.168.19.10:8000/root/hello-springboot.git']]])
            }
        }
        stage('package') {
            steps {
                sh 'mvn clean package dockerfile:build dockerfile:push'
            }
        }
    }
}

```

# 附加内容：Authenticating with maven settings

如果为了安全起见，你不想把 docker 仓库的地址、用户名、密码写在 pom.xml 里，那 dockerfile-maven-plugin 提供了 [Authenticating with maven settings](https://github.com/spotify/dockerfile-maven/blob/master/docs/authentication.md#authenticating-with-maven-settingsxml)  方法。用这个方法我成功了，说一个我当时懵逼的点：

your maven settings file 是指 maven 的 settings.xml (就是你配置阿里云镜像那个 setting.xml) 。这个地方不要配错了，在哪里执行的 `mvn dockerfile:push` 就配置哪里的 settings.xml ，如果你像我一样，在虚拟机上执行的  `mvn dockerfile:push` ，那就要修改虚拟机上的 settings.xml ，修改本地的 settings.xml 是没用的！







