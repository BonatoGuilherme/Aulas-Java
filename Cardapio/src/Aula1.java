void main() {
    // Objeto (item1), atributo(nome)
    // item1.nome = "Suco";
    Cardapio cardapio = new Cardapio();
    String linha = IO.readln("Digite um ID de um item do cardapio: ");
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
    IO.println("Imposto: " + itemselecionado.calculaImposto());
    IO.println("Categoria: " + itemselecionado.obtemNomedaCategoria()); // Chamando um metodo
    IO.println("Arrays"); // Bloco de memoria, aloca memoria
    IO.println("laço de repetição");

    IO.println("Total dos precos: " + cardapio.obtemSomaDosPrecos());
    IO.println("Total de itens em promoção: " + cardapio.obtemToalDeItensPromocao());
    double precoLimite = 10.00;
    for (ItemCardapio item : cardapio.itens) {
        if (item.preco <= precoLimite) {
            IO.println("Nome do item com o preço menor que " + precoLimite + ": \n" + item.nome + " e seu preço é " + item.preco);
        }
    }
}