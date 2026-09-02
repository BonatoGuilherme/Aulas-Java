# Projeto Cardápio

Este projeto é um exercício de Java que modela um cardápio usando orientação a
objetos. Ele permite criar itens de cardápio, organizar esses itens,
consultar um item pelo identificador e calcular informações como desconto,
imposto e total de preços. Os dados podem ser carregados de arquivos JSON ou CSV.

## Estrutura do projeto

```text
src/
└── com.LaPlaga/
    ├── cli/
    │   ├── Aula1.java                    (Interface de linha de comando)
    │   └── TesteObjetos.java
    ├── modelo/
    │   ├── Cardapio.java                 (Gerenciador de itens)
    │   ├── CategoriaCardapio.java        (Enumeração de categorias)
    │   ├── ItemCardapio.java             (Classe base de itens)
    │   └── isento/
    │       └── ItemCardapioIsento.java   (Itens sem imposto)
    └── leitor/
        ├── LeitorItensCardapio.java      (Interface para leitores)
        ├── LeitorItensCardapioBase.java  (Classe abstrata base)
        ├── LeitorItensCardapioCSV.java   (Leitor de arquivos CSV)
        └── LeitorItensCardapioJSON.java  (Leitor de arquivos JSON)

Arquivos de dados:
├── itens-cardapio.csv                   (Dados em formato CSV)
└── itens-cardapio.json                  (Dados em formato JSON)
```

### Descrição dos Arquivos

#### Camada `modelo/` (Model Layer)
- **`ItemCardapio.java`**: Classe base que representa um item do cardápio com atributos como ID, nome, descrição, preço, categoria e promoção.
- **`ItemCardapioIsento.java`**: Especialização que herda de `ItemCardapio` para itens isentos de imposto.
- **`Cardapio.java`**: Gerenciador que agrega um array de itens e fornece operações como busca por ID, soma de preços e contagem de itens em promoção.
- **`CategoriaCardapio.java`**: Enumeração com as categorias possíveis: `ENTRADAS`, `PRATOS_PRINCIPAIS`, `SOBREMESAS`, `BEBIDAS`.

#### Camada `leitor/` (Reader/Parser Layer)
- **`LeitorItensCardapio.java`**: Interface que define o contrato para leitura de arquivos.
- **`LeitorItensCardapioBase.java`**: Classe abstrata que fornece a lógica comum de leitura de arquivos (ler arquivo, dividir linhas).
- **`LeitorItensCardapioCSV.java`**: Implementação que processa arquivos CSV. Esperado formato: `id;nome;descricao;preco;categoria;emPromocao;precoDesconto;impostoIsento`
- **`LeitorItensCardapioJSON.java`**: Implementação que processa arquivos JSON com estrutura de objetos.

#### Camada `cli/` (Command Line Interface)
- **`Aula1.java`**: Programa principal que interage com o usuário. Solicita um arquivo, carrega os itens, permite consultar um item por ID e exibe informações detalhadas sobre o item e o cardápio.
- **`TesteObjetos.java`**: Arquivo auxiliar para testes.



## Guia de Uso

### Executar o Programa

1. Compile o projeto:
```bash
javac -d out -sourcepath src src/com/LaPlaga/cli/Aula1.java
```

2. Execute a aplicação:
```bash
java -cp out com.LaPlaga.cli.Aula1
```

3. O programa solicita o nome de um arquivo (ex: `itens-cardapio.csv` ou `itens-cardapio.json`)
4. Após carregar, solicita um ID de item (1 a 6)
5. Exibe informações do item, descontos, impostos e totais

### Formato dos Arquivos de Dados

#### CSV (`itens-cardapio.csv`)
```
id;nome;descricao;preco;categoria;emPromocao;precoDesconto;impostoIsento
1;Suco;É um suco;2.66;BEBIDAS;false;0;false
2;Água;Água mineral;1.50;BEBIDAS;true;1.00;false
```

#### JSON (`itens-cardapio.json`)
```json
{
  "id": 1,
  "nome": "Suco",
  "descricao": "É um suco",
  "preco": 2.66,
  "categoria": "BEBIDAS",
  "emPromocao": false,
  "precoDesconto": 0,
  "impostoIsento": false
}
```

