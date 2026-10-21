public class Cliente {
    public static void main(String[] args) {
        CuentaBancaria ana = new CuentaBancaria("Ana", 100000);
        CuentaBancaria luis = new CuentaBancaria("Luis", 50000);
        CajeroAutomatico cajero = new CajeroAutomatico();

        System.out.println("Transacciones");
        cajero.ejecutarComando(new ConsultarSaldoCommand(ana));
        cajero.ejecutarComando(new DepositarCommand(ana, 200000));
        cajero.ejecutarComando(new RetirarCommand(ana, 80000));
        cajero.ejecutarComando(new TransferirCommand(ana, luis, 120000));
        cajero.ejecutarComando(new ConsultarSaldoCommand(ana));
        cajero.ejecutarComando(new ConsultarSaldoCommand(luis));

        System.out.println("\nCaso que falla");
        cajero.ejecutarComando(new RetirarCommand(luis, 999999));

        System.out.println("\nDeshacer");
        cajero.deshacerUltimo(); 
        cajero.deshacerUltimo(); 
        cajero.deshacerUltimo(); 
        cajero.deshacerUltimo(); 

        System.out.println("\nSaldos finales");
        cajero.ejecutarComando(new ConsultarSaldoCommand(ana));
        cajero.ejecutarComando(new ConsultarSaldoCommand(luis));
    }
}
