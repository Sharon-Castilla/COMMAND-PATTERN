public class ConsultarSaldoCommand implements Command {
    private CuentaBancaria cuenta;

    public ConsultarSaldoCommand(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void ejecutar() {
        System.out.println("Saldo de " + cuenta.getTitular() + ": $" + cuenta.consultar());
    }

    @Override
    public void deshacer() {
        System.out.println("Consultar saldo no se puede deshacer");
    }
}
