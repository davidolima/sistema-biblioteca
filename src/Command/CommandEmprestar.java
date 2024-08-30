package Command;
import Sistema.Logger;
import Sistema.Repositorio;
import Sistema.Livro;
import Sistema.Usuario.UsuarioBase;

public class CommandEmprestar implements Command {
    @Override
    public boolean run(String[] args){
        int codUsuario = Integer.parseInt(args[0]);
        int codLivro = Integer.parseInt(args[1]);
        Repositorio repo = Repositorio.getInstancia();

        UsuarioBase usuario = repo.buscaUsuarioPorCodigo(codUsuario);
        Livro livro = repo.buscaLivroPorCodigo(codLivro);

        if (usuario == null) {
            return Logger.logErroObjNaoExiste("usuário", codUsuario);
        }
        if (livro == null) {
            return Logger.logErroObjNaoExiste("livro", codLivro);
        }
        if (!usuario.pegarEmprestimo(livro)) {
            return false;
        }

        return Logger.logSucesso("Usuário `" + usuario.getNome() + "` realizou um empréstimo do livro `" + livro.getTitulo() + "` com sucesso.");
    }
}