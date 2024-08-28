package Sistema.Usuario;
import Sistema.Livro;
import Sistema.Usuario.Strategy.ElegibilidadeAluno;

public class UsuarioAlunoGrad extends UsuarioBase {

    public UsuarioAlunoGrad(int Id, String nome){
        this.Id = Id;
        this.nome = nome;
        //this.prioridade = 0;
        this.maxTempoEmprestimoDias = 3;
        this.maxEmprestimosEmAberto = 3;
        this.elegibilidade = new ElegibilidadeAluno();
    }

    @Override
    public boolean isElegivelEmprestimo(Livro livro) {
        return elegibilidade.isElegivelEmprestimo(livro, this);
    }
}
