package Sistema;
import java.time.LocalDate;

public class Reserva {
    public LocalDate data = LocalDate.now();
    public Livro livro;
    public StatusReserva status = StatusReserva.EM_CURSO;

    public Reserva(Livro livro){
        this.livro = livro;
    }

    public LocalDate getData() {return this.data;}
    public Livro getLivro() {return this.livro;}
    public StatusReserva getStatus() {return this.status;}
    public void finalizar() {this.status = StatusReserva.FINALIZADO;}
    public String toString() {
        return getLivro().getTitulo() + " : " + getData() + " - " + getStatus();
    }
}
