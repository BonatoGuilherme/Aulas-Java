package com.LaPlaga.leitor;

import com.LaPlaga.modelo.ItemCardapio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class LeitorItensCardapioBase implements LeitorItensCardapio {

    private final String nomeArquivo;

    public LeitorItensCardapioBase(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {
        Path arquivo = Path.of(this.nomeArquivo);
        String conteudoArquivo = Files.readString(arquivo);
        String[] linhasDoArquivo = conteudoArquivo.split("\n");

        ItemCardapio[] itens = new ItemCardapio[linhasDoArquivo.length];

        for (int i = 0; i < linhasDoArquivo.length; i++){
            String linha = linhasDoArquivo[i];

            ItemCardapio item = processaLinha(linha);
            itens[i] = item;
        }
        return itens;
    }
    protected abstract ItemCardapio processaLinha(String linha);
}
