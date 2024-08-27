package Sistema;

import java.util.ArrayList;

public class AlunoGrad extends Usuario {
    public int ID;
    public String nome;
    public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    public int prioridade = 0;

    public int maxTempoEmprestimoDias = 3;
    public int maxEmprestimos = 3;

    public AlunoGrad(int ID, String nome){
        this.ID = ID;
        this.nome = nome;
    }

    @Override
    public boolean isElegivelEmprestimo() {
        return super.isElegivelEmprestimo();
    }
}
