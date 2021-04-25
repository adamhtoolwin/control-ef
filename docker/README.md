# Everything Docker

Make sure to pull `postgres:10.16` from dockerhub and of course install Docker.

## Postgres on Puffer

### Setting up the container

- `docker run -d -p 4126:5432 -e POSTGRES_PASSWORD=sekrit --name test-pg postgres:10.16` (for testing and now works!)

- `docker run --rm -d -p 4125:5432 -e POSTGRES_USER=falcon -e POSTGRES_PASSWORD=sekrit -e POSTGRES_DB=controlefdb --name control-pg -v /data/directory:/var/lib/postgresql/data postgres:10.16` (works now too!)

- The env variables `-e` are used to config.

- Lastly, forward port 4125 on local to puffer `ssh -fN -L 4125:localhost:4125 puffer` and test `psql -h localhost -p 4125 -U falcon -d controlefdb`.

### Create the tables from generated DDL

- `psql -h localhost -p 4125 -U falcon -f ../create.sql controlefdb`

### Import from CSV

- `\copy video(id) from videos.csv delimiter ',' csv` (copy just id for video metadata) (path can be absolute or relative i think)

- `\copy transcript(start_time, end_time, content, video_id) from _1VpOweDio8.en.csv delimiter ',' csv header` (for transcripts)

## Apache Cassandra on Puffer

### Prerequsites for client

1. Apache Cassandra binaries (namely `cqlsh`) on client
2. Python 2.7

### Create the network on Docker

- `docker network create controlef`

### Check networks

- `docker network ls`

### Run the latest cassandra image as a container

- `docker run -d -p 4126:9042 --rm --name control-cassandra --network controlef -d cassandra:latest`

### Run container mounting local dir

- `docker run -d -p 4126:9042 --rm --name control-cassandra --network controlef -v /home/corse/st120832/sad/data/cassandra:/var/lib/cassandra -d cassandra:latest`

### (Optional) Run a second node

- `docker run --name control-cassandra2 -d -p 4127:9042 --rm --network controlef -e CASSANDRA_SEEDS=control-cassandra cassandra:latest`

### Check container node status

- `docker exec -it control-cassandra nodetool status`

### Setup ssh tunnel from local to puuffer

- `ssh -L 4126:localhost:4126 puffer`

### Connect from local machine

- `cqlsh localhost 4126`

### Run the init.cql to populate tables and keyspaces

- `cqlsh -f init.cql localhost 4126`

### Import from csv

- `COPY transcript.transcripts_by_content (start_time, end_time, content, video_id) from 'transcripts.csv' with delimiter=',' and header=true ;`
