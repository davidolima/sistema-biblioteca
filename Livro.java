import java.util.ArrayList;

public class Livro {
    public static int idCounter = -1;

    public int id;
    public String titulo;
    public String editora;
    public int edicao;
    public int anoPublicacao;
    public String autores[];
    public ArrayList<Exemplar> exemplares;

    public static int increaseID(){
        Livro.idCounter += 1;
        return Livro.idCounter;
    }

    public Livro (int id, String titulo, int edicao, String editora, int anoPublicacao, String autores[]){
        this.id = id;
        this.titulo = titulo;
        this.edicao = edicao;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.autores = autores;
        this.exemplares = new ArrayList<Exemplar>();
    }

    public Livro (String titulo, int edicao, String editora, int anoPublicacao, String autores[]){
        this(increaseID(), titulo, edicao, editora, anoPublicacao, autores);
    }

    public void adicionarExemplar() {
        Exemplar newExemplar = new Exemplar();
        this.exemplares.add(newExemplar);
    }

    public void removerExemplar(int codigoExemplar) {
        for (Exemplar exemplar : this.exemplares){
            if (exemplar.getId() == codigoExemplar) {
                this.exemplares.remove(exemplar);
            }
        }
    }

    public boolean isThereExemplarAvailable(){
        for (Exemplar exemplar : this.exemplares) {
            if (exemplar.isDisponivel()){
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String[] getAutores() {
        return autores;
    }
}