## Conceitos utilizados

### 1. Pacotes

O comando `package` organiza as classes em namespaces. Por exemplo:

```java
package com.LaPlaga.modelo;
```

Isso permite evitar conflitos de nomes e facilita a manutenção.

### 2. Classe ItemCardapio

A classe base que representa um item do cardápio:

```java
public class ItemCardapio {
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private CategoriaCardapio categoria;
    private double precoDesconto;
    private boolean emPromocao;
}
```

**Atributos principais:**
- `id`: Identificador único do item (long)
- `nome`: Nome do item (String)
- `descricao`: Descrição do item (String)
- `preco`: Preço normal do item (double)
- `categoria`: Categoria do item (enumeração CategoriaCardapio)
- `precoDesconto`: Preço com desconto (double)
- `emPromocao`: Indica se o item está em promoção (boolean)

**Métodos principais:**
- `getNome()`, `getDescricao()`, `getPreco()`, `getId()`: Getters para acessar os atributos
- `isEmPromocao()`: Verifica se está em promoção
- `calculaPorcentagemDesconto()`: Retorna a porcentagem de desconto como fração (0.25 = 25%)
- `setPromocao(double precoComDesconto)`: Define um desconto para o item
- `getImposto()`: Calcula o imposto (10% do preço, ou 0% se em promoção)
- `equals()`, `hashCode()`, `toString()`: Métodos padrão do Java

**Construtor:**
```java
public ItemCardapio(long id, String nome, String descricao, 
                    double preco, CategoriaCardapio categoria)
```

### 3. Classe ItemCardapioIsento

Herda de `ItemCardapio` para representar itens sem imposto:

```java
public class ItemCardapioIsento extends ItemCardapio {
    @Override
    public double getImposto() {
        return 0.0;
    }
}
```

**Conceitos utilizados:**
- **Herança**: Estende `ItemCardapio` para reutilizar código
- **Polimorfismo**: Sobrescreve `getImposto()` para retornar sempre 0
- **@Override**: Anotação que indica que o método está sobrescrevendo um método da classe pai

### 4. Classe CategoriaCardapio

Enumeração com as categorias possíveis:

```java
public enum CategoriaCardapio {
    ENTRADAS, PRATOS_PRINCIPAIS, SOBREMESAS, BEBIDAS
}
```

**Uso:**
```java
CategoriaCardapio categoria = CategoriaCardapio.BEBIDAS;
```

### 5. Classe Cardapio

Gerenciador que mantém um array de itens e fornece operações:

```java
public class Cardapio {
    private final ItemCardapio[] itens;
    
    public Cardapio(String nomeArquivo) throws IOException {
        LeitorItensCardapio leitor = LeitorItensCardapio.criarLeitor(nomeArquivo);
        if (leitor != null) {
            itens = leitor.processaArquivo(nomeArquivo);
        } else {
            itens = new ItemCardapio[0];
        }
    }
}
```

**Métodos principais:**
- `getSomaDosPrecos()`: Retorna a soma de todos os preços
- `getTotalDeItensPromocao()`: Conta quantos itens estão em promoção
- `getItemPorId(long idSelecionado)`: Busca um item por ID (retorna `itens[id-1]`)
- `getItens()`: Retorna o array completo de itens

**Características:**
- `itens` é `final`: O array é inicializado uma vez e não pode ser reatribuído
- Usa `throws IOException`: Pode lançar exceção se o arquivo não for encontrado
- Utiliza polimorfismo: `LeitorItensCardapio` retorna diferentes tipos de leitores conforme a extensão

### 6. Leitor de Arquivos (Camada `leitor/`)

#### LeitorItensCardapio (Interface)
Define o contrato para qualquer leitor:

```java
public interface LeitorItensCardapio {
    ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;
    static LeitorItensCardapio criarLeitor(String nomeArquivo) { ... }
}
```

#### LeitorItensCardapioBase (Classe Abstrata)
Fornece a lógica comum de leitura:

