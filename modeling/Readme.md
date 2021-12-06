# version1

## 선행작업

1. cmder download
2. 7zip download
3. portainer 설치 

## image 올려서 container 생성

1. portainer에서 사용할 volume 생성

``` python
# cmder 창
docker volume create portainer_data
docker run -d -p 9999:9000 --name portainer -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data --restart=always portainer/portainer-ce
```

2. docker 이미지 올리기

``` python
# cmder 창
cd <docker image 경로>
docker load -i sejin_pororo_base.tar
```

2. stack 생성

``` python
# localhost:9999 접속 > Stacks 클릭 > Add volumes 클릭

# Use Sejin Project Stack
version: '3.6'

services:
  pororo:
    image: sejin/pororo:base
    container_name: sejin-pororo
    hostname: sejin-pororo
    restart: always
    # tty: true
    command: /app/jupyter_start.sh 
    # working_dir: /workspave
    ports:
      - 8888:8888
    volumes:
      - /C/Users/82105/Storage/Project/Brief:/workspace

#volumes:
#  volume_data:
```





# version2

## 선행작업

1. sublime text download
2. postman download
3. insomia download 

## 이미지 변경

1. docker container 접속 후, flask & flask_restful 설치

```python
# cmder 창

# docker 실행중인 container 조회
docker ps
# docker container 실행
docker start sejin-pororo
# docker container 접속
docker exec -it sejin-pororo bash

# flask 설치
pip install flask
# flask_restful 설치
pip install flask_restful
exit
```

2. 이미지 변경

``` python
# cmder 창
docker commit -p sejin-pororo sejin/pororo:1
```

3. stack 수정

- localhost:9999 접속 > Stacks 클릭 > pjt 클릭 > Editor
  - "image : sejin/pororo:1" 로 수정
  - "ports : 8080:8080" 추가

4. rest API 개발

- Storage > Project > Pororo > api > 개발파일(.py) 생성

5. postman & insomia 통해 api 호출

``` python
# cmd 창
docker exec -it sejin-pororo bash
cd /workspace/
cd api
python summary_rest_api.py
```





# Docker RUN

## container run

```
# jupyter port : 8888
# volume : D:\Project\Sejin:/workspace
# command : /app/jupter_start.sh
# image name : sejin/pororo:base

docker run -it --name sejin-pororo --hostname sejin-pororo -p 8888:8888 -v D:\Project\Sejin:/workspace sejin/pororo:base

# jupyter 실행
root@sejin-pororo# cd /app
root@sejin-pororo# ./jupyter_start.sh
# jupyter password : new1234!
```

## Brower 확인

```
http://localhost:8888
```

