#!/usr/bin/env bash
export LANG="en_US.UTF-8"

#----------------------------------------------------------------------
# 常量配置信息
#----------------------------------------------------------------------

# 远程服务器 ip
remote_server_ip='10.50.12.38'
username='root'
# !确保远程文件夹 /home/jar-service 存在
jar_store_dir='/home/jar-service/test'

#----------------------------------------------------------------------
# 脚本
#----------------------------------------------------------------------

# 构建项目
echo "正在构建..."
gradle build -x test

if [[ $? != 0 ]]; then
  echo "构建失败"
  exit 1
fi
echo "构建成功"

# 将jar 包 scp 值目标服务器指定目录下
if [[ -f build/libs/*.jar ]]; then
  echo "正在上传 jar 包..."
  cp run.sh build/libs/
  scp -r build/libs/ ${username}@${remote_server_ip}:${jar_store_dir}
  if [[ $? != 0 ]]; then
    echo "上传失败"
    exit 1
  fi
fi
echo "上传成功"

# ssh远程启动jar
ssh ${username}@${remote_server_ip} ${jar_store_dir}/run.sh restart *.jar
exit 0
