package Command;
import Sistema.Livro;
import Sistema.Logger;
import Sistema.Repositorio;
import Sistema.Usuario.UsuarioProfessor;

public class CommandObservar implements Command {
    @Override
    public boolean run(String[] args){
        int codUsuario = Integer.parseInt(args[0]);
        int codLivro = Integer.parseInt(args[1]);
        Repositorio repo = Repositorio.getInstancia();

        UsuarioProfessor usuario = (UsuarioProfessor) repo.buscaUsuarioPorCodigo(codUsuario);
        if (usuario == null) {
            return Logger.logErroObjNaoExiste("usuario", codUsuario);
        }

        Livro livro = repo.buscaLivroPorCodigo(codLivro);
        if (livro == null) {
            return Logger.logErroObjNaoExiste("livro", codLivro);
        }

        // Se o usuário já está observando aquele livro, deixar de observar.
        if (livro.buscarObservador(usuario) != null){
            livro.removerObservador(usuario);
            return Logger.logSucesso("Usuário `" + usuario.getNome() + "` (#" + usuario.getId() + ") não está mais observando o livro `" + livro.getTitulo() + "` (#" + livro.getId() +").");
        }
        livro.adicionarObservador(usuario);
        return Logger.logSucesso("Usuário `" + usuario.getNome() + "` (#" + usuario.getId() + ") agora está observando o livro `" + livro.getTitulo() + "` (#" + livro.getId() +").");
    }
}