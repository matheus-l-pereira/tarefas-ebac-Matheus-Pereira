//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Coquinha Zero");
        produto.setCodigo(001);
        produto.setPreco(9.50);

        System.out.println(produto.getCodigo());
        produto.imprimirNomeProduto();
        produto.imprimirPreco();
    }
}