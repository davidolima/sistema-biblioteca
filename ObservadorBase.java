import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ObservadorBase {
    public ArrayList<LocalDate> notificacoes;

    public void atualizar(LocalDate notificacao){
        this.notificacoes.add(notificacao);
    }
}
