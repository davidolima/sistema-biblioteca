package Command;

import Sistema.IObservavel;
import Sistema.Logger;
import Sistema.Repositorio;
import Sistema.Usuario.UsuarioProfessor;

public class CommandNotificacoes implements Command {
    @Override
    public boolean run(String[] args){
        int idUsuario = Integer.parseInt(args[0]);
        Repositorio repo = Repositorio.getInstancia();

        // Conforme roteiro, não estamos verificando se o usuário é um professor.
        UsuarioProfessor usuario = (UsuarioProfessor) repo.buscaUsuarioPorCodigo(idUsuario);
        if (usuario == null) {
            Logger.logFalha("Nao existe usuario de codigo `" + idUsuario + "`");
            return false;
        }

        Logger.logInfo("Qtd. de notificações recebidas pelo usuário `" + usuario.getNome() +"` (#" + idUsuario + "): " + usuario.getNotificacoes());
        return true;
    }
}