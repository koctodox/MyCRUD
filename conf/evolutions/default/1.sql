# --- !Ups

create table "person" ("ID" BIGSERIAL PRIMARY KEY,"NAME" VARCHAR(20),"FAMILY" VARCHAR(20));

# --- !Downs
;
drop table "person";