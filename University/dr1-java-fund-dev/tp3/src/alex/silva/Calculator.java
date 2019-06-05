package alex.silva;

import javax.swing.*;
import java.awt.*;

public class Calculator implements ICalculator {
    String numb1, numb2;
    final String optionLog = "Show Historic";
    String[] operations = {"+","-","/","*", optionLog};
    boolean exit = false;
    Log Log;

    public Calculator() {
        this("", "");
        Log = new Log();
    }

    public Calculator(String numb1, String numb2) {
        this.numb1 = numb1;
        this.numb2 = numb2;
        Log = new Log();
    }

    public void start()
    {
        while(!exit) {
            this.numb1 = JOptionPane.showInputDialog(null, "Digite o Primeiro valor: ");
            if (canceledOption(this.numb1)) {
                getOut();
                continue;
            }

            if (this.numb1 == "")
            {
                continue;
            }
            double num1 = Double.parseDouble(numb1);

            String choice = (String) JOptionPane.showInputDialog(null,
                    "Operação:",            //msg
                    "Escolha da operação.",     //title
                    JOptionPane.QUESTION_MESSAGE,   //title
                    null,          // icon
                    this.operations,         // Array of choices
                    this.operations[1]       // Initial choice
            );

            if (canceledOption(choice)) {
                getOut();
                continue;
            }
            if (this.numb2 == "")
            {
                continue;
            }

            if (choice.equals(optionLog)) {
                String logToShow = toString();
                msg(null, logToShow);
                continue;
            }

            this.numb2 = JOptionPane.showInputDialog(null, "Digite o segundo valor: ");
            if (canceledOption(this.numb2)) {
                getOut();
                continue;
            }
            double num2 = Double.parseDouble(numb2);

            String resultado = calcula(choice, num1, num2);
            if (resultado == null || resultado == "") {
                //ERRO
                String erroMsg = "Erro ao calcular o Resultado";
                msg(erroMsg, null);
            } else {
                msg(null, resultado);
            }


        }
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
                msg(erroMsg, null);
                retorno = null;
            }
            else{
                result = divisao(num1, num2);
                retorno = "Resultado: " + result;
            }
        }
        String newLog = numb1+" "+choice+" "+numb2+" = "+result;
        Log.writeLOG(newLog);

        return retorno;
    }

    public static void msg(String erroMsg, String result){
        if (result == null){
            JOptionPane.showMessageDialog(null,erroMsg);
        }
        else{
            JOptionPane.showMessageDialog(null,result);
        }
    }

    public boolean getOut()
    {
        String title = "EXIT";
        String msg = "Opção CALCEL selecionada.\nDeseja sair?";

        // 0=yes, 1=no, 2=cancel
        int answer = JOptionPane.showConfirmDialog(null,
                msg,
                title,
                JOptionPane.YES_NO_CANCEL_OPTION);

        switch (answer){
            case 0: // yes
                this.exit = true;
                break;
            case 1: // no
                this.exit = false;
                break;
            case 2: // Cancel
                this.exit = true;
                break;
            default:
                this.exit = false;
                break;
        }

        return exit;
    }


    public boolean canceledOption(String value)
    {
        if (value == null)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
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
