import java.util.ArrayList;

public abstract class ObservavelBase {
    public ArrayList<ObservadorBase> observadores = new ArrayList<ObservadorBase>();

    public void adicionarObservador(ObservadorBase observador){
        this.observadores.add(observador);
    }

    public void removerObservador(ObservadorBase observador){
        this.observadores.remove(observador);
    }
}
