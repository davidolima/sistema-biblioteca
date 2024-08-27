package Sistema;

public class Exemplar {
    public static int idCounter = -1;

    public int exemplarId;
    public int livroId;
    public StatusExemplar status;

    public Exemplar(int livroId){
        this.exemplarId = incrementarId();
        this.livroId = livroId;
        this.status = StatusExemplar.DISPONIVEL;
    }

    public int incrementarId(){
        Exemplar.idCounter += 1;
        return Exemplar.idCounter;
    }

    public int getId(){
        return this.exemplarId;
    }

    public StatusExemplar getStatus(){
        return this.status;
    }

    public boolean isDisponivel(){
        return (this.status != StatusExemplar.EMPRESTADO && this.status != StatusExemplar.INDISPONIVEL);
    }

    public boolean isReservado(){
        return (this.status == StatusExemplar.RESERVADO);
    }

    public void reservar() {
        this.status = StatusExemplar.RESERVADO;
    }
    public void devolver() {
        this.status = StatusExemplar.DISPONIVEL;
    }
    public void pegarEmprestado(){
        this.status = StatusExemplar.EMPRESTADO;
    }

    public int getLivroId(){
        return this.livroId;
    }
    public void setLivroId(int livroId){
        this.livroId = livroId;
    }
}
