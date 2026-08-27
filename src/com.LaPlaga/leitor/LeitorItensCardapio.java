package com.LaPlaga.leitor;

import com.LaPlaga.modelo.ItemCardapio;

import java.io.IOException;

public interface LeitorItensCardapio {
     ItemCardapio[]  processaArquivo(String nomeArquivo) throws IOException;
}
