package com.leonardoamurca.lista_exercicios_02;

public class BookService {

    private final BaseDB db;

    public BookService(BaseDB db) {
        this.db = db.create();
    }

    public boolean addBook(Book book) {
        return db.insert(book);
    }

    public boolean remove(int bookId) {
        return db.delete(bookId);
    }
}
