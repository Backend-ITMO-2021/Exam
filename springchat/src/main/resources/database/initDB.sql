CREATE TABLE IF NOT EXISTS message_table
(
    message_id    integer PRIMARY KEY ,
    message_sender  VARCHAR(200) NOT NULL ,
    message_text VARCHAR(254) NOT NULL ,
    message_date VARCHAR(254) NOT NULL ,
    message_reply integer
);

