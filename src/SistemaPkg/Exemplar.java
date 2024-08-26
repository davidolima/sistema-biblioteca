package SistemaPkg;

public class Exemplar {
    public static int idCounter = -1;

    public int id;
    public StatusExemplar status;

    public Exemplar(){
        this.id = incrementarId();
        this.status = StatusExemplar.DISPONIVEL;
    }

    public int incrementarId(){
        Exemplar.idCounter += 1;
        return Exemplar.idCounter;
    }

    public int getId(){
        return this.id;
    }

    public StatusExemplar getStatus(){
        return this.status;
    }

    public boolean isDisponivel(){
        return (this.status == StatusExemplar.DISPONIVEL);
    }

    public boolean isReservado(){
        return (this.status == StatusExemplar.RESERVADO);
    }
}
