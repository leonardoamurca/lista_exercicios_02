# Lista de Exercícios 02 - Testes de Software

#### 01. (ENADE 2011) Uma equipe está realizando testes com o código-fonte de um sistema. Os testes envolvem a verificação de diversos componentes individualmente, bem como das interfaces entre eles. Essa equipe está realizando testes de:

a. unidade \
b. aceitação \
c. sistema e aceitação\
**d. unidade e integração**
    
#### 02. Descreva três benefícios associados ao uso de testes de unidade.

Os testes de unidade possuem diversos benefícios, dentre eles estão:
- Melhoria na qualidade do código;
- Facilita mudanças e é uma ferramenta essencial durante refatorações;
- Gera documentação.

#### 03. Suponha uma função `fib(n)`, que retorna o n-ésimo termo da sequência de Fibonacci, isto é, `fib(0)=0, fib(1)=1, fib(2)=1, fib(3)=2, fib(4)=3`, etc. Escreva um código em Java de teste de unidade para essa função.

Os testes escritos para essa questão está no arquivo `FibonacciTest.java`.

#### 04. Reescreva o seguinte teste, que verifica o levantamento de uma exceção EmptyStackException, para que ele fique mais simples e fácil de entender.

```java
@Test
public void testEmptyStackException() {
    boolean sucesso = false;
    try{
        Stack<Integer> s = new Stack<Integer>();
        s.push(10);
        int r = s.pop();
        r = s.pop();
    } catch (EmptyStackException e) {
        sucesso = true;
    }
    assertTrue(sucesso);
}
```    

Utilizando o JUnit 4, podemos refatorar de seguinte forma:

```java
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowEmptyStackExceptionWhenPopEmptyStack() {
        exceptionRule.expect(EmptyStackException.class);

        Stack s = new Stack();
        s.pop();
    }
```

#### 05. Suponha que um programador escreveu o teste a seguir para aclasse ArrayList de Java. Como você irá perceber, no código são usados diversos System.out.println. Ou seja, no fundo, ele é um teste manual, pois o desenvolvedor tem que conferir o seu resultado manualmente. Reescreva então cada um dos testes (de 1 a 6) como um teste de unidade, usando a sintaxe e os comandos do JUnit.

Resolução no arquivo `ArrayListTest.java`.