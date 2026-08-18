void main() {
    // Objeto (item1), atributo(nome)
    // item1.nome = "Suco";
    Cardapio cardapio = new Cardapio();
    String linha = IO.readln("Digite um ID de um item do cardapio");
    long idselecionado = Long.parseLong(linha);
    IO.println(idselecionado);
    // Buscando Itens no Array
    ItemCardapio itemselecionado = cardapio.itens[((int) idselecionado) - 1];
    for (ItemCardapio item : cardapio.itens) {
        if (item.id == idselecionado) {
            itemselecionado = item;
            break;
        }
    }
    IO.println("==Item Do Cardapio==");
    IO.println("Nome: " + itemselecionado.nome);
    IO.println("Em promoção: " + itemselecionado.emPromocao);
    IO.println("Descrição: " + itemselecionado.descricao + "");
    if (itemselecionado.emPromocao) {
        IO.println("Esta em desconto, seu preço fica em " + itemselecionado.precoDesconto + " reaiscl");
    } else {
        IO.println("Não esta em promoção, seu preço original é " + itemselecionado.preco + " reais");
    }
    var porcentagemDesconto = itemselecionado.calculaPorcentagemDesconto();
    IO.println(porcentagemDesconto);

    IO.println("Categoria: " + itemselecionado.obtemNomedaCategoria()); // Chamando um metodo
    IO.println("Arrays"); // Bloco de memoria, aloca memoria

    double[] precos = new double[7];
    precos[0] = 2.99;
    precos[1] = 3.99;
    precos[2] = 4.99;
    precos[3] = 5.99;
    precos[4] = 7.99;
    precos[5] = 8.99;
    precos[6] = 9.99;

    boolean[] emPromocao = { true, false }; // Maneira literal

    IO.println("Tamanho do array em precos: " + precos.length);
    IO.println("Tamanho do array em promoção: " + emPromocao.length);
    IO.println("O segundo item tem promoção? " + emPromocao[0]);
    IO.println("______________________________");
    IO.println("laço de repetição");

    IO.println("Total dos precos: " + cardapio.obtemSomaDosPrecos());
    IO.println("Total de itens em promoção: " + cardapio.obtemToalDeItensPromocao());
    double precoLimite = 10.00;
    for(ItemCardapio item : cardapio.itens){
        if (item.preco <= precoLimite) {
            IO.println("Nome do item com o preço menor que " + precoLimite + ": \n" + item.nome +" e seu preço é " + item.preco);
            
        }
    }
}

// javac compila, javac teste.java vai compilar, nao vai mostrar nada no console
// java vai rodar, java teste.java vai rodar, mostrando oq esta dentro de
// IO.println()
// Classes
class ItemCardapio {
    String nome; // Atributos
    String descricao; // Atributos
    boolean emPromocao; // Atributos
    double preco; // Atributos
    double precoDesconto; // Atributos
    long id; // Atributos
    CategoriaCardapio categoria; // Atributos
    // Linguagens orientadas a objetos
    // Classes tem atributos e metodos
    // Atributos são dados e os metodos são comportamento
    // Metodo

    double calculaPorcentagemDesconto() {
        double calculo = (preco - precoDesconto) / preco;
        return calculo;
    }

    // Ja passa valores no new
    // Não tem return
    // Nome do contrutor sempre sera o nome da classe (ItemCardapio)
    // CONTRUTOR
    // ItemCardapio(objeto), long id(parametro), long(tipo), id(nome)
    ItemCardapio(long id, String nome, String descricao, double preco, int precoDesconto, CategoriaCardapio categoria) {
        this.id = id; // O this.id (com this) é a propriedade (o campo) que pertence ao objeto
        this.nome = nome; // O id (sem this) é o valor que veio de fora (como um parâmetro de uma função).
        this.descricao = descricao;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
        this.categoria = categoria;
    }

    CategoriaCardapio obtemNomedaCategoria() {
        return categoria;
    }

    // VOID define que não tem retorno
    void definePromocao(double precoComDesconto) {
        emPromocao = true;
        this.precoDesconto = precoComDesconto;
    }
}

class Cardapio {
    ItemCardapio[] itens;

    Cardapio() {
        // Cria a class cardapio dentro das CLASSES
        ItemCardapio item1 = new ItemCardapio(1, "Suco", "É um suco", 2.66, 1, CategoriaCardapio.BEBIDAS);
        var item2 = new ItemCardapio(2, "Arroz com feijao", "Arroz com feijao tradicional familia brasileira", 2.66, 1, CategoriaCardapio.PRATOS_PRINCIPAIS);
        ItemCardapio item3 = new ItemCardapio(3, "Pizza Margherita", "Pizza com muçarela, tomate e manjericão", 15.99,
                1, CategoriaCardapio.PRATOS_PRINCIPAIS);
        var item4 = new ItemCardapio(4, "Suco Natural", "Suco de laranja natural e fresco", 4.50, 2, CategoriaCardapio.BEBIDAS);
        ItemCardapio item5 = new ItemCardapio(5, "Brigadeiro", "Brigadeiro tradicional cobert com chocolate", 3.00, 3, CategoriaCardapio.SOBREMESSAS);
        var item6 = new ItemCardapio(6, "Café Premium", "Café coado quente e aromático", 2.50, 2, CategoriaCardapio.BEBIDAS);
        itens = new ItemCardapio[6];
        itens[0] = item1;
        itens[1] = item2;
        itens[2] = item3;
        itens[3] = item4;
        itens[4] = item5;
        itens[5] = item6;
    }

    double obtemSomaDosPrecos() {
        double totalDePreco = 0.0;
        for (ItemCardapio item : itens){
            totalDePreco += item.preco;
        }
        return totalDePreco;
    }
    int obtemToalDeItensPromocao(){
        int totaldeitenspromocao = 0;
        for(ItemCardapio item : itens){
            if (item.emPromocao){
                totaldeitenspromocao++;
            }
        }
        return totaldeitenspromocao;
    }
}

enum CategoriaCardapio{
    ENTRADAS, PRATOS_PRINCIPAIS, SOBREMESSAS, BEBIDAS
}