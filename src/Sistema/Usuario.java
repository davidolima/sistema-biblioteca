package Sistema;

import java.util.ArrayList;

public abstract class Usuario {
    public int Id;
    public String nome;
    public int tempoEmprestimoDias;
    public ArrayList<Emprestimo> emprestimos;
    public int prioridade;
    //public EmprestimoStrategy emprestimoStrategy;

    public boolean isDevedor(){
        for (Emprestimo emprestimo : this.emprestimos){
            if (emprestimo.isAtrasado()){
                return true;
            }
        }
        return false;
    }

    public boolean isElegivelEmprestimo() {
        return !this.isDevedor();
    }

    public String pegarEmprestimo(Livro livro) {
        if (!this.isElegivelEmprestimo()) {
            return "Usuario`" + this.getNome() +"`nao e elefivel para pegar um emprestimo."; // TODO: Notificar sistema da falha.
        }
        Exemplar exemplar = livro.getExemplarDisponivel();
        if (exemplar == null) {
            return "Nao existe exemplares disponiveis para o livro `" + livro.getTitulo() + "`.";
        }

        Emprestimo emprestimo = new Emprestimo(this, exemplar);
        this.emprestimos.add(emprestimo);
        return "Usuario `" + this.getNome() + "` realizou um emprestimo do livro `" + livro.getTitulo() + "` com sucesso.";
        // TODO: Notificar sistema do sucesso.
    }

    public String devolverEmprestimo(Livro livro){
        Emprestimo emprestimo = buscarEmprestimoPorCodigoLivro(livro.getId());
        if (emprestimo == null) {
            return "Usuario `" + getNome() + "` nao apresenta emprestimos para o livro `" + livro.getTitulo() + "`.";
        }
        emprestimo.finalizar();
        return "Usuario `" + getNome() + "` devolveu o livro `" + livro.getTitulo() + "` com sucesso.";
    };

    public Emprestimo buscarEmprestimoPorCodigoLivro(int codigoLivro){
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivroId() == codigoLivro){
                return emprestimo;
            }
        }
        return null;
    }

    public int getTempoEmprestimoDias() {
        return this.tempoEmprestimoDias;
    }
    public int getId() {
        return Id;
    }
    public String getNome() {
        return this.nome;
    }
}
