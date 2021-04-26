# Cassandra and Cassandra Stress Testing

## Cassandra Tips

1. Cassandra doesn't delete dropped tables' data until a specified number of seconds called `gc_grace_seconds` has passed (by default `864000`). They are marked with a "tombstone" and every table has this value. To change this for testing cleanup, just run `ALTER TABLE transcript.transcripts_by_content WITH gc_grace_seconds = 5;`. We can then check again with `SELECT table_name,gc_grace_seconds FROM system_schema.tables WHERE keyspace_name='transcript';`. Of course you can also always manually delete the data. The Cassandra Stress tool below does **NOT** delete data after populating it so beware!

## Cassandra Stress Tool

### Quickstart

1. First make sure your cassandra cluster is up and running. Default port is `9042` but can be changed with `-port` option.

2. `./cassandra-stress user profile=controlef.yml n=5000 ops(insert=3,read1=1) -rate threads=1 -graph file=test.html title=test revision=test1`

3. The yaml file contains all the config and queries used in the above. `n` refers to number of operations and `ops` is the number and ratio of ops in each batch. For eg, `ops(insert=3,read1=1)` means 3 inserts for every read in one batch. `-graph` option will make a html with a not-so-beautiful graph.

### More complex example

`./cassandra-stress user profile=controlef.yml n=100000 cl=ONE ops\(insert=1\) -rate threads=1 -graph file=test.html title=test revision=test1 -node localhost,localhost:4127 -pop seq=1..100000`

- the `graph` option tells the stress-er to generate an HTML graph.

- `cl` - consistency level. Check [here](https://docs.datastax.com/en/cql-oss/3.3/cql/cql_reference/cqlshConsistency.html).

### Our experiment

1. Insert desired `n` number of records.
`./cassandra-stress user profile=controlef.yml n=100000 cl=ONE ops\(insert=1\) -rate threads=1 -graph file=test.html title=test revision=test1 -node localhost,localhost:4127 -pop seq=1..100000`

2. Read incrementally using `-pop seq=1..m`. Each read test has 200 queries and is averaged.
