package books.system.demo.service;

import books.system.demo.model.Book;
import books.system.demo.model.BookCollection;
import books.system.demo.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService{
    //all books
    private BookCollection books = new BookCollection();
    //current user
    private User user =  new User();

    @Override
    public void createList(String name) {
        List<Book> books = new ArrayList<>();
        user.getLists().add(new BookCollection(books, name));
    }

    @Override
    public void addBook(String listName, Book book) {
        for (BookCollection l:
                user.getLists()) {
            if (l.getName().equals(listName)){
                l.getBooks().add(book);
            }
        }
    }

    @Override
    public void deleteBook(String listName, Book book) {
        for (BookCollection l:
                user.getLists()) {
            if (l.getName().equals(listName)){
                l.getBooks().remove(book);
            }
        }
    }

    @Override
    public void addNotes(String notes, Book book) {
        if (user.getNotes().containsKey(book)){
            user.getNotes().replace(book, notes);
            return;
        }
        user.getNotes().put(book, notes);
    }


    @Override
    public Book searchBookByName(String listName, String bookName) {
        for (BookCollection bookCollection:
                user.getLists()) {
            if (bookCollection.getName().equals(listName)){
                return bookCollection.getBooks().stream()
                        .filter(t -> t.getTitle().equals(bookName)).toList().get(0);
            }
        }
        return null;
    }

    @Override
    public BookCollection searchListByName(String listName) {
        for (BookCollection b:
                user.getLists()) {
            if (b.getName().equals(listName)){return b;}
        }
        return null;
    }

    @Override
    public List<Book> groupByAuthor(String author) {
        return this.books.getBooks().stream()
                .filter(t -> t.getAuthor().equals(author)).toList();
    }

    @Override
    public List<Book> groupByGenre(String genre) {
        return this.books.getBooks().stream()
                .filter(t -> t.getGenre().equals(genre)).toList();
    }


}
