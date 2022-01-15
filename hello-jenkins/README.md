---
title: hello-jenkins
tags: 
date: 2022-01-15 14:17:04
id: 1642227424159264600
---
# 摘要

Jenkins 的安装

# 虚拟机准备

- 系统：CentOS Linux release 7.9.2009 (Core)
- IP 地址：192.168.19.10
- 内存：8G

# 安装Jenkins

## 安装 jdk

jenkins 基于Java ，所以这里需要安装 jdk 

### 版本选择

这里我选择 jdk-11.0.12_linux-x64_bin.tar.gz | [下载地址](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) 

### 安装

这里就说一点：**把 jdk 安装到指定路径** 。下面是 **jdk-11.0.12_linux-x64_bin.tar.gz** 安装脚本，把 **jdk-11.0.12_linux-x64_bin.tar.gz** 上传到虚拟机，粘贴以下命令即可：

```sh
# 这个路径是 jenkins 的默认 jdk 路径之一,如果你把 jdk 装在这个目录下,后面就不用改配置文件了
JDK_FOR_JENKINS=/usr/lib/jvm/java-11.0
# 创建 jdk 存放目录
mkdir -p ${JDK_FOR_JENKINS}
# 解压 jdk-11.0.12_linux-x64_bin.tar.gz 
tar -zxvf jdk-11.0.12_linux-x64_bin.tar.gz
# 移动到 jenkins 的默认 jdk 路径
mv jdk-11.0.12/* ${JDK_FOR_JENKINS} && rmdir jdk-11.0.12
# 配置环境变量
cp /etc/profile /etc/profile.backup
echo "JAVA_HOME=${JDK_FOR_JENKINS}" >> /etc/profile
echo "JRE_HOME=\${JAVA_HOME}/jre" >> /etc/profile
echo "CLASSPATH=.:\${JAVA_HOME}/lib:\${JRE_HOME}/lib" >> /etc/profile
echo "PATH=\$PATH:\${JAVA_HOME}/bin:\${JRE_HOME}/bin" >> /etc/profile

# 重新加载 /etc/profile
source /etc/profile
# 查看是否安装完成
java -version
```











