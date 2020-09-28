# NCSU - F20 MSC 540

# Setting up Oracle development environment locally

## Pre requisites 

### Docker, docker-compose 

If you're using MacOS, you can download and install 
- Docker here: https://docs.docker.com/docker-for-mac/install/
- docker-compose here: https://docs.docker.com/compose/install/

If you're not using Mac, ask Dr. Google.

### Get the code: 

```bash
$ git clone https://github.com/dnguyenv/parking.git
```

### Setup Oracle development database environment

```bash
$ cd parking/docker
$ docker-compose up -d
```

Wait for the container successfully started up. You can see the logs by 

```bash
$ docker-compose logs -f 
```

YOu should see something like this:

```bash
oracle-db_1  | Starting Oracle Net Listener.
oracle-db_1  | Starting Oracle Database 11g Express Edition instance.
```

Now you can access the SQLPLUS client inside the container. First you need to know the name of the Oracle db container:

```bash
$ docker ps | grep oracle 
```

Will see something like this:

```bash
docker git:(master) ✗ docker ps | grep oracle
a5b68fe2231d        oracleinanutshell/oracle-xe-11g:latest   "/bin/sh -c '/usr/sb…"   32 hours ago        Up 32 hours         0.0.0.0:1521->1521/tcp, 0.0.0.0:5500->5500/tcp, 22/tcp, 0.0.0.0:8080->8080/tcp   docker_oracle-db_1
```

=> The name is `docker_oracle-db_1`

Then get into the container by:

```bash
$ docker exec -it docker_oracle-db_1 bash
$ docker git:(master) ✗ docker exec -it docker_oracle-db_1 bash
root@a5b68fe2231d:/# sqlplus
SQL*Plus: Release 11.2.0.2.0 Production on Mon Sep 28 04:00:49 2020
Copyright (c) 1982, 2011, Oracle.  All rights reserved.
Enter user-name: system
Enter password: <= Type "oracle" as a password here
Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

SQL>
```


