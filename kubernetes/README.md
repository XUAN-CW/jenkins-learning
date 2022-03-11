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

check：

```sh
kubectl get serviceaccount -n jenkins-agents
```

## Create a Role and Rolebinding



创建 `jenkins-agent.yaml` ：

```yaml
kind: Role
apiVersion: rbac.authorization.k8s.io/v1beta1
metadata:
  name: jenkins-agent
  namespace: jenkins-agents
rules:
- apiGroups: [""]
  resources: ["pods"]
  verbs: ["create","delete","get","list","patch","update","watch"]
- apiGroups: [""]
  resources: ["pods/exec"]
  verbs: ["create","delete","get","list","patch","update","watch"]
- apiGroups: [""]
  resources: ["pods/log"]
  verbs: ["get","list","watch"]

```

apply：

```sh
kubectl apply -f jenkins-agent.yaml
```

检查：

```
kubectl get role jenkins-agent -n jenkins-agents
```

## Create a Rolebinding

创建 `jenkins-agent-role-binding.yaml` ：

```yaml
apiVersion: rbac.authorization.k8s.io/v1beta1
kind: RoleBinding
metadata:
  name: jenkins-agent
  namespace: jenkins-agents
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: Role
  name: jenkins-agent
subjects:
- kind: ServiceAccount
  name: jenkins-agent

```

apply：

```sh
kubectl apply -f jenkins-agent-role-binding.yaml
```

检查：

```
kubectl get rolebinding -n jenkins-agents
```



# 参考

 [Jenkins Kubernetes Plugin_ Running Agents In Other Clusters.html](assets\references\Jenkins Kubernetes Plugin_ Running Agents In Other Clusters.html) 

 [k8s_Jenkins_GitLab-自动化部署项目.html](assets\references\k8s_Jenkins_GitLab-自动化部署项目.html) 

 [kubernetes中部署Jenkins并简单使用.html](assets\references\kubernetes中部署Jenkins并简单使用.html) 



https://devopscube.com/jenkins-build-agents-kubernetes/
