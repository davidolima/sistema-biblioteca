package SistemaPkg;

import java.util.ArrayList;

public class Livro {
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
