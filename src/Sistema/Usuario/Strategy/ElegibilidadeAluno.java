package Sistema.Usuario.Strategy;
import Sistema.Livro;
import Sistema.Logger;
import Sistema.Usuario.*;

public class ElegibilidadeAluno implements IElegibilidade {
    public boolean isElegivelEmprestimo(Livro livro, UsuarioBase user){ //1 checado na chamada
        assert livro != null;

        boolean naoEstaDevendo = !user.isDevedor(); //2
        boolean limEmprestimoNaoExcedido = (user.emprestimos.size() < user.getMaxEmprestimosEmAberto()); //3
        boolean nTemExemplarAinda = (user.buscarEmprestimoPorCodigoLivro(livro.getId()) == null); //6
        boolean temReserva = livro.estaReservando(user);
        boolean livroEstaDisp = livro.menosReservasQueExemplares(); //4, 5

        if (!naoEstaDevendo) {
            return Logger.logErroUsuarioNaoElegivel(user,"Usuário é devedor.");
        }
        if (!limEmprestimoNaoExcedido) {
            return Logger.logErroUsuarioNaoElegivel(user, "Usuário atingiu o limite de empréstimo máximo (" + user.getMaxEmprestimosEmAberto() + ")");
        }
        if (!nTemExemplarAinda) {
            return Logger.logErroUsuarioNaoElegivel(user, "Usuário já apresenta empréstimo de exemplar deste livro.");
        }
        if(!livroEstaDisp && !temReserva){
            return Logger.logErroUsuarioNaoElegivel(user, "Não existem exemplares disponíveis deste livro.");
        }
        return true;
    }
}
