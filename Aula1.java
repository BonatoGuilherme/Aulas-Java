void main (){
    var nomeItem1 = "Suco";
    var descricaoItem1 = "É um suco";
    var estaEmPromocao = true;
    var precoItem1 = 10.1;
    var precoDescontoItem1 = precoItem1 * 0.8;
    var categoriaItem1 = 2;
    var nomeItem2 = "Arroz com feijao";
    var descricaoItem2 = "Arroz com feijao tradicional familia brasileira";
    var estaEmPromocao2 = false;
    var precoItem2 = 5.1;
    var precoDescontoItem2 = precoItem1 * 0.8;
    var categoriaitem2 = 2;

    IO.println("Produto: " + nomeItem1 + "\n");
    IO.println("Descrição:" + descricaoItem1 + "\n");
    if (estaEmPromocao == true){
        IO.println("Esta em desconto, seu preço fica em " + precoDescontoItem1 + " reais\n");
    } else {
        IO.println("Não esta em promoção, seu preço original é" + precoItem1 + " reais\n");
    }
    
    if (categoriaItem1 == 1) {
        IO.println("Categoria: Prato Principal\n");
    } else if (categoriaItem1 == 2){
         IO.println("Categoria: Bebidas\n");
    } else if (categoriaItem1 == 3){
         IO.println("Categoria: Sobremessas\n");
    }
    IO.println("______________________________\n");

    switch (categoriaItem1) {
        case 1:
            IO.println("Categoria: Prato Principal\n");
            break;
        case 2:
            IO.println("Categoria: Bebidas\n");
            break;
        case 3:
            IO.println("Categoria: Sobremessas\n");
        default:
            IO.println("Categoria não encontrada");
            break;
    }
    IO.println("______________________________\n");
    IO.println("Arrays\n"); //Bloco de memoria, aloca memoria

    double[] precos = new double[7]; 

    precos[0] = 2.99;
    precos[1] = 3.99;
    precos[2] = 4.99;
    precos[3] = 5.99;
    precos[4] = 7.99;
    precos[5] = 8.99;
    precos[6] = 9.99;

    boolean[] emPromocao = {true, false}; //Maneira literal

    IO.println("Tamanho do array em precos" + precos.length);
    IO.println("Tamanho do array em promoção" + emPromocao.length);
    IO.println("O segundo item tem promoção? " + emPromocao[1]);
    IO.println("______________________________");
    IO.println("laço de repetição");
    IO.println("While");

    double totalDePreco = 0.0;
    int i = 0;
    while (i < precos.length) {
        double preco = precos[i];
        totalDePreco = totalDePreco + preco;
        i++; // Incrementa mais 1
        IO.println("Total dos precos: " + totalDePreco);
    } 
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
    IO.println("______________________________");
    IO.println("______________________________");
}
// javac compila, javac teste.java vai compilar, nao vai mostrar nada
// java vai rodar, java teste.java vai rodar, mostrando oq esta dentro de IO.println()