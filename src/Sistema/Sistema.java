package Sistema;

import Command.*;
import java.util.HashMap;

public class Sistema {
    private Sistema instance;
    private HashMap<String, Command> comandos = new HashMap<String, Command>();

    public Sistema() {
        this.initComandos();
    }

    private void initComandos() {
        this.comandos.put("emp", new EmprestarCommand());
        this.comandos.put("dev", new DevolverCommand());
        this.comandos.put("res", new ReservarCommand());
        this.comandos.put("usu", new ConsultarUsuarioCommand());
        this.comandos.put("liv", new ConsultarLivroCommand());
        this.comandos.put("obs", new ObservarCommand());
        this.comandos.put("ntf", new ConsultarUsuarioCommand());
    }

    public void executarComando(String strCmd, Argumentos args) {
        Command cmd = this.comandos.get(strCmd);
        cmd.run(args);
    }

    public Sistema getInstance() {
        if (instance == null) { instance = new Sistema(); }
        return instance;
    }
}
