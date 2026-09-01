package com.LaPlaga.cli;

import com.LaPlaga.modelo.CategoriaCardapio;
import com.LaPlaga.modelo.ItemCardapio;

public class TesteObjetos {
    static void main(){
        Object[] lista = new Object[5];

        lista[0] = 1;
        lista[1] = 2.4;
        lista[2] = "3";
        lista[3] = true;
        lista[4] = new ItemCardapio(10, "Item10","receba", 10, CategoriaCardapio.BEBIDAS );


        for (Object item : lista){
            IO.println(item);
        }
    }

}
