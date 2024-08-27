package Sistema.Usuario;

public class UsuarioAlunoPos extends UsuarioBase {
    public int maxEmprestimosEmAberto;

    public UsuarioAlunoPos(int Id, String nome){
        this.Id = Id;
        this.nome = nome;
        this.prioridade = 0;
        this.maxTempoEmprestimoDias = 5;
        this.maxEmprestimosEmAberto = 4;
    }

    @Override
    public boolean isElegivelEmprestimo() {
        return super.isElegivelEmprestimo();
    }
}
