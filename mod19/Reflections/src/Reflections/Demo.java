package Reflections;

public class Demo {
    public static void main(String [] args){
        Class<ClasseComAnotacao> classeComAnotacaoClass = ClasseComAnotacao.class;

        if(classeComAnotacaoClass.isAnnotationPresent(Tabela.class)){
            Tabela tabela = classeComAnotacaoClass.getAnnotation(Tabela.class);

            System.out.println("O nome da tabela é: " + tabela.value());
        }
    }
}
