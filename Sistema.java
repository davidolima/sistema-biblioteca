import java.util.ArrayList;

public class Sistema {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Livro> livros = new ArrayList<Livro>();

    public static void main(String args[]){

        String autores[] = {"Ian Sommervile"};
        Livro l1 = new Livro("Engenharia de Software", 6, "AddisonWesley", 2000, autores);

        l1.adicionarExemplar();
        l1.adicionarExemplar();
        l1.adicionarExemplar();

        // Livro l2 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l3 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l4 = new Livro(titulo, edicao, anoPublicacao, autores);

        // Livro l5 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l6 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l7 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l8 = new Livro(titulo, edicao, anoPublicacao, autores);

    }

}
