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
            Logger.logFalha("Nao existe usuario de codigo `" + codUsuario + "`.");
            return false;
        }
        if (livro == null) {
            Logger.logFalha("Nao existe livro de codigo `" + codLivro + "`.");
            return false;
        }

        usuario.devolverEmprestimo(livro);
        Logger.logSucesso("Usuario `" + usuario.getNome() + "` devolveu seu exemplar do livro `" + livro.getTitulo() + "` com sucesso.");
        return true;
    }
}