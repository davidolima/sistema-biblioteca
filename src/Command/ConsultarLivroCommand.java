package Command;
import Sistema.Repositorio;
import Sistema.Livro;
import Sistema.Logger;

public class ConsultarLivroCommand implements Command {
    @Override
    public boolean run(String[] args){
        int codLivro = Integer.parseInt(args[0]);
        Repositorio repo = Repositorio.getInstancia();
        Livro livro = repo.buscaLivroPorCodigo(codLivro);
        if (livro == null) {
            Logger.logFalha("Nao existe livro de codigo `" + codLivro + "`.");
            return false;
        }
        livro.imprimirInfo();
        return true;
    }
}