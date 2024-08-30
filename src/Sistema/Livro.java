package Sistema;

import Sistema.Usuario.*;

import java.util.ArrayList;
//import java.util.Arrays;

public class Livro implements IObservavel {
    public int id;
    public String titulo;
    public String editora;
    public int edicao;
    public int anoPublicacao;
    public String autores[];
    public ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
    public ArrayList<IObservador> observadores = new ArrayList<IObservador>();
    public ArrayList<UsuarioBase> reservandos = new ArrayList<UsuarioBase>();

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
            Logger.logFalha("O Livro `" + getTitulo() + "` (#" + getId() + ") não apresenta exemplares disponíveis.");
            return null;
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

    public boolean estaReservando(UsuarioBase user){
        for (UsuarioBase reservando : this.reservandos){
            if (reservando == user) return true;
        }
        return false;
    }

    public boolean adicionarReserva(UsuarioBase user) {
        if (estaReservando(user)) return false;
        reservandos.add(user);
        if (this.reservandos.size() > 2) {
            this.notificarObservadores();
        }
        return true;
    }

    public void finalizarReserva(UsuarioBase user) {
        for (UsuarioBase reservando : this.reservandos){
            if (reservando == user) {
                reservandos.remove(reservando);
            }
        }
    }

    public boolean menosReservasQueExemplares(){
        return reservandos.size() < exemplares.size();
    }

    public void imprimirInfo(){
        Logger.logInfo("Informações do Livro #" + getId() + ":");
        Logger.logInfo(" - Título: " + getTitulo());
        Logger.logInfo("  Qtd. Reservas: " + reservandos.size());
        if (reservandos.size() > 0){
            Logger.logInfo(" + Usuários reservando: ");
            for (UsuarioBase reservando : this.reservandos){
                Logger.logInfo("  - "+reservando.getNome());
            }
        }
        Logger.logInfo(" + Exemplares: ");
        for (Exemplar exemplar : this.exemplares){
            Logger.logInfo("  - "+exemplar.toString());
        }

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
