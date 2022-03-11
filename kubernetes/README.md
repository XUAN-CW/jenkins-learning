---
title: kubernetes
tags: 
date: 2022-03-11 12:28:31
id: 1646972911706652200
---
# 摘要





```sh
kubectl create namespace jenkins-agents
kubectl create serviceaccount jenkins-agent -n jenkins-agents
kubectl get secret $(kubectl get sa jenkins-agent -n jenkins-agents -o jsonpath={.secrets[0].name}) -n jenkins-agents -o jsonpath={.data.token} | base64 --decode
```

