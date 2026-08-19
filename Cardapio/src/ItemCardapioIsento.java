class ItemCardapioIsento extends ItemCardapio {

    ItemCardapioIsento(long id, String nome, String descricao, double preco, int precoDesconto, CategoriaCardapio categoria) {
        //chama da classe mãe (ItemCardapio) o contrutor dela com o SUPER()
        super(id, nome, descricao, preco, precoDesconto, categoria);
    }
    //Reescrita de metodo (override)
    @Override //Ajuda a reconhecer
    double calculaImposto() {
        return 0.0;
    }
}