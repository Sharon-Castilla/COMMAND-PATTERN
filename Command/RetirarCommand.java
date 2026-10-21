public class RetirarCommand implements Command {
    private CuentaBancaria cuenta;
    private double monto;
    private boolean hecho = false;

    public RetirarCommand(CuentaBancaria cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        hecho = cuenta.retirar(monto);
        if (hecho) {
            System.out.println("Retiro de $" + monto + " de la cuenta de " + cuenta.getTitular());
        } else {
            System.out.println("Retiro rechazado (fondos insuficientes o monto invalido)");
        }
    }

    @Override
    public void deshacer() {
        if (!hecho) {
            System.out.println("No hay retiro que deshacer");
            return;
        }
        cuenta.depositar(monto);
        hecho = false;
        System.out.println("Se deshizo el retiro de $" + monto + " de " + cuenta.getTitular());
    }
}
