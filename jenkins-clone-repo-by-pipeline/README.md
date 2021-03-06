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

| name     | version | 安装位置           |
| -------- | ------- | ------------------ |
| jenkins  | 2.289.3 | Jenkins 所在服务器 |
| git      | 1.8.3.1 | Jenkins 所在服务器 |
| Pipeline | 2.6     | Jenkins 插件       |
| Git      | 4.10.2  | Jenkins 插件       |

## gitlab

想要 clone 代码，那代码总得有个地方放吧。你可能想到了 GitHub ，这确实是一种方案，但估计没有哪家公司会把自家的机密代码放到 GitHub 上，因此这里的代码仓库我们选择 **gitlab-ce:12.4.2-ce.0** 。gitlab 自行安装，这里不过多赘述

#  git 仓库准备

## Create a project

到 gitlab 中创建一个 **jenkins-clone-demo-repo** 仓库，顺便勾选 **Initialize repository with a README** ：

![image-20220115214014997](assets/images/image-20220115214014997.png)

# Jenkins clone 仓库

## 添加凭据

### 添加凭据界面

Manage Jenkins → Manage Credentials → 添加凭据

![image-20220115220301081](assets/images/image-20220115220301081.png)

### 添加凭据

1. 选择凭据种类：Username with password
2. 输入账号密码
3. （非必须）输入描述

![image-20220115220900866](assets/images/image-20220115220900866.png)

## 创建 job

![image-20220115221057440](assets/images/image-20220115221057440.png)

## 创建脚本

### 进入 Pipeline Syntax

![image-20220115221226137](assets/images/image-20220115221226137.png)

### 片段生成器代码生成 clone 片段

1. 选择 **checkout: Check out from version control**
2. 选择 Git
3. 输入被拉取代码所在仓库。这个地方不要手动敲，要到 gitlab 仓库复制
4. 选择进入被拉取代码所需的凭证
5. 生成代码片段

![image-20220115223228154](assets/images/image-20220115223228154.png)

生成的脚本如下：

```groovy
checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '6eb76399-5a78-48a0-90dc-427141198d53', url: 'http://192.168.19.10:8000/root/jenkins-clone-demo-repo.git']]])
```

### 最终脚本

这里我们借助 **Hello World** 生成脚本模板

![image-20220115223640241](assets/images/image-20220115223640241.png)

结合上面片段生成器得到的片段，最终得到：

```groovy
pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '6eb76399-5a78-48a0-90dc-427141198d53', url: 'http://192.168.19.10:8000/root/jenkins-clone-demo-repo.git']]])
            }
        }
    }
}

```

### 填写脚本

1. 选择 **Pipeline script** 
2. 填写 **Script** 
3. 点击 **save** 按钮

![image-20220115225136510](assets/images/image-20220115225136510.png)

## Build Now

![image-20220115224152417](assets/images/image-20220115224152417.png)

## 查看日志

![image-20220115224300091](assets/images/image-20220115224300091.png)

### 查看 clone 的仓库

![image-20220115224915787](assets/images/image-20220115224915787.png)



# Pipeline script from SCM

pipeline 脚本直接写在 Jenkins 里面不便于管理，因此我们需要把它跟我们的项目放在一起

## Jenkinsfile

在刚才 clone 的仓库里添加 **Jenkinsfile** ，里面的内容就是上面填写的脚本，参考 [最终脚本](#最终脚本) 

![image-20220115230105842](assets/images/image-20220115230105842.png)

## configure

1. 选择 **Pipeline script from SCM** 
2. 选择 **Git** 
3. 输入被拉取代码所在仓库。这个地方不要手动敲，要到 gitlab 仓库复制
4. 选择进入被拉取代码所需的凭证
5. 填写 **Script Path** ，这个地方一般不用改，填 Jenkinsfile 就好

![image-20220115230334393](assets/images/image-20220115230334393.png)

















