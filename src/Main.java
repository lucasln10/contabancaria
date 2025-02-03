import contabancaria.ContaBancaria;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria();

        conta1.ConsultarSaldo();
        conta1.Depositar(200);
        conta1.consultarChequeEspecial();
        conta1.pagarBoleto(150);
        conta1.ConsultarSaldo();
        conta1.Depositar(400);
        conta1.consultarChequeEspecial();
        conta1.Sacar(500);
        conta1.consultarChequeEspecial();
        conta1.verificarSeEstaUsandoChequeEspecial();
        conta1.ConsultarSaldo();
    }
}