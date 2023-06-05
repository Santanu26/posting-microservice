```bash
1. kubectl apply -f .

2. kubectl get all -n=k8-program

User Service: curl http://<node-ip>:30090
Post Service: curl http://<node-ip>:30091

```
```bash
kubectl apply -f namespace.yaml
kubectl apply -f post-db-statefulset.yaml -n k8s-program
kubectl apply -f user-db-statefulset.yaml -n k8s-program
kubectl apply -f post-service-deployment.yaml -n k8s-program
kubectl apply -f post-service-service.yaml -n k8s-program
kubectl apply -f user-deployment.yaml -n k8s-program
kubectl apply -f user-pv.yaml -n k8s-program
kubectl apply -f user-service-service.yaml -n k8s-program

kubectl get pods -n k8s-program

kubectl get services -n k8s-program
```