package com.LaPlaga.modelo;

import com.LaPlaga.leitor.FabricaLeitorItensCardapio;


import java.io.IOException;

public class Cardapio {
    //Domínio do Problema
    private final ItemCardapio[] itens;

    public Cardapio(String nomeArquivo) throws IOException {
        FabricaLeitorItensCardapio fabrica = new FabricaLeitorItensCardapio();
        com.LaPlaga.leitor.LeitorItensCardapio leitor = fabrica.criarLeitor(nomeArquivo);
        if (leitor != null) {
            itens = leitor.processaArquivo(nomeArquivo);
        } else  {
          IO.println("O tipo de arquivo é invalido: " + nomeArquivo);
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
