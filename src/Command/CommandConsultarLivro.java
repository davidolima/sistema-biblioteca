package Command;
import Sistema.Repositorio;
import Sistema.Livro;
import Sistema.Logger;

public class CommandConsultarLivro implements Command {
    @Override
    public boolean run(String[] args){
        int codLivro = Integer.parseInt(args[0]);
        Repositorio repo = Repositorio.getInstancia();
        Livro livro = repo.buscaLivroPorCodigo(codLivro);
        if (livro == null) {
            return Logger.logErroObjNaoExiste("livro", codLivro);
        }
        livro.imprimirInfo();
        return true;
    }
}