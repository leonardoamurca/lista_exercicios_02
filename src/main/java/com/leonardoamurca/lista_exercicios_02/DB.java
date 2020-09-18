package com.leonardoamurca.lista_exercicios_02;

import java.util.ArrayList;
import java.util.List;

class DB implements BaseDB {

    private ArrayList<Book> books;
    private static final int BOOKS_STORAGE_LIMIT = 4;

    public DB() {
        books = new ArrayList<>();
    }

    @Override
    public BaseDB create() {
        return new DB();
    }

    @Override
    public boolean insert(Book book) {
        if (books.size() < BOOKS_STORAGE_LIMIT) {
            books.add(book);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                books.remove(book);
                return true;
            }
        }

        return false;
    }

}