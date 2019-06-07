package alex.silva;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String numb1, numb2;
        boolean exit = false;
        final String HISTORICO_OPTION = "Histórico";
        String[] operations = {"+","-","/","*", HISTORICO_OPTION};


        Calculator calc = new Calculator();

        while(!exit)
        {
            //Entrada 1
            numb1 = JOptionPane.showInputDialog(null, "Digite o Primeiro valor: ");
            if (canceledOption(numb1)) {
                exit = getOut();
                continue;
            }
            if (numb1 == "")
                continue;
            double num1 = Double.parseDouble(numb1);

            //Operação
            String menu = "\n( + ) SOMAR\n( - ) SUBTRAIR\n( * ) MULTIPLICAR\n( / ) DIVIDIR\n Histórico\n\n";
            String choice = (String) JOptionPane.showInputDialog(null,
                    menu,            //msg
                    "Escolha a opção:",     //title
                    JOptionPane.QUESTION_MESSAGE,   //title
                    null,          // icon
                    operations,         // Array of choices
                    operations[1]       // Initial choice
            );

            if (canceledOption(choice)) {
                exit = getOut();
                continue;
            }

            if (choice.equals(HISTORICO_OPTION)) {
                String logToShow = calc.toString();
                msg(null, logToShow);
                continue;
            }

            // Entrada 2
            numb2 = JOptionPane.showInputDialog(null, "Digite o segundo valor: ");
            if (canceledOption(numb2)) {
                exit = getOut();
                continue;
            }
            if (numb2 == "")
                continue;
            double num2 = Double.parseDouble(numb2);

            //RESULTADO
            String resultado = calc.calcula(choice, num1, num2);

            if (resultado == null || resultado == "") {
                //ERRO
                String erroMsg = "Erro ao calcular o Resultado";
                msg(erroMsg, null);
            } else {
                msg(null, resultado);
            }
        }
    }

    public static void msg(String erroMsg, String result){
        if (result == null){
            JOptionPane.showMessageDialog(null,erroMsg);
        }
        else{
            JOptionPane.showMessageDialog(null,result);
        }
    }

    public static boolean getOut()
    {
        boolean exit = false;
        String title = "EXIT";
        String msg = "Opção CALCEL selecionada.\nDeseja sair?";

        // 0=yes, 1=no, 2=cancel
        int answer = JOptionPane.showConfirmDialog(null,
                msg,
                title,
                JOptionPane.YES_NO_CANCEL_OPTION);

        switch (answer){
            case 0: // yes
                exit = true;
                break;
            case 1: // no
                exit = false;
                break;
            case 2: // Cancel
                exit = true;
                break;
            default:
                exit = false;
                break;
        }
        return exit;
    }


    public static boolean canceledOption(String value)
    {
        if (value == null)
        {
            return true;
        }
        return false;
    }
}
