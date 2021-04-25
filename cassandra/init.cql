CREATE KEYSPACE transcript WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE transcript.transcripts_by_content (
  content text,
  start_time float,
  end_time float,
  video_id text,
  PRIMARY KEY (start_time, video_id));

ALTER TABLE transcript.transcripts_by_content WITH gc_grace_seconds = 5;

CREATE CUSTOM INDEX content_idx ON transcript.transcripts_by_content (content) 
USING 'org.apache.cassandra.index.sasi.SASIIndex' 
WITH OPTIONS = {
'mode': 'CONTAINS', 
'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer', 
'case_sensitive': 'false'};

// CREATE TABLE hotel.hotels_by_poi (
//   poi_name text,
//   hotel_id text,
//   name text,
//   phone text,
//   address frozen<address>,
//   PRIMARY KEY ((poi_name), hotel_id) )
//   WITH comment = ‘Q1. Find hotels near given poi’
//   AND CLUSTERING ORDER BY (hotel_id ASC) ;
