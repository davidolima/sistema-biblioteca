package Sistema.Usuario;

import Sistema.Emprestimo;
import Sistema.Exemplar;
import Sistema.Livro;
import Sistema.Logger;

import java.util.ArrayList;

public abstract class UsuarioBase {
    public int Id;
    public String nome;

    public int prioridade;
    public int maxTempoEmprestimoDias;
    public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public boolean isDevedor(){
        for (Emprestimo emprestimo : this.emprestimos){
            if (emprestimo.isAtrasado()){
                return true;
            }
        }
        return false;
    }

    public boolean isElegivelEmprestimo(Livro livro) {
        return !isDevedor() && (livro != null);
    }

    public boolean pegarEmprestimo(Livro livro) {
        assert livro != null;
        if (!this.isElegivelEmprestimo(livro)) {
            Logger.logFalha("Usuario`" + this.getNome() +"` nao e elegivel para pegar um emprestimo.");
            return false;
        }

        Exemplar exemplar = livro.pegarExemplarEmprestado();
        if (exemplar == null) {
            return false;
        }

        Emprestimo emprestimo = new Emprestimo(this, livro, exemplar);
        this.emprestimos.add(emprestimo);
        Logger.logSucesso("Usuario `" + this.getNome() + "` realizou um emprestimo do livro `" + livro.getTitulo() + "` com sucesso.");
        return true;
    }

    public boolean devolverEmprestimo(Livro livro){
        Emprestimo emprestimo = buscarEmprestimoPorCodigoLivro(livro.getId());
        if (emprestimo == null) {
            Logger.logFalha("Usuario `" + getNome() + "` nao apresenta emprestimos para o livro `" + livro.getTitulo() + "`.");
            return false;
        }
        emprestimo.finalizar();
        Logger.logSucesso("Usuario `" + getNome() + "` devolveu o livro `" + livro.getTitulo() + "` com sucesso.");
        return true;
    };

    public Emprestimo buscarEmprestimoPorCodigoLivro(int codigoLivro){
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivroId() == codigoLivro){
                return emprestimo;
            }
        }
        return null;
    }

    public void imprimirInfo(){
        Logger.logInfo("Informações do Usuário #" + getId() + " - `" + getNome() + "`:");
        Logger.logInfo("  ID: " + getId());
        Logger.logInfo("  Nome: " + getNome());
        Logger.logInfo("Emprestimos Realizados:");
        for (Emprestimo emprestimo : emprestimos) {
            Logger.logInfo("  " + emprestimo.toString()); // TODO: Alterar para ficar conforme roteiro.
        }
    }

    public int getTempoEmprestimoDias() {
        return this.maxTempoEmprestimoDias;
    }
    public int getId() {
        return Id;
    }
    public String getNome() {
        return this.nome;
    }
}
