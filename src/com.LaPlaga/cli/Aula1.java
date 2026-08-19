import com.LaPlaga.modelo.Cardapio;
import com.LaPlaga.modelo.ItemCardapio;

// Reverse Domain Rename
void main() {
    // cli.Aula1 --> Command Line Interface (CLI)
    // Objeto (item1), atributo(nome)
    // item1.nome = "Suco";
    Cardapio cardapio = new Cardapio();
    String linha = IO.readln("Digite um ID de um item do cardapio: ");
    long idselecionado = Long.parseLong(linha);
    IO.println(idselecionado);
    // Buscando Itens no Array
    ItemCardapio itemselecionado = cardapio.getItemPorId(idselecionado);
    for (ItemCardapio item : cardapio.getItens()) {
        if (item.getId() == idselecionado) {
            itemselecionado = item;
            break;
        }
    }
    IO.println("==Item Do modelo.Cardapio==");
    IO.println("Nome: " + itemselecionado.getNome());
    IO.println("Em promoção: " + itemselecionado.isEmPromocao());
    IO.println("Descrição: " + itemselecionado.getDescricao() + "");
    if (itemselecionado.isEmPromocao()) {
        IO.println("Esta em desconto, seu preço fica em " + itemselecionado.getPrecoDesconto() + " reais");
    } else {
        IO.println("Não esta em promoção, seu preço original é " + itemselecionado.getPreco() + " reais");
    }
    var porcentagemDesconto = itemselecionado.calculaPorcentagemDesconto();
    IO.println(porcentagemDesconto);
    IO.println("Imposto: " + itemselecionado.getImposto());
    IO.println("Categoria: " + itemselecionado.getNomedaCategoria()); // Chamando um metodo
    IO.println("Arrays"); // Bloco de memoria, aloca memoria
    IO.println("laço de repetição");

    IO.println("Total dos precos: " + cardapio.getSomaDosPrecos());
    IO.println("Total de itens em promoção: " + cardapio.getToalDeItensPromocao());
    double precoLimite = 10.00;
    for (ItemCardapio item : cardapio.getItens()) {
        if (item.getPreco() <= precoLimite) {
            IO.println("Nome do item com o preço menor que " + precoLimite + ": \n" + item.getNome() + " e seu preço é " + item.getPreco());
        }
    }
}