```java
public abstract class LeitorItensCardapioBase implements LeitorItensCardapio {
    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {
        // Lê o arquivo
        String conteudoArquivo = Files.readString(Path.of(nomeArquivo));
        String[] linhasDoArquivo = conteudoArquivo.split("\n");
        
        // Processa cada linha
        ItemCardapio[] itens = new ItemCardapio[linhasDoArquivo.length];
        for (int i = 0; i < linhasDoArquivo.length; i++) {
            itens[i] = processaLinha(linhasDoArquivo[i]);
        }
        return itens;
    }
    
    protected abstract ItemCardapio processaLinha(String linha);
}
```

**Padrão de Design**: Template Method - a estrutura está na classe base, os detalhes em subclasses

#### LeitorItensCardapioCSV
Processa linhas separadas por `;`:

```java
@Override
protected ItemCardapio processaLinha(String linha) {
    String[] partes = linha.split(";");
    long id = Long.parseLong(partes[0]);
    String nome = partes[1];
    // ... demais campos
    return item;
}
```

#### LeitorItensCardapioJSON
Processa strings JSON, removendo caracteres especiais e parseando os valores:

```java
@Override
protected ItemCardapio processaLinha(String linha) {
    linha = linha.replace("[", "").replace("]", "").replace("{", ""}...;
    String[] partes = linha.split(",");
    // Extrai cada propriedade e seu valor
    // ... processamento
}
```

### 7. Interface com Usuário (Aula1.java)

Programa principal que interage com o usuário:

```java
void main() throws IOException {
    String nomeArquivo = IO.readln("Digite um nome de arquivo: ");
    Cardapio cardapio = new Cardapio(nomeArquivo);
    
    String linha = IO.readln("Digite um ID de um item do cardapio: ");
    long idselecionado = Long.parseLong(linha);
    
    ItemCardapio itemselecionado = cardapio.getItemPorId(idselecionado);
    
    // Exibe informações
    IO.println("Nome: " + itemselecionado.getNome());
    IO.println("Imposto: " + itemselecionado.getImposto());
    // ... demais informações
}
```

**Funcionalidades:**
- Lê nome do arquivo e carrega os dados
- Permite consultar um item por ID
- Exibe detalhes do item (nome, descrição, preço, desconto, imposto)
- Exibe totais do cardápio (soma de preços, itens em promoção)
- Lista itens com preço menor que R$ 10,00

## Conceitos de Orientação a Objetos



## Conceitos de Orientação a Objetos

### Encapsulamento
Os atributos são `private` e acessados através de getters:
```java
private double preco;
public double getPreco() {
    return preco;
}
```
Isso protege o estado do objeto e permite controle sobre quem pode acessar e modificar os dados.

### Modificador `final`
Indica que um atributo não pode ser reatribuído após a inicialização:
```java
private final ItemCardapio[] itens;  // Array não pode ser substituído
```

### Modificador `protected`
Permite acesso no mesmo pacote e por classes filhas:
```java
protected ItemCardapio(long id, String nome, ...)  // Pode ser chamado por ItemCardapioIsento
```

### Palavra-chave `this`
Referencia o atributo do objeto, diferenciando de parâmetros com mesmo nome:
```java
this.id = id;  // this.id é o atributo; id é o parâmetro
```

### Herança (`extends`)
Uma classe herda atributos e métodos de outra:
```java
public class ItemCardapioIsento extends ItemCardapio { ... }
```

### Polimorfismo
Diferentes classes podem implementar o mesmo método de formas diferentes:
```java
// ItemCardapio retorna 10% de imposto
// ItemCardapioIsento retorna 0% de imposto
// Mesmo nome, comportamentos diferentes
```

### Sobrescrita (`@Override`)
Uma classe filha redefine um método da classe mãe:
```java
@Override
public double getImposto() {
    return 0.0;
}
```

### Padrão de Design: Template Method
A classe base define a estrutura, subclasses completam os detalhes:
```java
// LeitorItensCardapioBase: estrutura de leitura
// LeitorItensCardapioCSV e JSON: implementam processaLinha()
```

