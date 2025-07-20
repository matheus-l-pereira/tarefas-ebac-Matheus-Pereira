//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá Matheus");

        Cliente cliente = new Cliente();
        cliente.cadastrarEndereco("Rua 1");
        cliente.setCodigo(1);
        System.out.println(cliente.getCodigo());

        //cliente.imprimirEndereco();
        System.out.println(cliente.retornarNomeCliente());
        System.out.println(cliente.getValorTotal());

    }
}