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
        return (preco - precoDesconto) / preco;
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

    // VOID define e não tem retorno
    void definePromocao(double precoComDesconto) {
        emPromocao = true;
        this.precoDesconto = precoComDesconto;
    }

    double calculaImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoDesconto * 0.1;
        } else  {
            imposto = preco * 0.1;
        }
        return imposto;
    }
}
