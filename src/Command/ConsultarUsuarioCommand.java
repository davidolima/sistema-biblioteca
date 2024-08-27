package Command;
import Sistema.Logger;
import Sistema.Repositorio;
import Sistema.Usuario;

public class ConsultarUsuarioCommand implements Command {
    @Override
    public boolean run(String[] args) {
        int codUsuario = Integer.parseInt(args[0]);
        Repositorio repo = Repositorio.getInstancia();
        Usuario usuario = repo.buscaUsuarioPorCodigo(codUsuario);
        if (usuario == null) {
            Logger.logFalha("Nao existe usuario de codigo `" + codUsuario + "`.");
            return false;
        }
        usuario.imprimirInfo();
        return true;
    }
}
