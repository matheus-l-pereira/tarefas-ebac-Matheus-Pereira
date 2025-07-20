/**
 * @author Matheus Lourençoni Pereira
 */

public class Produto {

    private int codigo;

    private String nome;

    private double preco;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    //imprimi o nome do produto na tela
    public void imprimirNomeProduto(){
        System.out.println(this.nome);
    }
    /*
    Imprimi o preço do produto já
    informando a moeda local
     */
    public void imprimirPreco(){
        System.out.println("R$" + this.preco);
    }
}
