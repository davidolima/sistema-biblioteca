package Command;
import Sistema.Logger;
import Sistema.Repositorio;
import Sistema.Usuario.UsuarioBase;

public class CommandConsultarUsuario implements Command {
    @Override
    public boolean run(String[] args) {
        int codUsuario = Integer.parseInt(args[0]);
        Repositorio repo = Repositorio.getInstancia();
        UsuarioBase usuario = repo.buscaUsuarioPorCodigo(codUsuario);
        if (usuario == null) {
            return Logger.logErroObjNaoExiste("usuário", codUsuario);
        }
        usuario.imprimirInfo();
        return true;
    }
}
