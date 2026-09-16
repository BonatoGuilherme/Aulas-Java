package TreinarTLG.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TreinoData {
    public static int calcularIdade(LocalDate nascimento){
        LocalDate data = LocalDate.now();
        Period periodo = Period.between(nascimento, data);
        return periodo.getYears();
    }
    public static String formatarData(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
