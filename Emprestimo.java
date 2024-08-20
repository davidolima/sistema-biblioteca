import java.time.LocalDate;

import jdk.jshell.Snippet.Status;

public class Emprestimo {
    public Usuario usuario;
    public Livro item; // interface IEmprestavel?
    public LocalDate inicio;
    public LocalDate fim;
    public StatusEmprestimo status;

    public Emprestimo(Usuario usuario, Livro item){
        this.usuario = usuario;
        this.item = item;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getItem() {
        return item;
    }

    public int getItemId(){
        return item.getId();
    }

    public void setItem(Livro newItem) {
        this.item = newItem;
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
        this.status = StatusEmprestimo.FINALIZADO;
    }
}
