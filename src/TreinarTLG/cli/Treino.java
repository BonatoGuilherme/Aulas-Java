package TreinarTLG.cli;

import TreinarTLG.model.AddTwoNumbers;
import TreinarTLG.model.TreinoData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        Optional<String> result = buscarUsuario(optional);
        if (result.isPresent()) {
            IO.println(result.get());

        } else {
            IO.println("Usuário não encontrado");
        }
        String nascimento = IO.readln("Digite sua data de aniversário (Usa as barras se nao, nao funciona): ");

        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(nascimento, formatoEntrada);

        String dataFormatada = TreinoData.formatarData(dataNascimento);
        int idade = TreinoData.calcularIdade(dataNascimento);

        IO.println("Data formatada: " + dataFormatada);
        IO.println("Você tem " + idade + " anos");
    }
}