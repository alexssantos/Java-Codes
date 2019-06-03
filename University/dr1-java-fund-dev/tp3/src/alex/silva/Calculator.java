package alex.silva;

import javax.swing.*;

public class Calculator implements ICalculator {
    String numb1, numb2;
    String optionLog = "Show Historic";
    String[] operations = {"+","-","/","*", optionLog};
    Log Log;

    public Calculator() {
        Log = new Log();
    }

    public Calculator(String numb1, String numb2) {
        this.numb1 = numb1;
        this.numb2 = numb2;
        Log = new Log();
    }

    public void start(){


        this.numb1 = JOptionPane.showInputDialog(null, "Digite o Primeiro valor: ");
        if (canceledOption(this.numb1)){
            return;
        }
        double num1 =Double.parseDouble(numb1);

        String choice = (String) JOptionPane.showInputDialog(null,
                "Operação:",            //msg
                "Escolha da operação.",     //title
                JOptionPane.QUESTION_MESSAGE,   //title
                null,          // icon
                this.operations,         // Array of choices
                this.operations[1]       // Initial choice
        );
        if (choice.equals(optionLog))
        {
            toString();
            return;
        }
        if (canceledOption(choice)){
            return;
        }

        this.numb2 = JOptionPane.showInputDialog(null, "Digite o segundo valor: ");
        if (canceledOption(this.numb2)){
            return;
        }
        double num2 =Double.parseDouble(numb2);

        String resultado = calcula(choice, num1,num2);
        if (resultado == null){
            //ERRO
            return;
        }
        else
        {
            msg(null, resultado);
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
    };

    public static boolean canceledOption(String value)
    {
        if (value ==null)
        {
            msg("Opção CALCEL selecionada.\nSaindo do programa...",null);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString() {
        String logHistory = "";

        for (int i = 0; i < Log.LOG.length; i++)
        {
            logHistory += Log.LOG[i] + "\n";
        }
        return logHistory;
    }
}
