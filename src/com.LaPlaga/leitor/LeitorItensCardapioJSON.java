package com.LaPlaga.leitor;

import com.LaPlaga.modelo.CategoriaCardapio;
import com.LaPlaga.modelo.ItemCardapio;
import com.LaPlaga.modelo.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorItensCardapioJSON implements LeitorItensCardapio {

        public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {

        Path arquivo = Path.of(nomeArquivo);
        String conteudoArquivo = Files.readString(arquivo);
        String[] linhasDoArquivo = conteudoArquivo.split("\n");

        ItemCardapio[] itens = new ItemCardapio[linhasDoArquivo.length];
        for (int i = 0; i < linhasDoArquivo.length; i++) {
            String linha = linhasDoArquivo[i];
            linha = linha.replace("[", "");
            linha = linha.replace("]", "");
            linha = linha.replace("}", "");
            linha = linha.replace("{", "");
            linha = linha.replace("\"", "");
            String[] partes = linha.split(",");

            String parteId = partes[0];
            String[] propriedadeEValorID = parteId.split(":");
            String valorID = propriedadeEValorID[1].trim();
            long id = Long.parseLong(valorID);

            String parteNome = partes[1];
            String[] propriedadeEValorNome = parteNome.split(":");
            String nome = propriedadeEValorNome[1].trim();

            String parteDescricao = partes[2];
            String[] propriedadeEValorDescricao = parteDescricao.split(":");
            String descricao = propriedadeEValorDescricao[1].trim();

            String partePreco = partes[3];
            String[] propriedadeEValorPreco = partePreco.split(":");
            String valorPreco = propriedadeEValorPreco[1].trim();
            double preco = Double.parseDouble(valorPreco);

            String parteCategoria = partes[4];
            String[] propriedadeEValorCategoria = parteCategoria.split(":");
            String valorCategoria = propriedadeEValorCategoria[1].trim();
            CategoriaCardapio categoria = CategoriaCardapio.valueOf(valorCategoria);

            ItemCardapio item = new ItemCardapio(id, nome, descricao, preco, categoria);
            itens[i] = item;

            String parteEmPromocao = partes[5];
            String[] propriedadeEValorEmPromocao = parteEmPromocao.split(":");
            String valorEmpromocao = propriedadeEValorEmPromocao[1].trim();
            boolean emPromocao = Boolean.parseBoolean(valorEmpromocao);
            if (emPromocao) {
                String partePrecoDesconto = partes[6];
                String[] propriedadeEValorPrecoDesconto = partePrecoDesconto.split(":");
                String valorPrecoDesconto = propriedadeEValorPrecoDesconto[1].trim();
                double precoDesconto = Double.parseDouble(valorPrecoDesconto);
                item.setPromocao(precoDesconto);
            }
            String parteImpostoIsento = partes[7];
            String[] propriedadeEValorImpostoIsento = parteImpostoIsento.split(":");
            String valorImpostoIsento = propriedadeEValorImpostoIsento[1].trim();
            boolean ImpostoIsento = Boolean.parseBoolean(valorImpostoIsento);
            if (ImpostoIsento) {
                item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
            } else {
                item = new ItemCardapio(id, nome, descricao, preco, categoria);
            }
        }
        return itens;
    }
}
