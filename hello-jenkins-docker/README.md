---
title: hello-jenkins-docker
tags: 
date: 2022-01-17 04:08:04
id: 1642363684082128500
---
# 摘要



```sh
# 一键部署
docker run \
  -itd \
  -p 8080:8080 \
  -p 50000:50000 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v $(which docker):/usr/bin/docker \
  -v /docker-v/jenkins/jenkins_home:/var/jenkins_home \
  -v /docker-v/jenkins/maven:/usr/local/maven \
  -v /docker-v/jenkins/maven_repository:/usr/local/maven_repository  \
  --name jenkins \
  --restart=always \
  -u root \
  -e JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8 \
  -e JAVA_OPTS=-Duser.timezone=CN \
  -e TZ=Asia/Shanghai \
  jenkins/jenkins:2.289.3-lts-centos7
```





```sh
# 初始化密码
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
# 进入容器
docker exec -it jenkins /bin/bash
```

