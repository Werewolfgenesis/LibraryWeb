truncate table books cascade ;
truncate table authors cascade ;
truncate table users cascade ;
truncate table  book_collection cascade ;

insert into authors(id, first_name, last_name)
    VALUES (1, 'Nasku', 'Ivanov');

insert into authors(id, first_name, last_name)
    VALUES (2, 'Mitku', 'Sotirov');

insert into book_collection(name) values ('java');
insert into book_collection(name) values ('spring');

insert into users(username, password, collection_books_name)
    VALUES ('stoianivanov', '1234567', 'java');

insert into users(username, password, collection_books_name)
VALUES ('gminkov', 'topa', 'spring');

insert into books(isbn,genre, title, author)
    VALUES ('1231976','sport', 'Tennis advanced', 2);

insert into books(isbn,genre, title, author)
    VALUES ('1821930','sport', 'Lets go gym', 1);