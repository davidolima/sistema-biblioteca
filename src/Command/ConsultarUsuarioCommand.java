package Command;
import Sistema.Repositorio;
import Sistema.Usuario;

public class ConsultarUsuarioCommand implements Command {
    @Override
    public String run(Argumentos args) {
        int codUsuario = Integer.parseInt(args.getArgumentos()[0]);
        Repositorio repo = Repositorio.getInstancia();
        Usuario usuario = repo.buscaUsuarioPorCodigo(codUsuario);
        if (usuario == null) {
            return "Usuario nao encontrado";
        }
        return usuario.toString();
    }
}
