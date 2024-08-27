package Sistema;

import java.util.ArrayList;

public class Repositorio {
    public static Repositorio instancia;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Livro> livros = new ArrayList<Livro>();

    public void addLivro(Livro livro) {
        Livro livroExistente = buscaLivroPorCodigo(livro.getId());
        if (livroExistente != null) {
            livroExistente.adicionarExemplar();
        } else {
            livros.add(livro);
        }
    }

    public void addUsuario(Usuario usuario) {
        Usuario usuarioExistente = buscaUsuarioPorCodigo(usuario.getId());
        if (usuarioExistente != null) {
            System.out.println("Usuario de codigo `" + usuario.getId() +"` ja existe no sistema.");
        }
        this.usuarios.add(usuario);
    }

    public Livro buscaLivroPorCodigo(int codLivro) {
        for (Livro livro : livros) {
            if (livro.getId() == codLivro) {
                return livro;
            }
        }
        return null;
    }

    public Usuario buscaUsuarioPorCodigo(int codUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == codUsuario) {
                return usuario;
            }
        }
        return null;
    }

    public static Repositorio getInstancia() {
        if (instancia == null) { instancia = new Repositorio(); }
        return instancia;
    }
}