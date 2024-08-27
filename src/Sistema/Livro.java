package Sistema;

import Sistema.Usuario.UsuarioProfessor;

import java.util.ArrayList;

public class Livro implements IObservavel {
    public int id;
    public String titulo;
    public String editora;
    public int edicao;
    public int anoPublicacao;
    public String autores[];
    public ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
    public ArrayList<IObservador> observadores = new ArrayList<IObservador>();

    public Livro (int id, String titulo, int edicao, String editora, int anoPublicacao, String autores[]) {
        this.id = id;
        this.titulo = titulo;
        this.edicao = edicao;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.autores = autores;
    }

    public Exemplar pegarExemplarEmprestado(){
        Exemplar exemplar = getExemplarDisponivel();

        if (exemplar == null) {
            Logger.logFalha("O Livro `" + getTitulo() + "` (#" + getId() + ") " + "nao apresenta exemplares disponíveis.");
            return null;
        }

        if (this.getContagemExemplaresIndisponiveis() >= 2) {
            this.notificarObservadores();
        }

        exemplar.pegarEmprestado();
        return exemplar;
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

    public int getContagemExemplaresIndisponiveis(){
        int contagem = 0;
        for (Exemplar exemplar : this.exemplares){
            contagem += exemplar.isDisponivel() ? 0 : 1;
        }
        return contagem;
    }

    public void imprimirInfo(){
        Logger.logInfo("Informações do Livro #" + getId() + " - `" + getTitulo() + "`:");
        Logger.logInfo("  ID: " + getId());
        Logger.logInfo("  Titulo: " + getTitulo());
        Logger.logInfo("  Editora: " + getEditora());
        Logger.logInfo("  Edicao: " + getEdicao());
        Logger.logInfo("  Ano de Publicacao: " + getAnoPublicacao());
        Logger.logInfo("  Autores: " + getAutores());
    }

    public IObservador buscarObservador(IObservador observador) {
        for (IObservador observadorExistente : observadores){
            if (observadorExistente.equals(observador)){
                return observadorExistente;
            }
        }
        return null;
    }
    @Override
    public void adicionarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (IObservador observador : observadores) {
            observador.atualizar();
        }
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
