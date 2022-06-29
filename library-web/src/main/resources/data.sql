truncate table books cascade ;
truncate table users cascade ;
truncate table  book_collection cascade ;

insert into book_collection(name) values ('java');
insert into book_collection(name) values ('spring');

insert into users(username, password, collection_books_name)
VALUES ('stoianivanov', '1234567', 'java');

insert into users(username, password, collection_books_name)
VALUES ('gminkov', 'topa', 'spring');

insert into books(isbn,genre, title, author)
VALUES ('1231976','sport', 'Tennis advanced', 'Terry Pratchet');

insert into books(isbn,genre, title, author)
VALUES ('1821930','sport', 'Lets go gym', 'Ivo Siromahov');

insert into books(isbn,genre, title, author)
VALUES ('1231126','action', 'Transformers', 'Michael Jackson');

insert into books(isbn,genre, title, author)
VALUES ('8372930','drama', 'Romeo and Juliette', 'Jules Verne');

insert into notes(note, isbn)
VALUES ('This is an amazing book', '1821930');

insert into notes(note, isbn)
VALUES ('Wish there was more', '1821930');

insert into notes(note, isbn)
VALUES ('Taught me to be a better person', '1231976');