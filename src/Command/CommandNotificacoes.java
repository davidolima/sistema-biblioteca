package Command;

//import Sistema.IObservavel;
import Sistema.Logger;
import Sistema.Repositorio;
import Sistema.Usuario.UsuarioProfessor;

public class CommandNotificacoes implements Command {
    @Override
    public boolean run(String[] args){
        int codUsuario = Integer.parseInt(args[0]);
        Repositorio repo = Repositorio.getInstancia();

        // Conforme roteiro, não estamos verificando se o usuário é um professor.
        UsuarioProfessor usuario = (UsuarioProfessor) repo.buscaUsuarioPorCodigo(codUsuario);
        if (usuario == null) {
            return Logger.logErroObjNaoExiste("usuário", codUsuario);
        }

        Logger.logInfo("Qtd. de notificações recebidas pelo usuário `" + usuario.getNome() +"` (#" + codUsuario + "): " + usuario.getNotificacoes());
        return true;
    }
}