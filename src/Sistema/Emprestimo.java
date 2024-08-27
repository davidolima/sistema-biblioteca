package Sistema;

import Sistema.Usuario.UsuarioBase;

import java.time.LocalDate;

public class Emprestimo {
    public UsuarioBase usuario;
    public Exemplar exemplar; // interface IEmprestavel?
    public LocalDate inicio;
    public LocalDate fim;
    public StatusEmprestimo status;

    public Emprestimo(UsuarioBase usuario, Exemplar exemplar){
        this.usuario = usuario;
        this.exemplar = exemplar;

        exemplar.pegarEmprestado();

        this.inicio = LocalDate.now();
        this.fim = inicio.plusDays(usuario.getTempoEmprestimoDias());
        this.status = StatusEmprestimo.ABERTO;
    }

    public boolean isAtrasado(){
        if (this.status == StatusEmprestimo.ABERTO && this.fim.isBefore(LocalDate.now())){
            return true;
        }
        return false;
    }

    public UsuarioBase getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public int getLivroId(){
        return exemplar.getLivroId();
    }

    public void setExemplar(Exemplar newExemplar) {
        this.exemplar = newExemplar;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void finalizar() {
        this.exemplar.devolver();
        this.status = StatusEmprestimo.FINALIZADO;
    }
}
