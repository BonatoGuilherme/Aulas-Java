package com.LaPlaga.modelo;

import com.LaPlaga.leitor.LeitorItensCardapio;
import java.io.IOException;
import static java.lang.IO.println;

public class Cardapio {

    private final ItemCardapio[] itens;

    public Cardapio(String nomeArquivo) throws IOException {

        LeitorItensCardapio leitor = LeitorItensCardapio.criarLeitor(nomeArquivo);
        if (leitor != null) {
            itens = leitor.processaArquivo(nomeArquivo);
        } else  {
          println("O tipo de arquivo é invalido: " + nomeArquivo);
          itens = new ItemCardapio[0];
        }
    }
    public double getSomaDosPrecos() {
        double totalDePreco = 0.0;
        for (ItemCardapio item : itens) {
            totalDePreco += item.getPreco();
        }
        return totalDePreco;
    }

    public int getTotalDeItensPromocao() {
        int totaldeitenspromocao = 0;
        for (ItemCardapio item : itens) {
            if (item.isEmPromocao()) {
                totaldeitenspromocao++;
            }
        }
        return totaldeitenspromocao;
    }

    public ItemCardapio getItemPorId(long idSelecionado) {
        return itens[((int) idSelecionado) - 1];
    }

    public ItemCardapio[] getItens() {
        return itens;
    }
}
