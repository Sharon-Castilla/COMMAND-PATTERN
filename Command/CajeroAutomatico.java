import java.util.Stack;

public class CajeroAutomatico {
    private Stack<Command> historial = new Stack<>();

    public void ejecutarComando(Command comando) {
        comando.ejecutar();
        historial.push(comando);
    }

    public void deshacerUltimo() {
        if (historial.isEmpty()) {
            System.out.println("No hay operaciones para deshacer");
            return;
        }
        historial.pop().deshacer();
    }
}
