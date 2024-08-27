package Sistema.Usuario;

import Sistema.Livro;

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
    public boolean isElegivelEmprestimo(Livro livro) {
        boolean naoEstaDevendo = !isDevedor();
        boolean limEmprestimoNaoExcedido = (this.emprestimos.size() < maxEmprestimosEmAberto);
        boolean jaTemExemplar = (this.buscarEmprestimoPorCodigoLivro(livro.getId()) == null);
        return naoEstaDevendo && limEmprestimoNaoExcedido && jaTemExemplar;
    }
}
