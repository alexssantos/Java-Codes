package alex.silva;

import javax.swing.*;
import java.awt.*;

public class Calculator implements ICalculator {
    Log Log;

    public Calculator() {
        Log = new Log();
    }

    public Double soma(Double num1, Double num2){
        return num1 + num2;
    }

    public Double subtracao(Double num1, Double num2){
        return num1 - num2;
    }

    public Double multiplicacao(Double num1, Double num2){
        return num1 * num2;
    }

    public Double divisao(Double num1, Double num2){
        return num1 / num2;
    }

    public String calcula(String choice, double num1, double num2){

        String retorno = "";
        double result = 0;
        if (choice.equals("+"))
        {
            result = soma(num1, num2);
            retorno = "Resultado: " + result;
        }
        else if (choice.equals("-"))
        {
            result = subtracao(num1, num2);
            retorno = "Resultado: " + result;
        }
        else if (choice.equals("*"))
        {
            result = multiplicacao(num1, num2);
            retorno = "Resultado: " + result;
        }
        else if (choice.equals("/"))
        {
            if ((num2 == 0) || (num1 == 0)){
                String erroMsg = "Alerta! Não é possível fazer a divisão por '0' ";
                //FIXME: trow exception
                retorno = erroMsg;
            }
            else{
                result = divisao(num1, num2);
                retorno = "Resultado: " + result;
            }
        }
        String newLog = num1+" "+choice+" "+num2+" = "+result;
        Log.writeLOG(newLog);

        return retorno;
    }

    @Override
    public String toString() {
        if (Log.LOG[0] == null){
            return "Nenhum operação realizada.";
        }

        String logHistory = "";

        for (int i = 0; i < Log.LOG.length; i++)
        {
            if (Log.LOG[i] == null)
            {
                logHistory += "---\n";
            }
            else
            {
                logHistory += Log.LOG[i] + "\n";
            }

        }
        return logHistory;
    }
}
