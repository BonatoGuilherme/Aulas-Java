package Treinar.model;

import java.util.Optional;

public class TreinoOptional {
         public static Optional<String> buscarUsuario(String nome) {
        if (nome.equals("Guilherme")) {
            return Optional.of("Guilherme encontrado!");
        } else {
            return Optional.empty();
        }
     }

}
