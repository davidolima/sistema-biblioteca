package Sistema;

public class Logger {
    public static void logFalha(String message){
        System.out.println("[FALHA] " + message);
    }
    public static void logAviso(String message){
        System.out.println("[AVISO] " + message);
    }
    public static void logSucesso(String message){
        System.out.println("[SUCESSO] " + message);
    }
    public static void logInfo(String message){
        System.out.println("[INFO] " + message);
    }
    public static void logErroFatal(String message){
        System.err.println("[ERRO FATAL] " + message);
        System.exit(1);
    }
}
