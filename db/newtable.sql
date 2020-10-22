create table booktype(
    id int NOT NULL PRIMARY KEY,
    name varchar(50)
);

create table user_booktype(
    user_id int NOT NULL,
    book_id int NOT NULL,
    CONSTRAINT PK_profile_book PRIMARY KEY (user_id,book_id),
    FOREIGN KEY (book_id) REFERENCES booktype(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

create table user_search(
    id int NOT NULL PRIMARY KEY,
    search_text varchar(100) NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
)

