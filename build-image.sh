#!/usr/bin/env bash

echo 'Building docker image auth-server'
docker build -t eu.gcr.io/stdstack/auth-server:0.1 .
echo 'Image auth-server built'