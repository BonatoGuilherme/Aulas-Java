class Cardapio {
    ItemCardapio[] itens;

    Cardapio() {
        // Cria a class cardapio dentro das CLASSES
        ItemCardapio item1 = new ItemCardapio(1, "Suco", "É um suco", 2.66, 1, CategoriaCardapio.BEBIDAS);
        ItemCardapio item2 = new ItemCardapioIsento(2, "Arroz com feijao", "Arroz com feijao tradicional familia brasileira", 2.66, 1, CategoriaCardapio.PRATOS_PRINCIPAIS);
        ItemCardapio item3 = new ItemCardapio(3, "Pizza Margherita", "Pizza com muçarela, tomate e manjericão", 15.99, 1, CategoriaCardapio.PRATOS_PRINCIPAIS);
        ItemCardapio item4 = new ItemCardapioIsento(4, "Suco Natural", "Suco de laranja natural e fresco", 4.50, 2, CategoriaCardapio.BEBIDAS);
        ItemCardapio item5 = new ItemCardapio(5, "Brigadeiro", "Brigadeiro tradicional cobert com chocolate", 3.00, 3, CategoriaCardapio.SOBREMESSAS);
        ItemCardapio item6 = new ItemCardapioIsento(6, "Café Premium", "Café coado quente e aromático", 2.50, 2, CategoriaCardapio.BEBIDAS);
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
        for (ItemCardapio item : itens) {
            totalDePreco += item.preco;
        }
        return totalDePreco;
    }

    int obtemToalDeItensPromocao() {
        int totaldeitenspromocao = 0;
        for (ItemCardapio item : itens) {
            if (item.emPromocao) {
                totaldeitenspromocao++;
            }
        }
        return totaldeitenspromocao;
    }
}
