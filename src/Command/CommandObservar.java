package Command;
import Sistema.Livro;
import Sistema.Logger;
import Sistema.Repositorio;
import Sistema.Usuario.UsuarioProfessor;

public class CommandObservar implements Command {
    @Override
    public boolean run(String[] args){
        int idUsuario = Integer.parseInt(args[0]);
        int idLivro = Integer.parseInt(args[1]);
        Repositorio repo = Repositorio.getInstancia();

        UsuarioProfessor usuario = (UsuarioProfessor) repo.buscaUsuarioPorCodigo(idUsuario);
        if (usuario == null) {
            Logger.logFalha("Nao existe usuario de codigo `" + idUsuario + "`");
            return false;
        }

        Livro livro = repo.buscaLivroPorCodigo(idLivro);
        if (livro == null) {
            Logger.logFalha("Nao existe livro de codigo `" + idLivro + "`");
            return false;
        }

        if (livro.buscarObservador(usuario) != null){
            livro.removerObservador(usuario);
            Logger.logSucesso("Usuário `" + usuario.getNome() + "` (#" + usuario.getId() + ") não está mais observando o livro `" + livro.getTitulo() + "` (#" + livro.getId() +").");
        } else {
            livro.adicionarObservador(usuario);
            Logger.logSucesso("Usuário `" + usuario.getNome() + "` (#" + usuario.getId() + ") agora está observando o livro `" + livro.getTitulo() + "` (#" + livro.getId() +").");
        }
        return true;
    }
}