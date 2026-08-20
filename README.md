# Projeto Cardápio

Este projeto é um exercício de Java que modela um cardápio usando orientação a
objetos. Ele permite criar itens, organizar esses itens em um cardápio,
consultar um item pelo identificador e calcular informações como desconto,
imposto e total de preços.

## Estrutura do projeto

```text
src/
└── com.LaPlaga/
    ├── cli/
    │   └── Aula1.java
    └── modelo/
        ├── Cardapio.java
        ├── CategoriaCardapio.java
        ├── ItemCardapio.java
        └── isento/
            └── ItemCardapioIsento.java
```

- `Aula1.java`: camada de interação com o usuário pela linha de comando.
- `Cardapio.java`: agrega e administra os itens disponíveis.
- `ItemCardapio.java`: classe base que representa um item.
- `ItemCardapioIsento.java`: especialização de item sem imposto.
- `CategoriaCardapio.java`: enumeração das categorias possíveis.

## Conceitos utilizados

### Pacotes

O comando `package` organiza as classes em namespaces.

Em [`ItemCardapio.java`](src/com.LaPlaga/modelo/ItemCardapio.java), a classe
pertence ao pacote `com.LaPlaga.modelo`:

```java
package com.LaPlaga.modelo;
```

O `import` permite utilizar uma classe de outro pacote. Por exemplo,
[`Aula1.java`](src/com.LaPlaga/cli/Aula1.java) importa `Cardapio` e
`ItemCardapio` para usá-los na interface de linha de comando.

### Classe e objeto

Uma classe é um molde que define dados e comportamentos. Em
`ItemCardapio.java`, a declaração:

```java
public class ItemCardapio
```

define o modelo de um item. Um objeto é uma instância dessa classe, criada com
`new`, como ocorre em [`Cardapio.java`](src/com.LaPlaga/modelo/Cardapio.java):

```java
ItemCardapio item1 =
    new ItemCardapio(1, "Suco", "É um suco", 2.66, 1,
                     CategoriaCardapio.BEBIDAS);
```

### Atributos e tipos

Os atributos armazenam o estado de cada objeto. Em `ItemCardapio.java` são
usados:

- `String` para `nome` e `descricao`;
- `boolean` para `emPromocao`;
- `double` para valores monetários;
- `long` para o identificador `id`;
- `CategoriaCardapio` para a categoria.

O modificador `private` impede o acesso direto aos atributos fora da classe.
Isso protege o estado do objeto e é parte do conceito de **encapsulamento**.

### Encapsulamento e métodos de acesso

Os métodos `getNome()`, `getDescricao()`, `getPreco()`, `getId()` e os demais
`getters` de `ItemCardapio.java` fornecem acesso controlado aos dados.

Para atributos booleanos, a convenção usada é `isEmPromocao()`:

```java
public boolean isEmPromocao() {
    return emPromocao;
}
```

### Construtor

O construtor inicializa o objeto no momento do `new`. Ele possui o mesmo nome
da classe e não possui tipo de retorno:

```java
protected ItemCardapio(long id, String nome, String descricao,
                       double preco, int precoDesconto,
                       CategoriaCardapio categoria)
```

O modificador `protected` permite que o construtor seja usado no mesmo pacote
e por classes filhas. Por isso ele pode ser chamado por `Cardapio.java` e por
`ItemCardapioIsento.java`.

### Palavra-chave `this`

No construtor, `this.id` representa o atributo pertencente ao objeto, enquanto
`id` representa o parâmetro recebido:

```java
this.id = id;
```

O mesmo padrão é usado para `nome`, `descricao`, `preco`, `precoDesconto` e
`categoria`.

### Métodos, parâmetros e retorno

Um método define um comportamento. Em `ItemCardapio.java`:

```java
public double calculaPorcentagemDesconto() {
    return (preco - precoDesconto) / preco;
}
```

Esse método recebe os valores já armazenados no objeto e retorna um `double`.
O método `definePromocao(double precoComDesconto)` recebe um parâmetro, altera
o estado do objeto e usa `void`, pois não retorna valor.

O cálculo retorna uma fração. Por exemplo, `0.25` representa 25%; para exibir
diretamente como porcentagem, seria necessário multiplicar o resultado por
`100`.

