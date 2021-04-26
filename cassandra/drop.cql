DROP TABLE transcript.transcripts_by_content;

DROP KEYSPACE transcript;

// CREATE TABLE hotel.hotels_by_poi (
//   poi_name text,
//   hotel_id text,
//   name text,
//   phone text,
//   address frozen<address>,
//   PRIMARY KEY ((poi_name), hotel_id) )
//   WITH comment = ‘Q1. Find hotels near given poi’
//   AND CLUSTERING ORDER BY (hotel_id ASC) ;
