package TreinarTLG.cli;

import TreinarTLG.model.addTwoNumbers;

class Treino {
    void main() {
        double a = Double.parseDouble(IO.readln("Escreva um número: "));
        double b = Double.parseDouble(IO.readln("Escreva outro número: "));

        addTwoNumbers soma = new addTwoNumbers();
        double resultado = soma.SomaNumbers(a, b);
        IO.println(resultado);
    }
}