package com.leonardoamurca.lista_exercicios_02;

public class Fibonacci {
    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
