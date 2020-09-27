# Lista de Exercícios 02 - Testes de Software

#### 01. (ENADE 2011) Uma equipe está realizando testes com o código-fonte de um sistema. Os testes envolvem a verificação de diversos componentes individualmente, bem como das interfaces entre eles. Essa equipe está realizando testes de:

a. unidade \
b. aceitação \
c. sistema e aceitação\
d. integração e sistema\
**e. unidade e integração**
    
#### 02. Descreva três benefícios associados ao uso de testes de unidade.

Os testes de unidade possuem diversos benefícios, dentre eles estão:
- Melhoria na qualidade do código;
- Facilita mudanças e é uma ferramenta essencial durante refatorações;
- Gera documentação.

#### 03. Suponha uma função `fib(n)`, que retorna o n-ésimo termo da sequência de Fibonacci, isto é, `fib(0)=0, fib(1)=1, fib(2)=1, fib(3)=2, fib(4)=3`, etc. Escreva um código em Java de teste de unidade para essa função.

Os testes escritos para essa questão está no arquivo [FibonacciTest](https://github.com/leonardoamurca/lista_exercicios_02/blob/master/src/test/java/com/leonardoamurca/lista_exercicios_02/FibonacciTest.java).

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

```java
import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        // teste 1
        List<Integer> s = new ArrayList<Integer>();
        System.out.println(s.isEmpty());
    
        // teste 2
        s = new ArrayList<Integer>();
        s.add(1);
        System.out.println(s.isEmpty());
    
        // teste 3
        s = new ArrayList<Integer>();
        s.add(1);
        s.add(2);
        s.add(3);
        System.out.println(s.size());
        System.out.println(s.get(0));
        System.out.println(s.get(1));
        System.out.println(s.get(2));
    
        // teste 4
        s = new ArrayList<Integer>();
        s.add(1);
        s.add(2);
        s.add(3);
        int elem = s.remove(2);
        System.out.println(elem);
        System.out.println(s.get(0));
        System.out.println(s.get(1));
    
        // teste 5
        s = new ArrayList<Integer>();
        s.add(1);
        s.remove(0);
        System.out.println(s.size());
        System.out.println(s.isEmpty());
        
        // teste 6
        try {
            s = new ArrayList<Integer>();
            s.add(1);
            s.add(2);
            s.remove(2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBound");
        }
    }
}
```

Resolução no arquivo [ArrayListTest](https://github.com/leonardoamurca/lista_exercicios_02/blob/master/src/test/java/com/leonardoamurca/lista_exercicios_02/ArrayListTest.java).

#### 06. Seja a seguinte função. Observe que ela possui quatro comandos, sendo dois deles if. Logo, esses dois ifs geram quatro branches:

```java
void f(int x, int y) {
    if (x > 0) {
        x = 2 * x;
        if (y > 0) {
            y = 2 * y;
        }
    }
}
```

| Chamada feita pelo teste | Cobertura de comandos | cobertura de branches |
|--------------------------|-----------------------|-----------------------|
| f(0, 0)                  | 1                     | 1                     |
| f(1, 1)                  | 4                     | 2                     |
| f(0, 0) e f(1, 1)        | 4                     | 3                     |

#### 07. Suponha o seguinte requisito: alunos recebem conceito A em uma disciplina se tiverem nota maior ou igual a 90. Seja então a seguinte função que implementa esse requisito:

```java
boolean isConceitoA(int nota) {
    if (nota > 90)
        return true;
    else return false;
}
```

##### O código dessa função possui três comandos, sendo um deles um if; logo, ela possui dois branches. 

##### Responda agora às seguintes perguntas.

##### a. A implementação dessa função possui um bug? Se sim, quando esse bug resulta em falha?
Sim. Quando a entrada for 90 o requisito original não será contemplado.

##### b. Suponha que essa função — exatamente como ela está implementada — seja testada com duas notas: 85 e 95. Qual a cobertura de comandos desse teste? E a cobertura de branches?
   - Para a entrada 85:
      - Cobertura de comandos: 2
      - Cobertura de branches: 1
      
   - Para a entrada 90:
      - Cobertura de comandos: 2
      - Cobertura de branches: 1  

Cobertura total de comandos: 3
Cobertura total de branches: 2

##### c.Seja a seguinte afirmação: se um programa possui 100% de cobertura de testes, em nível de comandos, ele está livre de bugs. Ela é verdadeira ou falsa? Justifique.
Falsa. A cobertura de testes considera as linhas de código que foram executadas, porém, caso tenhamos estruturas condicionais e não testarmos todas as combinações possíveis, os testes não conseguirão prevenir 100% o sistema de BUGs.
Em outras palavras, deveríamos testar todas as possíveis branches do código para que o sistema seja mais resiliente à BUGs.

#### 08 Complete os comandos assert nos trechos indicados.

```java
public void test1() {
    LinkedList list = mock(LinkedList.class);
    when(list.size()).thenReturn(10);
    assertEquals(10, list.size());
}
```

```java
public void test2() {
    LinkedList list = mock(LinkedList.class);
    when(list.get(0)).thenReturn("Engenharia");
    when(list.get(1)).thenReturn("Software");
    String result = list.get(0) + " " + list.get(1);
    assertEquals("Engenharia Software", result);
}
```

#### 09. Suponha duas unidades de código A e B, sendo que A depende de B. Para permitir o teste de unidade de A foi criado um mock para B, chamado B'. O teste de unidade de A está passando. Porém, ao fazer o teste de integração com A e B, ele falha. Descreva um cenário mais real, no qual A, B, e B' sejam classes reais, com métodos reais, que realizam funções reais, etc. O cenário proposto deve incluir um bug associado ao mock B'. Ou seja, B' esconde um bug, que só vai aparecer no teste de integração. Dizendo de outra maneira, B' não simula precisamente o comportamento de B; quando B' é removido, no teste de integração, surge então um bug.
O cenário que criei, define a classe [BookService](https://github.com/leonardoamurca/lista_exercicios_02/blob/master/src/main/java/com/leonardoamurca/lista_exercicios_02/BookService.java) como `A`, a classe [DB](https://github.com/leonardoamurca/lista_exercicios_02/blob/master/src/main/java/com/leonardoamurca/lista_exercicios_02/DB.java) como `B` e a classe [MockedDB](https://github.com/leonardoamurca/lista_exercicios_02/blob/master/src/main/java/com/leonardoamurca/lista_exercicios_02/MockedDB.java) como `B'`. Os testes criados demonstrando que a integração real não funciona, está na classe [BookServiceTest](https://github.com/leonardoamurca/lista_exercicios_02/blob/master/src/test/java/com/leonardoamurca/lista_exercicios_02/BookServiceTest.java).


## Rodando o projeto em sua máquina

Esse projeto utiliza o gradle como gerenciador de dependências, portanto, garanta que sua IDE tenha suporte para projetos que utilizam o gradle. Neste guia, mostrarei como rodar o projeto na IDE Eclipse.

### Passos para rodar o projeto no Eclipse IDE

- 1: Importe esse projeto para sua máquina utilizando o comando: `git clone https://github.com/leonardoamurca/lista_exercicios_02.git`.
- 2: Abra sua IDE, clique em File > Import.
- 3: Abrirá uma janela, em seguida, selecione Gradle > Existing Gradle Project.
- 4: Prossiga até chegar na tela para selecionar o diretório com o projeto.
- 5: Selecione o caminho para o diretório que você clonou no passo 1 e clique em Finish.

E pronto, o Eclipse irá importar as dependências do projeto e você agora poderá executaer as classes normalmente. :)


