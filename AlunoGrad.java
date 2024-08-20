import java.util.ArrayList;

public class AlunoGrad extends Usuario {
    public int ID;
    public String nome;
    public ArrayList<Emprestimo> emprestimos;
    public int prioridade;

    public int maxTempoEmprestimoDias = 3;
    public int maxEmprestimos = 3;
    //public EmprestimoEstrategia emprestimoEstrategia;

    public boolean excedeuMaxEmprestimos(){
        if (emprestimos.size() >= this.maxEmprestimos){
            return true;
        }
        return false;
    }

    public boolean isDevedor(){
        for (Emprestimo emprestimo : this.emprestimos){
            if (emprestimo.isAtrasado()){
                return true;
            }
        }
        return false;
    }

    public void pegarEmprestimo(Livro livro) {};
    public void devolverEmprestimo(Livro livro) {};
    public int getTempoEmprestimoDias(){
        return this.tempoEmprestimoDias;
    }
}
