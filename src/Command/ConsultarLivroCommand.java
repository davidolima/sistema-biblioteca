package Command;
import Sistema.Repositorio;
import Sistema.Livro;

public class ConsultarLivroCommand implements Command {
    @Override
    public String run(Argumentos args){
        int codLivro = Integer.parseInt(args.getArgumentos()[0]);
        Repositorio repo = Repositorio.getInstancia();
        Livro livro = repo.buscaLivroPorCodigo(codLivro);
        if (livro == null) {
            return "Livro de codigo `" + codLivro + "` nao encontrado"; //TODO: Unificar mensagens numa classe `Logger`
        }
        return livro.toString();
    }
}