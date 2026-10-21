public class DepositarCommand implements Command {
    private CuentaBancaria cuenta;
    private double monto;
    private boolean hecho = false; // para saber si de verdad se hizo

    public DepositarCommand(CuentaBancaria cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        hecho = cuenta.depositar(monto);
        if (hecho) {
            System.out.println("Deposito de $" + monto + " en la cuenta de " + cuenta.getTitular());
        } else {
            System.out.println("Deposito rechazado (monto invalido)");
        }
    }

    @Override
    public void deshacer() {
        if (!hecho) {
            System.out.println("No hay deposito que deshacer");
            return;
        }
        cuenta.retirar(monto);
        hecho = false;
        System.out.println("Se deshizo el deposito de $" + monto + " de " + cuenta.getTitular());
    }
}
