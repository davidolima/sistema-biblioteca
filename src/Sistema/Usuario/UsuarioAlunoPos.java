package Sistema.Usuario;
import Sistema.Livro;

public class UsuarioAlunoPos extends UsuarioBase {

    public UsuarioAlunoPos(int Id, String nome){
        this.Id = Id;
        this.nome = nome;
        this.prioridade = 0;
        this.maxTempoEmprestimoDias = 5;
        this.maxEmprestimosEmAberto = 4;
    }

    @Override
    public boolean isElegivelEmprestimo(Livro livro) {
        boolean naoEstaDevendo = !isDevedor();
        boolean limEmprestimoNaoExcedido = (this.emprestimos.size() < maxEmprestimosEmAberto);
        boolean jaTemExemplar = (this.buscarEmprestimoPorCodigoLivro(livro.getId()) == null);
        return naoEstaDevendo && limEmprestimoNaoExcedido && jaTemExemplar;
    }
}
