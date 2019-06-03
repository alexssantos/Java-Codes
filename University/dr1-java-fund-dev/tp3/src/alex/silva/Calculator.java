package alex.silva;

import javax.swing.*;

public class Calculator implements ICalculator {
    String numb1, numb2;

    public Calculator() {
    }

    public Calculator(String numb1, String numb2) {
        this.numb1 = numb1;
        this.numb2 = numb2;
    }

    public void start(){
        String[] operations = {"+","-","/","*"};

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
                operations,         // Array of choices
                operations[1]       // Initial choice
        );
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
        double result;
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
            msg("Saindo do programa...",null);
            return true;
        }
        else
        {
            return false;
        }
    }

}
