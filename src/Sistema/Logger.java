package Sistema;

public class Logger { //TODO: Mover falhas repetidas para métodos do logger.
    public static boolean logFalha(String message){
        System.out.println("[FALHA] " + message);
        return false;
    }
    public static void logAviso(String message){
        System.out.println("[!] " + message);
    }
    public static boolean logSucesso(String message){
        System.out.println("[SUCESSO] " + message);
        return true;
    }
    public static void logInfo(String message){
        System.out.println("[INFO] " + message);
    }
    public static void logErroFatal(String message){
        System.err.println("[ERRO FATAL] " + message);
        System.exit(1);
    }
    public static void logDebug(String message){
        if (Sistema.getInstancia().isDebugging()){
            System.out.println("[DEBUG] " + message);
        }
    }
    public static boolean logErroObjNaoExiste(String strObj, int codObjeto) {
        return Logger.logFalha("Nao existe " + strObj + " de codigo `" + codObjeto + "`.");
    }
}
