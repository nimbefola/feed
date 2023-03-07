CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;

DROP TABLE IF EXISTS  feed;
create TABLE feed (
    "id" VARCHAR(255) NOT NULL,
    "created" TIMESTAMP NOT NULL,
    "updated" TIMESTAMP NOT NULL,
    "version" INT8 DEFAULT 0,
    "media_url" VARCHAR(255) NULL,
    "message" VARCHAR(255) NOT NULL,
    "comment_id" VARCHAR(255) NULL,
    "status" VARCHAR(255) NOT NULL,
    "username" VARCHAR(255) NOT NULL,
    primary key (id)
);

DROP TABLE IF EXISTS  comment;
create TABLE comment (
    "id" VARCHAR(255) NOT NULL,
    "created" TIMESTAMP NOT NULL,
    "updated" TIMESTAMP NOT NULL,
    "version" INT8 DEFAULT 0,
    "feed_id" VARCHAR(255) NULL,
    "message" VARCHAR(255) NULL,
    "username" VARCHAR(255) NOT NULL,
    primary key (id)
);