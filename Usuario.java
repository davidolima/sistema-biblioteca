import java.util.ArrayList;

public abstract class Usuario {
    public int ID;
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

    public void pegarEmprestimo(Livro livro) {
        if (!this.isElegivelEmprestimo()) {
            return; // TODO: Notificar sistema da falha.
        }

        Emprestimo emprestimo = new Emprestimo(this, livro);
        this.emprestimos.add(emprestimo);
        // TODO: Notificar sistema do sucesso.
    }

    public void devolverEmprestimo(Livro livro){
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getItemId() == livro.getId()){
                emprestimo.finalizar();
                return; // TODO: Notificar sistema do sucesso
            }
        }
        return; // TODO: Notificar sistema da falha
    };

    public int getTempoEmprestimoDias() {
        return this.tempoEmprestimoDias;
    }
}
