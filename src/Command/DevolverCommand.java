package Command;
import Sistema.Repositorio;
import Sistema.Livro;
import Sistema.Usuario;

public class DevolverCommand implements Command {
    @Override
    public String run(Argumentos args){
        String[] argumentos = args.getArgumentos();
        int codUsuario = Integer.parseInt(argumentos[0]);
        int codLivro = Integer.parseInt(argumentos[1]);
        Repositorio repo = Repositorio.getInstancia();

        Usuario usuario = repo.buscaUsuarioPorCodigo(codUsuario);
        Livro livro = repo.buscaLivroPorCodigo(codLivro);

        if (usuario == null) {
            return "Nao existe usuario de codigo `" + codUsuario + "`";
        }
        if (livro == null) {
            return "Nao existe livro de codigo `" + codLivro + "`";
        }

        return usuario.devolverEmprestimo(livro);
    }
}