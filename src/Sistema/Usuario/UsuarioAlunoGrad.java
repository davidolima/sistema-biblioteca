package Sistema.Usuario;

public class UsuarioAlunoGrad extends UsuarioBase {
    public int maxEmprestimosEmAberto;

    public UsuarioAlunoGrad(int Id, String nome){
        this.Id = Id;
        this.nome = nome;
        this.prioridade = 0;
        this.maxTempoEmprestimoDias = 3;
        this.maxEmprestimosEmAberto = 3;
    }

    @Override
    public boolean isElegivelEmprestimo() {
        return super.isElegivelEmprestimo();
    }
}
