package com.LaPlaga.leitor;

import com.LaPlaga.modelo.CategoriaCardapio;
import com.LaPlaga.modelo.ItemCardapio;
import com.LaPlaga.modelo.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorItensCardapioCSV implements LeitorItensCardapio {
    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {
        Path arquivo = Path.of(nomeArquivo);
        String conteudoArquivo = Files.readString(arquivo);
        String[] linhasDoArquivo = conteudoArquivo.split("\n");

        ItemCardapio[] itens = new ItemCardapio[linhasDoArquivo.length];
        for (int i = 0; i < linhasDoArquivo.length; i++) {
            String linha = linhasDoArquivo[i];
            String[] partes = linha.split(";");
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
        return itens;
    }
}

