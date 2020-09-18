package com.leonardoamurca.lista_exercicios_02;

interface BaseDB {
    BaseDB create();

    boolean insert(Book book);

    boolean delete(int bookId);

}
