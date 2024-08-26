package SistemaPkg;

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

    public void pegarEmprestimo(Exemplar exemplar) {
        if (!this.isElegivelEmprestimo()) {
            return; // TODO: Notificar sistema da falha.
        }

        Emprestimo emprestimo = new Emprestimo(this, exemplar);
        this.emprestimos.add(emprestimo);
        // TODO: Notificar sistema do sucesso.
    }

    public void devolverEmprestimo(int codigoExemplar){
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getExemplarId() == codigoExemplar){
                emprestimo.finalizar();
                return; // TODO: Notificar sistema do sucesso
            }
        }
        return; // TODO: Notificar sistema da falha
    };

    public int getTempoEmprestimoDias() {
        return this.tempoEmprestimoDias;
    }
    public int getId() {
        return Id;
    }
}
