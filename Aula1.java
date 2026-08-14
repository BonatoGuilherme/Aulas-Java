void main (){
    //Cria a class cardapio dentro da estrutura principal do Java
    ItemCardapio item1 = new ItemCardapio();
    //Objeto (item1), atributo(name)
    item1.nome = "Suco";
    item1.descricao = "É um suco";
    item1.emPromocao = false;
    item1.preco = 2.66;
    item1.precoDesconto = 1;
    item1.id = 1;
    item1.categoria = 1;

    var item2 = new ItemCardapio();
    item2.nome = "Arroz com feijao";
    item2.descricao = "Arroz com feijao tradicional familia brasileira";
    item2.emPromocao = true;
    item2.preco = 2.66;
    item2.id = 1;
    item2.categoria = 1;

    IO.println("Produto: " + item1.nome + "");
    IO.println("Descrição:" + item1.descricao + "");
    if (item1.emPromocao == true){
        IO.println("Esta em desconto, seu preço fica em " + item1.precoDesconto + " reaiscl");
    } else {
        IO.println("Não esta em promoção, seu preço original é" + item1.preco + " reais");
    }
    
    if ( item1.categoria == 1) {
        IO.println("Categoria: Prato Principal");
    } else if (item1.categoria == 2){
         IO.println("Categoria: Bebidas");
    } else if (item1.categoria == 3){
         IO.println("Categoria: Sobremessas");
    }
    IO.println("______________________________");

    switch (item1.categoria) {
        case 1:
            IO.println("Categoria: Prato Principal");
            break;
        case 2:
            IO.println("Categoria: Bebidas");
            break;
        case 3:
            IO.println("Categoria: Sobremessas");
        default:
            IO.println("Categoria não encontrada");
            break;
    }
    IO.println("______________________________");
    IO.println("Arrays"); //Bloco de memoria, aloca memoria

    double[] precos = new double[7]; 

    precos[0] = 2.99;
    precos[1] = 3.99;
    precos[2] = 4.99;
    precos[3] = 5.99;
    precos[4] = 7.99;
    precos[5] = 8.99;
    precos[6] = 9.99;

    boolean[] emPromocao = {true, false}; //Maneira literal

    IO.println("Tamanho do array em precos:\n" + precos.length);
    IO.println("Tamanho do array em promoção:\n" + emPromocao.length);
    IO.println("O segundo item tem promoção?\n" + emPromocao[0]);
    IO.println("______________________________");
    IO.println("laço de repetição");
    IO.println("While");

    double totalDePreco = 0.0;
    int i = 0;
    while (i < precos.length) {
        double preco = precos[i];
        totalDePreco = totalDePreco + preco;
        i++; // Incrementa mais 1
    } 
    IO.println("Total dos precos: " + totalDePreco);
    IO.println("do While");
    int totaldeitenspromocao = 0;
    int j = emPromocao.length - 1;
    do {
        if (emPromocao[j]){
            totaldeitenspromocao++;
        } 
        j--;
    } while (j >= 0);
    IO.println("Total de itens em promoção: " + totaldeitenspromocao);

    IO.println("For");
    double totaldeprecoscomFor = 0.0;
    for (int h = 0; h < precos.length; h++) { //Faz tudo junto de uma vez
        double preco = precos[h];
        totaldeprecoscomFor += preco;
    }
    IO.println("Soma dos preços: " + totaldeprecoscomFor);

}
// javac compila, javac teste.java vai compilar, nao vai mostrar nada no console
// java vai rodar, java teste.java vai rodar, mostrando oq esta dentro de IO.println()
//Classes
class ItemCardapio {
    String nome; //Atributos
    String descricao; //Atributos
    boolean emPromocao; //Atributos
    double preco; //Atributos
    double precoDesconto; //Atributos
    long id; //Atributos 
    int categoria; //Atributos
}