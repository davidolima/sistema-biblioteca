package Sistema;

public class Exemplar {
    public static int idCounter = -1;

    public int exemplarId;
    public int livroId;
    public StatusExemplar status;
    public Emprestimo emprestimo = null;

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
        return (getStatus() != StatusExemplar.EMPRESTADO);
    }

    public void registrarEmprestimo(Emprestimo emp) {
        this.emprestimo = emp;
    }

    public void devolver() {
        this.emprestimo = null;
        this.status = StatusExemplar.DISPONIVEL;
    }
    public void pegarEmprestado(){
        this.status = StatusExemplar.EMPRESTADO;
    }

    public String toString(){
        if (this.emprestimo != null){
            return "Exemplar #" + getId() + " - " + "Em empréstimo (" + this.emprestimo.getUsuario().getNome() +
            ") - Inicio: " + this.emprestimo.getInicio() + " Fim: " + this.emprestimo.getFim(); 
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
