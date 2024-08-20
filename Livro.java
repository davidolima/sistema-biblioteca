import java.util.ArrayList;

public class Livro {
    public static int idCounter = 0;

    public int id;
    public String titulo;
    public int edicao;
    public int anoPublicacao;
    public ArrayList<String> autores;

    public static void increaseID(){
        Livro.idCounter += 1;
    }

    public Livro (String titulo, int edicao, int anoPublicacao, ArrayList<String> autores){
        this.titulo = titulo;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.autores = autores;

        this.id = idCounter;
        Livro.increaseID();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getEdicao() {
        return edicao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }
}
