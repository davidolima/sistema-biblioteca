package Sistema;

public class Factory{
    public static Livro criarLivro(int id, String titulo, int edicao, String editora, int anoPublicacao, String autores[]){
        return new Livro(id, titulo, edicao, editora, anoPublicacao, autores);
    }
    public static Usuario criarAlunoGrad(int ID, String nome){
        return new AlunoGrad(ID, nome);
    }
}