package Sistema.Usuario.Strategy;
import Sistema.Livro;
import Sistema.Usuario.*;

public interface IElegibilidade {
    boolean isElegivelEmprestimo(Livro livro, UsuarioBase user);
}
