package Sistema.Usuario.Strategy;
import Sistema.Livro;
import Sistema.Logger;
import Sistema.Usuario.*;

public class ElegibilidadeProfessor implements IElegibilidade{
    public boolean isElegivelEmprestimo(Livro livro, UsuarioBase user){
        assert livro != null;
        if (!user.isDevedor()){
            return Logger.logFalha("Usuário `" + user.getNome() + "` #" + user.getId() + " é devedor.");
        }
        return true;
    }
}
