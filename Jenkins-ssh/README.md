---
title: Jenkins-ssh
tags: 
date: 2022-03-26 13:30:08
id: 1648272608987162400
---
# 摘要



# 插件安装

1. [SSH Pipeline Steps](https://plugins.jenkins.io/ssh-steps) 

# 测试

新建一个 **Pipeline** job，粘贴下面的 Pipeline 脚本，然后 **Build Now** 

```
node {
    stage("SSH Into Server") {
        def remote = [:]
        remote.name = 'test server'
        remote.host = '172.31.0.2'
        remote.user = 'root'
        remote.password = 'root'
        remote.allowAnyHosts = true

        stage('sh_test') {
          sshCommand remote: remote, command: "ls > test.txt"
        }
    }

}
```

然后就可以在 `172.31.0.2` 上看到 **test.txt** 

# 参考

 [CI_CD Kubernetes _ Setting up CI_CD Jenkins pipeline for kubernetes.html](assets\references\CI_CD Kubernetes _ Setting up CI_CD Jenkins pipeline for kubernetes.html) 
