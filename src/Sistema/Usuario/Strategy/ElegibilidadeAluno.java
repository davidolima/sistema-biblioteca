package Sistema.Usuario.Strategy;
import Sistema.Livro;
import Sistema.Usuario.*;

public class ElegibilidadeAluno implements IElegibilidade {
    public boolean isElegivelEmprestimo(Livro livro, UsuarioBase user){ //1 checado na chamada
        boolean naoEstaDevendo = !user.isDevedor(); //2
        boolean limEmprestimoNaoExcedido = (user.emprestimos.size() < user.maxEmprestimosEmAberto); //3
        boolean nTemExemplarAinda = (user.buscarEmprestimoPorCodigoLivro(livro.getId()) == null); //6
        boolean temReservaOuDisponivel = (livro.estaReservando(user) || livro.menosReservasQueExemplares()); //4, 5
        return naoEstaDevendo && limEmprestimoNaoExcedido && nTemExemplarAinda && temReservaOuDisponivel && (livro != null);
    }
}
