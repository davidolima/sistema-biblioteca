package Sistema.Usuario.Strategy;
import Sistema.Livro;
import Sistema.Usuario.*;

public class ElegibilidadeProfessor implements IElegibilidade{
    public boolean isElegivelEmprestimo(Livro livro, UsuarioBase user){
        return !user.isDevedor() && (livro != null);
    }
}
