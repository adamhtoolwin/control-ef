# Cassandra and Cassandra Stress Testing

## Cassandra Stress Tool

### Quickstart

1. First make sure your cassandra cluster is up and running. Default port is `9042` but can be changed with `-port` option.

2. `./cassandra-stress user profile=controlef.yml n=5000 ops(insert=3,read1=1) -rate threads=1 -graph file=test.html title=test revision=test1`

3. The yaml file contains all the config and queries used in the above. `n` refers to number of operations and `ops` is the number and ratio of ops in each batch. For eg, `ops(insert=3,read1=1)` means 3 inserts for every read in one batch. `-graph` option will make a html with a not-so-beautiful graph.
