CREATE TABLE article
(

    id           integer,
    title        character,
    brief        character,
    content      character,
    create_date   character,
    is_published BOOLEAN,
    user_id      integer

);


CREATE TABLE user_info
(
    id           integer,
    user_name     character,
    national_code character,
    birthday     character,
    password     character

)