---
title: Jenkins的kubernetes集群
tags: 
date: 2022-03-22 19:08:46
id: 1647947326284002500
---
# 摘要

首先，我参考 [How To Setup Jenkins On Kubernetes Cluster.html](assets\references\How To Setup Jenkins On Kubernetes Cluster.html) 在 Kubernetes 中搭建了集群，然后，我参考 [How-to-Use-Kubernetes-Pods-As-Jenkins-Agents.md](assets\references\How-to-Use-Kubernetes-Pods-As-Jenkins-Agents.md) （内含视频）使用 Jenkins 运行了 job



# kubernetes 搭建 Jenkins 集群

不废话了， [How To Setup Jenkins On Kubernetes Cluster.html](assets\references\How To Setup Jenkins On Kubernetes Cluster.html) 说得很清楚了

# 使用 Jenkins 

参考 [How-to-Use-Kubernetes-Pods-As-Jenkins-Agents.md](assets\references\How-to-Use-Kubernetes-Pods-As-Jenkins-Agents.md) （内含视频）

## 安装插件

安装名为  **kubernetes** 的插件

## 移除所有在 controller 的 executor

### 进入管理界面

点击 Manage Jenkins → Manage Nodes and Clouds ，你会看见：

![image-20220326122949877](assets/images/image-20220326122949877.png)

然后依次点击： **Built-In Node** （名字可能不一样，但应该是差不多的）→ Configure 

![image-20220326123154384](assets/images/image-20220326123154384.png)

### 移除所有在 controller 的 executor

1. Number of executors：填 **0** 就好
2. Labels：随便，我乱写的
3. Usage：选择 **Only build jobs with label expressions matching this node** 

![image-20220326123326193](assets/images/image-20220326123326193.png)





# 参考

-  [How To Setup Jenkins Build Agents On Kubernetes Pods.html](assets\references\How To Setup Jenkins Build Agents On Kubernetes Pods.html) 
- 教程 [How To Setup Jenkins On Kubernetes Cluster.html](assets\references\How To Setup Jenkins On Kubernetes Cluster.html) | 资料 [kubernetes-jenkins.7z](assets\data\kubernetes-jenkins.7z) 

