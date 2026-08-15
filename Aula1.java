void main (){
    //Cria a class cardapio dentro da estrutura principal do Java
    ItemCardapio item1 = new ItemCardapio(1, "Suco", "É um suco", 2.66, 1);


    //Objeto (item1), atributo(nome)
    /*
    item1.nome = "Suco";
    item1.descricao = "É um suco";
    item1.emPromocao = false;
    item1.preco = 2.66;
    item1.precoDesconto = 1;
    item1.id = 1;
    item1.categoria = 1;
    */
    

    var item2 = new ItemCardapio(2, "Arroz com feijao", "Arroz com feijao tradicional familia brasileira", 2.66, 1);

  
    IO.println("Descrição: " + item1.descricao + "");
    if (item1.emPromocao == true){
        IO.println("Esta em desconto, seu preço fica em " + item1.precoDesconto + " reaiscl");
    } else {
        IO.println("Não esta em promoção, seu preço original é " + item1.preco + " reais");
    }
    var porcentagemDesconto = item2.calculaPorcentagemDesconto();
    IO.println(porcentagemDesconto);

    IO.println("Categoria: " + item2.obtemNomedaCategoria()); //Chamando um metodo
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

    IO.println("Tamanho do array em precos: " + precos.length);
    IO.println("Tamanho do array em promoção: " + emPromocao.length);
    IO.println("O segundo item tem promoção? " + emPromocao[0]);
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
    //Linguagens orientadas a objetos
    //Classes tem atributos e metodos
    //Atributos são dados e os metodos são comportamento
    //Metodo
    double calculaPorcentagemDesconto(){
        double calculo = (preco - precoDesconto) / preco;
        return calculo;
    }
    
    //Ja passa valores no new
    //Não tem return
    //Nome do contrutor sempre sera o nome da classe (ItemCardapio)
    //CONTRUTOR
    ItemCardapio(long idParam, String nomeParam, String descricaoParam, double precoParam, int precoDescontoParam){
        id = idParam;
        nome = nomeParam;
        descricao = descricaoParam;
        preco = precoParam;
        precoDesconto = precoDescontoParam;
    }
    String obtemNomedaCategoria(){
        String nomeCategoria;
        switch (categoria) {
        case 1:
            nomeCategoria= "Prato Principal";
            break;
        case 2:
            nomeCategoria= "Categoria: B ebidas";
            break;
        case 3:
            nomeCategoria="Categoria: Sobremessas";
        default:
            nomeCategoria="Categoria não encontrada";
            break;
        }
        return nomeCategoria;
    }
    
    
    
}