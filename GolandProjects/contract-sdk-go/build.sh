#!/bin/bash

DIR="/home/contract_docker_go/target/release/"

if [ ! -d $DIR ]; then
  mkdir -p $DIR
fi

echo "please input zip file name (no suffix): "
read zip_file
go build -ldflags="-s -w" -o $zip_file

7z a $zip_file $zip_file
mv $zip_file.7z $DIR