package Sistema;

import Command.*;
import java.util.HashMap;

public class Sistema {
    private static Sistema instance;
    private boolean debugging = false;
    private HashMap<String, Command> comandos = new HashMap<String, Command>();

    public Sistema() {
        this.initComandos();
    }

    private void initComandos() {
        this.comandos.put("emp", new CommandEmprestar());
        this.comandos.put("dev", new CommandDevolver());
        this.comandos.put("res", new CommandReservar());
        this.comandos.put("usu", new CommandConsultarUsuario());
        this.comandos.put("liv", new CommandConsultarLivro());
        this.comandos.put("obs", new CommandObservar());
        this.comandos.put("ntf", new CommandNotificacoes());
    }

    public void executarComando(String strCmd, String[] args) {
        Command cmd = this.comandos.get(strCmd);
        cmd.run(args);
    }

    public static Sistema getInstancia() {
        if (instance == null) { instance = new Sistema(); }
        return instance;
    }

    public void toggleDebug(){
        this.debugging = !this.debugging;
    }

    public boolean isDebugging() {
        return debugging;
    }
}
