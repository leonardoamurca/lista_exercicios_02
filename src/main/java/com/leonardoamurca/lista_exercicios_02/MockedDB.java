package com.leonardoamurca.lista_exercicios_02;

import java.util.ArrayList;

class MockedDB implements BaseDB {

    @Override
    public BaseDB create() {
        return new MockedDB();
    }

    @Override
    public boolean insert(Book book) {
        return true;
    }

    @Override
    public boolean delete(int bookId) {
        return true;
    }

}
