public class TransferirCommand implements Command {
    private CuentaBancaria origen;
    private CuentaBancaria destino;
    private double monto;
    private boolean hecho = false;

    public TransferirCommand(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        hecho = origen.transferir(destino, monto);
        if (hecho) {
            System.out.println("Transferencia de $" + monto + " de " + origen.getTitular()
                    + " a " + destino.getTitular());
        } else {
            System.out.println("Transferencia rechazada (fondos insuficientes o monto invalido)");
        }
    }

    @Override
    public void deshacer() {
        if (!hecho) {
            System.out.println("No hay transferencia que deshacer");
            return;
        }
        destino.transferir(origen, monto);
        hecho = false;
        System.out.println("Se deshizo la transferencia de $" + monto);
    }
}
