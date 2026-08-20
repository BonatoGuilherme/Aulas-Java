// javac compila, javac teste.java vai compilar, nao vai mostrar nada no console
// java vai rodar, java teste.java vai rodar, mostrando oq esta dentro de
// IO.println()
// Classes
package com.LaPlaga.modelo;

public class ItemCardapio {
    private String nome; // Atributos
    private String descricao; // Atributos
    private boolean emPromocao; // Atributos
    private double preco; // Atributos
    private double precoDesconto; // Atributos
    private long id; // Atributos
    private CategoriaCardapio categoria; // Atributos

    // Linguagens orientadas a objetos
    // Classes tem atributos e metodos
    // Atributos são dados e os metodos são comportamento
    // Metodo

    public double calculaPorcentagemDesconto() {
        return (preco - precoDesconto) / preco;
    }

    // Ja passa valores no new
    // Não tem return
    // Nome do contrutor sempre sera o nome da classe (modelo.ItemCardapio)
    // CONTRUTOR
    // modelo.ItemCardapio(objeto), long id(parametro), long(tipo), id(nome)
    protected ItemCardapio(long id, String nome, String descricao, double preco, int precoDesconto, CategoriaCardapio categoria) {
        this.id = id; // O this.id (com this) é a propriedade (o campo) que pertence ao objeto
        this.nome = nome; // O id (sem this) é o valor que veio de fora (como um parâmetro de uma função).
        this.descricao = descricao;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
        this.categoria = categoria;
    }

    public CategoriaCardapio getNomedaCategoria() {
        return categoria;
    }

    // VOID define e não tem retorno
    public void definePromocao(double precoComDesconto) {
        emPromocao = true;
        this.precoDesconto = precoComDesconto;
    }

    public double getImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoDesconto * 0.1;
        } else {
            imposto = preco * 0.1;
        }
        return imposto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public double getPrecoDesconto() {
        return precoDesconto;
    }

    public long getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public CategoriaCardapio getCategoria() {
        return categoria;
    }
}
