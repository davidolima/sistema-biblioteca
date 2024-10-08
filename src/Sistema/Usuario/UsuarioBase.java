package Sistema.Usuario;

import Sistema.Emprestimo;
import Sistema.Exemplar;
import Sistema.Livro;
import Sistema.Logger;
import Sistema.Reserva;
import Sistema.StatusReserva;
import Sistema.Usuario.Strategy.IElegibilidade;

import java.util.ArrayList;

public abstract class UsuarioBase {
    public int Id;
    public String nome;
    public int maxTempoEmprestimoDias;
    public int maxEmprestimosEmAberto;
    public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    public ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    public IElegibilidade elegibilidade;

    public boolean isDevedor(){
        for (Emprestimo emprestimo : this.emprestimos){
            if (emprestimo.isAtrasado()){
                return true;
            }
        }
        return false;
    }

    public boolean isElegivelEmprestimo(Livro livro) {
        return elegibilidade.isElegivelEmprestimo(livro, this);
    }

    public boolean pegarEmprestimo(Livro livro) {
        assert livro != null;
        if (!this.isElegivelEmprestimo(livro)) {
            return false;
        }

        Exemplar exemplar = livro.pegarExemplarEmprestado();
        if (exemplar == null) {
            return false;
        }

        Emprestimo emprestimo = new Emprestimo(this, livro, exemplar);
        this.emprestimos.add(emprestimo);
        exemplar.registrarEmprestimo(emprestimo);
        finalizarReserva(livro);
       return true;
    }

    public boolean devolverEmprestimo(Livro livro){
        Emprestimo emprestimo = buscarEmprestimoPorCodigoLivro(livro.getId());
        if (emprestimo == null) {
            return Logger.logFalha("Usuário `" + getNome() + "` não apresenta empréstimos para o livro `" + livro.getTitulo() + "`.");
        }
        emprestimo.finalizar();
        return true;
    }

    public Emprestimo buscarEmprestimoPorCodigoLivro(int codigoLivro){
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivroId() == codigoLivro){
                return emprestimo;
            }
        }
        return null;
    }

    public boolean reservar(Livro livro){
        int qntReservasAbertas = 0;
        for (Reserva reserva : reservas){
            if (reserva.getStatus() == StatusReserva.EM_CURSO) qntReservasAbertas += 1;
            if (qntReservasAbertas >= 3) {
                return Logger.logFalha("Usuario `" + this.getNome() +"` ja possui o numero maximo de reservas abertas, " +
                        "e portanto nao pode reservar o livro `" + livro.getTitulo() + "` (#" + livro.getId() + ") ");
            }
        }
        if(!livro.adicionarReserva(this)){
            return Logger.logFalha("Usuario `" + this.getNome() +"` ja possui reserva aberta para o livro `" +
                    livro.getTitulo() + "` (#" + livro.getId() + ") ");
        }
        reservas.add(new Reserva(livro));
        return true;
    }

    public void finalizarReserva(Livro livro){
        for (Reserva reserva : reservas){
            if (reserva.getLivro() == livro && reserva.getStatus() == StatusReserva.EM_CURSO){
                reserva.finalizar();
                livro.finalizarReserva(this);
            }
        }
    }

    public void imprimirInfo(){
        Logger.logInfo("Informações do Usuário #" + getId() + " - `" + getNome() + "`:");
        Logger.logInfo("  ID: " + getId());
        Logger.logInfo("  Nome: " + getNome());
        Logger.logInfo("Emprestimos Realizados:");
        for (Emprestimo emprestimo : emprestimos) {
            Logger.logInfo("  " + emprestimo.toString());
        }
        Logger.logInfo("Reservas Realizadas:");
        for (Reserva reserva : reservas) {
            Logger.logInfo("  " + reserva.toString());
        }

    }

    public int getTempoEmprestimoDias() {
        return this.maxTempoEmprestimoDias;
    }
    public int getMaxEmprestimosEmAberto(){
        return this.maxEmprestimosEmAberto;
    }
    public int getId() {
        return Id;
    }
    public String getNome() {
        return this.nome;
    }
}
