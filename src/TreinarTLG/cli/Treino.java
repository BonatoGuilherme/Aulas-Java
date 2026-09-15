package TreinarTLG.cli;

import TreinarTLG.model.AddTwoNumbers;
import TreinarTLG.model.TreinoOptional;

import java.util.Optional;

import static TreinarTLG.model.TreinoOptional.buscarUsuario;

class Treino {
    void main() {
        double a = Double.parseDouble(IO.readln("Escreva um número: "));
        double b = Double.parseDouble(IO.readln("Escreva outro número: "));

        AddTwoNumbers soma = new AddTwoNumbers();
        double resultado = soma.SomaNumbers(a, b);
        IO.println(resultado);

        String optional = IO.readln("Digite o nome Guilherme ou Maria");
        IO.println(buscarUsuario(optional));

        Optional<String> result = TreinoOptional.buscarUsuario(optional);
        if (result.isPresent()) {
            IO.println(result.get());

        } else {
            IO.println("Usuário não encontrado");
        }
    }
}