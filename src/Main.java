import Sistema.*;
//import Sistema.Usuario.*;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Sistema sistema = Sistema.getInstancia();
        Repositorio repo = Repositorio.getInstancia();

        sistema.toggleDebug();
        repo.carregarDadosDeTeste();

        try (Scanner input = new Scanner(System.in)) {
            String inputLine, comando;
            String[] argumentos;

            if (sistema.isDebugging()){
                sistema.executarComando("obs", new String[]{"100", "100"});
                sistema.executarComando("emp", new String[]{"123", "100"});
                sistema.executarComando("emp", new String[]{"456", "100"});
                sistema.executarComando("liv", new String[]{"100"});
                sistema.executarComando("usu", new String[]{"123"});
                sistema.executarComando("usu", new String[]{"456"});
                sistema.executarComando("ntf", new String[]{"100"});
            }

            Logger.logInfo("Sistema de Biblioteca");
            Logger.logInfo("Grupo: David Lima e João Soares");
            boolean running = true;
            while (running){
                System.out.print(" > ");
                inputLine = input.nextLine();
                comando = inputLine.substring(0,3);
                Logger.logDebug("Comando: " + comando);
                if (comando.equals("sai")){
                    running = false;
                    Logger.logAviso("Encerrado sistema.");
                    continue;
                }
                argumentos = inputLine.substring(4).split(" ");
                Logger.logDebug("Argumentos: ");
                for (int i = 0; sistema.isDebugging() && i < argumentos.length; i++){
                    Logger.logDebug("  "+ (i+1) + ". " + argumentos[i]);
                }
                sistema.executarComando(comando, argumentos);
            }
        }
    }
}
