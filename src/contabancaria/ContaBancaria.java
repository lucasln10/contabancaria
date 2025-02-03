package contabancaria;

import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private int numero;
    private int agencia;
    private int contadorNumero = 1;
    private int contadorAgencia = 0001;
    Scanner sc = new Scanner(System.in);
    public ContaBancaria () {
        this.numero = contadorNumero++;
        this.agencia = contadorAgencia;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }


    public void Depositar (double valor){
        if (valor < 0){
            System.out.println("Digite um valor maior do que 0.");
        }else{
            saldo+=valor;
        }
        if (valor >= 0 && valor <= 500){
            chequeEspecial = 50.0;
        } else if (valor > 500) {
            chequeEspecial = valor * 0.5;
        }
    }

    public void Sacar (double valor){
        if (valor > saldo){
            double valorTotal = saldo+chequeEspecial;
            System.out.println("O valor ultrapassa o saldo, será necessario utilizar o Cheque Especial");
            System.out.println("Digite sim para utilizar o Cheque Especial ou não para negar.");
            String resposta = sc.nextLine();
            if (resposta.toUpperCase().equalsIgnoreCase("SIM")){
                double diferenca = valor - saldo;
                saldo = 0;
                chequeEspecial -= diferenca;
                System.out.println("Saque realizado com sucesso usando Cheque Especial!");
            }else{
                System.out.println("Transação não concluida!");
            }
        }else if (valor > saldo+chequeEspecial){
            System.out.println("Saldo insuficiente!");

        }else{
            saldo -= valor;
        }

    }

    public void ConsultarSaldo (){
        System.out.println("Seu saldo é de: " + saldo);

    }

    public void consultarChequeEspecial (){
        System.out.println("O saldo do seu Cheque Especial é: " + chequeEspecial);
    }

    public void pagarBoleto (double valorDoBoleto){
        Sacar(valorDoBoleto);
    }

    public void verificarSeEstaUsandoChequeEspecial (){
        if (chequeEspecial < 50.0) {
            double usado = 50.0 - chequeEspecial;
            double taxa = usado * 0.2;
            System.out.printf("Você utilizou R$ %.2f do Cheque Especial. Uma taxa de 20%% (R$ %.2f) será cobrada.%n", usado, taxa);
        } else {
            System.out.println("Você não está utilizando o Cheque Especial.");
        }
    }


}
