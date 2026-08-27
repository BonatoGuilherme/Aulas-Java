package com.LaPlaga.modelo.isento; //Boas Praticas

import com.LaPlaga.modelo.CategoriaCardapio;
import com.LaPlaga.modelo.ItemCardapio;

public class ItemCardapioIsento extends ItemCardapio {

    public ItemCardapioIsento(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        //chama da classe mãe (ItemCardapio) o contrutor dela com o SUPER()
        super(id, nome, descricao, preco, categoria);
    }
    //Reescrita de metodo (override)
    @Override //Ajuda a reconhecer
    public double getImposto() {
        return 0.0;
    }
}