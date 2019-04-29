package alex.silva;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String numb1, numb2;
        String[] operations = {"+","-","/","*"};

        numb1 = JOptionPane.showInputDialog(null, "Digite o Primeiro valor: ");
        double num1 =Double.parseDouble(numb1);

        String choice = (String) JOptionPane.showInputDialog(null,
                "Operação:",            //msg
                "Escolha da operação.",     //title
                JOptionPane.QUESTION_MESSAGE,   //title
                null,          // icon
                operations,         // Array of choices
                operations[1]);     // Initial choice

        numb2 = JOptionPane.showInputDialog(null, "Digite o segundo valor: ");
        double num2 =Double.parseDouble(numb2);

        double result;
        if (choice.equals("+"))
        {
            result = num1 + num2;
            msg("Resultado: ", result);
        }
        if (choice.equals("-"))
        {
            result = num1 - num2;
            msg("Resultado: ", result);
        }
        if (choice.equals("*"))
        {
            result = num1 * num2;
            msg("Resultado: ", result);
        }
        if (choice.equals("/"))
        {
            if ((num2 == 0) || (num1 == 0)){
                msg("Alerta! Não é possivel fazer a divisão 0/0 ", null);
            }
            else{
                result = num1 / num2;
                msg("Resultado: ", result);
            }
        }
    }

    public static void msg(String msg, Double result){
        if (result == null){
            JOptionPane.showMessageDialog(null,"Alerta! Não é possível fazer a divisão por '0' ");
        }
        else{
            JOptionPane.showMessageDialog(null,msg + result);
        }

    };
}
