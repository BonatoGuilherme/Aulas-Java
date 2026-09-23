package Treinar.model;

public class FizzBuzz {
    public Object buzzfizz(int number){
         for(int i = 0;i<=number;i++){
             if(i % 3 == 0 && i % 5 == 0) {
                 IO.println(i + " é "+ "FizzBuzz");
             }else if (i % 5 == 0){
                 IO.println(i + " é "+ "Buzz");
             }else if (i % 3 == 0){
                 IO.println(i + " é "+ "Fizz");
             } else {
                 IO.println(i + " é "+ "Nada pai");
             }
         }
        return null;
    }
}

//1. FizzBuzz (aquecimento)
//
//Imprima os números de 1 a 100. Mas:
//
//Se o número for múltiplo de 3, imprima "Fizz" no lugar do número
//Se for múltiplo de 5, imprima "Buzz"
//Se for múltiplo de 3 e 5 ao mesmo tempo, imprima "FizzBuzz"