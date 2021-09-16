# jumia-task

## Prerequisite:

Note : I tried many times to push image to my Dockerhub repo account to make it easy for you to pull image and run it directly , <br /> 
but it was failed due to connections errors (time out) , so follow below steps to run app with another way. <br />

jumia-app --> app.jar + sample.db

 1-Install Docker on your machine. <br />
 2-Clone project. <br />
 3-Change directory to cloned project where Docker file exist. <br />
 4-Then run below commands in the directory where docker file exist. <br />

## Create Docker image from Dockerfile:
```bash
path/to/Dockerfile > docker build -t jumiatask .
```

## Run docker container from docker image:
```bash
docker run -p8882:8081 jumiatask
```

## Navigate to following URL:
```bash
http://localhost:8882/jumia/search
```