### Condicional `if/else`

O método `getImposto()` escolhe o preço usado no cálculo conforme o item esteja
ou não em promoção:

```java
if (emPromocao) {
    imposto = precoDesconto * 0.1;
} else {
    imposto = preco * 0.1;
}
```

### Herança

[`ItemCardapioIsento.java`](src/com.LaPlaga/modelo/isento/ItemCardapioIsento.java)
usa `extends` para herdar atributos e métodos de `ItemCardapio`:

```java
public class ItemCardapioIsento extends ItemCardapio
```

Assim, um `ItemCardapioIsento` também pode ser tratado como
`ItemCardapio`, como nos itens criados em `Cardapio.java`.

### `super`

O construtor da classe filha chama o construtor da classe mãe com `super(...)`:

```java
super(id, nome, descricao, preco, precoDesconto, categoria);
```

Isso garante que a parte herdada do objeto seja inicializada corretamente.

### Polimorfismo e sobrescrita

`ItemCardapioIsento` sobrescreve `getImposto()`:

```java
@Override
public double getImposto() {
    return 0.0;
}
```

Quando `Cardapio.java` percorre o array e chama `item.getImposto()`, Java
executa a implementação correspondente ao tipo real do objeto. Itens comuns
calculam 10% de imposto; itens isentos retornam `0.0`. Esse comportamento é
**polimorfismo**.

### Enumeração

`CategoriaCardapio.java` define um conjunto fixo de valores:

```java
public enum CategoriaCardapio {
    ENTRADAS, PRATOS_PRINCIPAIS, SOBREMESSAS, BEBIDAS
}
```

O enum evita textos livres e reduz erros ao representar categorias. O uso
aparece, por exemplo, em `CategoriaCardapio.BEBIDAS`.

### Array e laço `for-each`

`Cardapio.java` mantém os itens em um array:

```java
private final ItemCardapio[] itens;
```

O array tem tamanho fixo e é preenchido no construtor. O `for-each` percorre
cada elemento sem exigir controle manual de índices:

```java
for (ItemCardapio item : itens) {
    totalDePreco += item.getPreco();
}
```

Esse padrão é usado para somar preços e contar itens em promoção.

### `final`

O atributo `itens` é `final`, portanto sua referência deve ser inicializada uma
vez. O conteúdo do array ainda pode ser preenchido durante a construção do
`Cardapio`.

### CLI, entrada e conversão

Em [`Aula1.java`](src/com.LaPlaga/cli/Aula1.java), `IO.readln(...)` lê o texto
digitado. Como a entrada é uma `String`, `Long.parseLong(linha)` converte o
valor para `long`:

```java
String linha = IO.readln("Digite um ID de um item do cardapio: ");
long idselecionado = Long.parseLong(linha);
```

`IO.println(...)` escreve os resultados no console. A forma `void main()` e a
classe `IO` são recursos do modelo simplificado de execução presente nas
versões recentes do Java; em projetos tradicionais, normalmente é usado
`public static void main(String[] args)`.

### Busca por identificador

`Cardapio.getItemPorId(long idSelecionado)` transforma o ID em índice do array:

```java
return itens[((int) idSelecionado) - 1];
```

Como arrays começam no índice `0` e os IDs começam em `1`, o método subtrai
`1`. Portanto, o ID `1` acessa `itens[0]`.

## Fluxo de execução

1. `Aula1` cria um objeto `Cardapio`.
2. O construtor de `Cardapio` cria itens comuns e itens isentos.
3. O usuário informa um ID.
4. O cardápio localiza o item correspondente.
5. `Aula1` consulta os getters e calcula desconto, preço e imposto.
6. O programa exibe totais e itens cujo preço está abaixo de `10.00`.

## Observações importantes

- `emPromocao` começa como `false`; ele só se torna `true` quando
  `definePromocao(...)` é chamado.
- `calculaPorcentagemDesconto()` retorna uma fração, não um número já
  multiplicado por `100`.
- `getItemPorId()` pressupõe um ID entre `1` e `6`; IDs inválidos podem causar
  `ArrayIndexOutOfBoundsException`.
- Para valores financeiros reais, `BigDecimal` costuma ser mais apropriado que
  `double`, pois evita imprecisões binárias.
