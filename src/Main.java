import Sistema.*;

public class Main {
    public static void main(String args[]){
        Sistema sys = Sistema.getInstancia();
        Repositorio repo = Repositorio.getInstancia();

        Livro l1 = new Livro(100,"Engenharia de Software", 6, "AddisonWesley", 2000, new String[]{"Ian Sommervile"});
        l1.adicionarExemplar();
        l1.adicionarExemplar();
        repo.addLivro(l1);

        Usuario grad1 = new AlunoGrad(123, "João da Silva");
        Usuario grad2 = new AlunoGrad(789, "Pedro Paulo");

        repo.addUsuario(grad1);
        repo.addUsuario(grad2);

        sys.executarComando("liv", new String[] {"100"});
        // Livro l2 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l3 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l4 = new Livro(titulo, edicao, anoPublicacao, autores);

        // Livro l5 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l6 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l7 = new Livro(titulo, edicao, anoPublicacao, autores);
        // Livro l8 = new Livro(titulo, edicao, anoPublicacao, autores);
    }
}
