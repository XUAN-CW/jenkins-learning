---
title: kubernetes
tags: 
date: 2022-03-11 12:28:31
id: 1646972911706652200
---
# 摘要



# RBAC

Role-Based Access Control（基于角色的访问控制）。Jenkins 需要 kubernetes 的控制权限，因此我们这里到 kubernetes 主节点创建账户并获取密钥：

```sh
# 主节点中执行
kubectl create namespace jenkins-agents
kubectl create serviceaccount jenkins-agent -n jenkins-agents
kubectl get secret $(kubectl get sa jenkins-agent -n jenkins-agents -o jsonpath={.secrets[0].name}) -n jenkins-agents -o jsonpath={.data.token} | base64 --decode
```

