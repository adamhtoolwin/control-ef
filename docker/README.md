# Everything Docker

Make sure to pull `postgres:10.16` from dockerhub and of course install Docker.

## Postgres on Puffer

### Setting up the container

- `docker run -d -p 4126:5432 -e POSTGRES_PASSWORD=sekrit --name test-pg postgres:10.16` (for testing and now works!)

- `docker run --rm -d -p 4125:5432 -e POSTGRES_USER=falcon -e POSTGRES_PASSWORD=sekrit -e POSTGRES_DB=controlefdb --name control-pg postgres:10.16` (works now too!)

- The env variables `-e` are used to config.

- Lastly, forward port 4125 on local to puffer `ssh -fN -L 4125:localhost:4125 puffer` and test `psql -h localhost -p 4125 -U falcon -d controlefdb`.

### Create the tables from generated DDL

- `psql -h localhost -p 4125 -U falcon -f ../create.sql controlefdb`
