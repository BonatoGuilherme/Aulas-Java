package Treinar.model;

public class IsPrimo {
    public boolean isPrimo(int number){
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++){
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public void listarPrimos(int number){
        for (int i = 2; i <= number; i++){
            if(isPrimo(i)){
                IO.println(i + " é Primo");
            }  else{
                IO.println( i + " Não é primo");
            }
        }
    }
}
