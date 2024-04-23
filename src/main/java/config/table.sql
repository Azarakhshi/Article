CREATE TABLE article
(

    id           SERIAL PRIMARY KEY NOT NULL,
    title        character(30),
    brief        character(30),
    content      character(30),
    create_date  character(30),
    is_published BOOLEAN,
    user_info_id int

);


CREATE TABLE user_info
(
    id            SERIAL PRIMARY KEY NOT NULL,
    user_name     character(30),
    national_code character(30),
    birthday      character(30),
    password      character(30)

);

