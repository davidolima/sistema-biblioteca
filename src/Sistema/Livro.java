package Sistema;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Livro extends ObservavelBase{
    public int id;
    public String titulo;
    public String editora;
    public int edicao;
    public int anoPublicacao;
    public String autores[];
    public ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();

    public Livro (int id, String titulo, int edicao, String editora, int anoPublicacao, String autores[]) {
        this.id = id;
        this.titulo = titulo;
        this.edicao = edicao;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.autores = autores;
    }

    public void adicionarExemplar() {
        Exemplar newExemplar = new Exemplar(this.id);
        this.exemplares.add(newExemplar);
    }

    public void removerExemplar(int codigoExemplar) {
        for (Exemplar exemplar : this.exemplares){
            if (exemplar.getId() == codigoExemplar) {
                this.exemplares.remove(exemplar);
            }
        }
    }

    public Exemplar getExemplarDisponivel() {
        for (Exemplar exemplar : this.exemplares) {
            if (exemplar.isDisponivel()){
                return exemplar;
            }
        }
        return null;
    }

    public void imprimirInfo(){
        Logger.logInfo("Informações do Livro `" + getId() + "` - " + getTitulo());
        Logger.logInfo("  ID: " + getId());
        Logger.logInfo("  Titulo: " + getTitulo());
        Logger.logInfo("  Editora: " + getEditora());
        Logger.logInfo("  Edicao: " + getEdicao());
        Logger.logInfo("  Ano de Publicacao: " + getAnoPublicacao());
        Logger.logInfo("  Autores: " + getAutores());
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
