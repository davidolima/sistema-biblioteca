package Sistema.Usuario;
import Sistema.IObservador;
import Sistema.IObservavel;
import Sistema.Usuario.Strategy.ElegibilidadeProfessor;
import java.util.ArrayList;

public class UsuarioProfessor extends UsuarioBase implements IObservador {
    public ArrayList<IObservavel> livrosObservados = new ArrayList<IObservavel>();
    public int notificacoes = 0;

    public UsuarioProfessor(int Id, String nome){
        this.Id = Id;
        this.nome = nome;
        this.maxTempoEmprestimoDias = 3;
        this.maxEmprestimosEmAberto = 3;
        this.elegibilidade = new ElegibilidadeProfessor();
    }


    public int getNotificacoes() {
        return notificacoes;
    }

    public void atualizar() {
        this.notificacoes++;
    }
}
