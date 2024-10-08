package Command;
import Sistema.Logger;
import Sistema.Repositorio;
import Sistema.Livro;
import Sistema.Usuario.UsuarioBase;

public class CommandDevolver implements Command {
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
            return Logger.logErroObjNaoExiste("livro", codUsuario);
        }

        usuario.devolverEmprestimo(livro);
        return Logger.logSucesso("Usuário `" + usuario.getNome() + "` devolveu seu exemplar do livro `" + livro.getTitulo() + "` com sucesso.");
    }
}