### Interfaces e Contratos
`LeitorItensCardapio` define o contrato que todas as implementações devem seguir.

### Enumerações (`enum`)
Representa um conjunto fixo de valores possíveis:
```java
public enum CategoriaCardapio {
    ENTRADAS, PRATOS_PRINCIPAIS, SOBREMESAS, BEBIDAS
}
```

## Estruturas de Dados e Controle

### Array
Armazena múltiplos itens do mesmo tipo com tamanho fixo:
```java
ItemCardapio[] itens = new ItemCardapio[6];
```

### for-each
Itera sobre elementos de um array sem controle manual de índices:
```java
for (ItemCardapio item : itens) {
    // Processa cada item
}
```

### Condicional if/else
Escolhe diferentes caminhos de execução:
```java
if (emPromocao) {
    imposto = precoDesconto * 0.1;
} else {
    imposto = preco * 0.1;
}
```

### Conversão de Tipos
Converte de `String` para outros tipos:
```java
long id = Long.parseLong("123");       // String -> long
double preco = Double.parseDouble("9.99");  // String -> double
boolean flag = Boolean.parseBoolean("true");  // String -> boolean
```

## Fluxo de Execução

```
1. Usuário executa Aula1.java
   ↓
2. Programa solicita nome do arquivo (ex: "itens-cardapio.csv")
   ↓
3. Cardapio tenta carregar o arquivo:
   - Detecta extensão (.csv ou .json)
   - Cria um LeitorItensCardapio apropriado
   ↓
4. Leitor lê o arquivo e processa linha por linha:
   - LeitorItensCardapioBase lê o arquivo
   - Subclass processa cada linha
   - Cria objetos ItemCardapio ou ItemCardapioIsento
   ↓
5. Cardapio armazena os itens em um array
   ↓
6. Usuário digita um ID (1-6)
   ↓
7. Aula1 busca o item: cardapio.getItemPorId(id)
   ↓
8. Exibe informações do item:
   - Nome, descrição
   - Preço e desconto (se em promoção)
   - Imposto calculado
   - Categoria
   ↓
9. Exibe totais do cardápio:
   - Soma de todos os preços
   - Quantidade de itens em promoção
   - Lista itens com preço < R$ 10,00
```

## Fluxo de Dados

### Arquivo CSV → ItemCardapio
```
"1;Suco;É um suco;2.66;BEBIDAS;false;0;false"
   ↓ (LeitorItensCardapioCSV.processaLinha)
ItemCardapio(id=1, nome="Suco", preco=2.66, categoria=BEBIDAS)
```

### Arquivo JSON → ItemCardapio
```
{"id": 1, "nome": "Suco", "preco": 2.66, ...}
   ↓ (LeitorItensCardapioJSON.processaLinha)
ItemCardapio(id=1, nome="Suco", preco=2.66, ...)
```

## Observações Importantes

- **`emPromocao` padrão**: Começar como `false`; muda apenas quando `setPromocao()` é chamado
- **Porcentagem de desconto**: `calculaPorcentagemDesconto()` retorna fração (0.25 = 25%), não percentual
- **ID vs Índice**: IDs são 1-based, mas arrays são 0-based. `getItemPorId()` faz a conversão subtraindo 1
- **Exceções**: `IOException` ao ler arquivos; `ArrayIndexOutOfBoundsException` se ID inválido
- **Valores monetários**: Usa `double`; para aplicações financeiras reais, prefira `BigDecimal`
- **Imposto**: 10% do preço normal, ou 0% se em promoção, ou 0% se `ItemCardapioIsento`

## Padrões de Design Utilizados

1. **Factory Pattern**: `LeitorItensCardapio.criarLeitor()` cria o leitor apropriado conforme extensão
2. **Template Method**: `LeitorItensCardapioBase` define estrutura, subclasses implementam detalhes
3. **Strategy Pattern**: Diferentes estratégias de leitura (CSV vs JSON)
4. **Polymorphism**: `getImposto()` retorna valores diferentes conforme tipo real do objeto


