import Sistema.*;
import Sistema.Usuario.UsuarioBase;
import Sistema.Usuario.UsuarioBase.AlunoGrad;

public class Main {
    public static void main(String args[]){
        Sistema sys = Sistema.getInstancia();
        Repositorio repo = Repositorio.getInstancia();

        Livro l1 = new Livro(100,"Engenharia de Software", 6, "AddisonWesley", 2000, new String[]{"Ian Sommervile"});
        repo.addLivro(l1);
        repo.addLivro(l1);

        UsuarioBase grad1 = new AlunoGrad(123, "João da Silva");
        UsuarioBase grad2 = new AlunoGrad(789, "Pedro Paulo");

        repo.addUsuario(grad1);
        repo.addUsuario(grad2);

        sys.executarComando("liv", new String[] {"100"});
    }
}
