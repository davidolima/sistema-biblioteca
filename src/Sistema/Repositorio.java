package Sistema;

import Sistema.Usuario.UsuarioBase;

import java.util.ArrayList;

public class Repositorio {
    public static Repositorio instancia;
    private ArrayList<UsuarioBase> usuarios = new ArrayList<UsuarioBase>();
    private ArrayList<Livro> livros = new ArrayList<Livro>();

    public void addLivro(Livro livro) {
        Livro livroExistente = buscaLivroPorCodigo(livro.getId());
        if (livroExistente != null) {
            livroExistente.adicionarExemplar();
        } else {
            livros.add(livro);
        }
    }

    public void addUsuario(UsuarioBase usuario) {
        UsuarioBase usuarioExistente = buscaUsuarioPorCodigo(usuario.getId());
        if (usuarioExistente != null) {
            Logger.logAviso("Usuario de codigo `" + usuario.getId() +"` ja existe no sistema.");
            return;
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

    public UsuarioBase buscaUsuarioPorCodigo(int codUsuario) {
        for (UsuarioBase usuario : usuarios) {
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