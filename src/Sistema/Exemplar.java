package Sistema;

public class Exemplar {
    public static int idCounter = -1;

    public int exemplarId;
    public int livroId;
    public StatusExemplar status;

    public Exemplar(int livroId){
        this.exemplarId = incrementarId();
        this.livroId = livroId;
        this.status = StatusExemplar.DISPONIVEL; // TODO: Mudar para parâmetro que guarda quem pegou emprestado
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
        return (getStatus() != StatusExemplar.EMPRESTADO);
    }

    public void devolver() {
        this.status = StatusExemplar.DISPONIVEL;
    }
    public void pegarEmprestado(){
        this.status = StatusExemplar.EMPRESTADO;
    }

    public String toString(){
        if (getStatus() == StatusExemplar.EMPRESTADO){
            return "Exemplar #" + getId() + " - " + "Em empréstimo (UsuarioQuePegouEmprestado) - Inicio: <inicio> Fim: <fim>"; // Fixme
        }
        return "Exemplar #" + getId() + " - " + getStatus();
    }

    public int getLivroId(){
        return this.livroId;
    }
    public void setLivroId(int livroId){
        this.livroId = livroId;
    }
}
