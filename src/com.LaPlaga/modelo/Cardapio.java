package com.LaPlaga.modelo;

import com.LaPlaga.modelo.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cardapio {
    //Domínio do Problema que estou resolvendo
    private final ItemCardapio[] itens;

    public Cardapio(String nomeArquivo) throws IOException {
        // Cria a class cardápio dentro das CLASSES

        Path arquivo = Path.of(nomeArquivo);
        String conteudoArquivo = Files.readString(arquivo);
        String[] linhasDoArquivo = conteudoArquivo.split("\n");
        itens = new ItemCardapio[linhasDoArquivo.length];
        for (int i = 0; i < linhasDoArquivo.length; i++) {
            String linha = linhasDoArquivo[i];
            IO.println("Linha" + i + ": " + linha);
            if (nomeArquivo.endsWith(".csv")) {
                String[] partes = linha.split(";");
                for (int j = 0; j < partes.length; j++) {
                    long id = Long.parseLong(partes[0]);
                    String nome = partes[1];
                    String descricao = partes[2];
                    double preco = Double.parseDouble(partes[3]);
                    CategoriaCardapio categoria = CategoriaCardapio.valueOf(partes[4]);
                    ItemCardapio item;
                    boolean impostoIsento = Boolean.parseBoolean(partes[7]);
                    if (impostoIsento) {
                        item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
                    } else {
                        item = new ItemCardapio(id, nome, descricao, preco, categoria);
                    }
                    boolean emPromocao = Boolean.parseBoolean(partes[5]);
                    if (emPromocao) {
                        double precoDesconto = Double.parseDouble(partes[6]);
                        item.setPromocao(precoDesconto);
                    }
                    itens[i] = item;
                }
                // Tratativa CSV
            } else if (nomeArquivo.endsWith(".json")) {
              // Tratativa Json
            } else {
                IO.println("Arquivo com extensão invalida: " + nomeArquivo);
            }
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
