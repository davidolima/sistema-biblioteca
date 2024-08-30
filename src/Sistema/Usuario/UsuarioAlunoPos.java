package Sistema.Usuario;
import Sistema.Usuario.Strategy.ElegibilidadeAluno;

public class UsuarioAlunoPos extends UsuarioBase {

    public UsuarioAlunoPos(int Id, String nome){
        this.Id = Id;
        this.nome = nome;
        this.maxTempoEmprestimoDias = 5;
        this.maxEmprestimosEmAberto = 4;
        this.elegibilidade = new ElegibilidadeAluno();
    }

}
