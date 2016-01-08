set -e

dt=$(date '+%Y%m%d-%H%M%S')

mvn package
gsutil cp Dockerfile  gs://w-dist/
gsutil cp target/wallenius-gcp-0.1-SNAPSHOT-jar-with-dependencies.jar  gs://w-dist/

gcloud compute ssh docker-helper --command "gsutil cp gs://w-dist/* ./ && sudo docker build -t gcr.io/wallenius-k8s/frontend-app-${dt} . && sudo gcloud docker push gcr.io/wallenius-k8s/frontend-app-${dt}"


echo "Built and published new image called gcr.io/wallenius-k8s/frontend-app-${dt}"

echo "Now you probably want to do:"
echo "kubectl rolling-update frontend-rc --image gcr.io/wallenius-k8s/frontend-app-${dt} --update-period 15s"