package Sistema;

import java.util.ArrayList;
import Sistema.Usuario.*;

public class Repositorio {
    public static Repositorio instancia;
    private ArrayList<UsuarioBase> usuarios = new ArrayList<UsuarioBase>();
    private ArrayList<Livro> livros = new ArrayList<Livro>();

    public void carregarDadosDeTeste(){
        // Cadastrar livros
        Livro l100 = new Livro(100,"Engenharia de Software", 6, "AddisonWesley", 2000, new String[]{"Ian Sommervile"});
        Livro l101 = new Livro(101, "UML - Guia do Usuário", 7, "Campus", 2000, new String[]{"Grady Booch", "James Rumbaugh", "Ivar Jacobson"});
        Livro l200 = new Livro(200, "Code Complete", 2, "Microsoft Press", 2014, new String[]{"Steve McConnell"});
        Livro l201 = new Livro(201, "Agile Software Development Principles, Patterns and Practices", 1 , "Prentice Hall",2002, new String[]{"Robert Martin"});
        Livro l300 = new Livro(300, "Refactoring: Improving the Design of Existing Code", 1, "Addison-Wesley Professional", 1999, new String[]{"Martin Fowler"});
        Livro l301 = new Livro(301, "Software Metrics: A Rigorous and Pratical Approach", 3, "CRC Press", 2014, new String[]{"Norman Fenton", "James Biemann"});
        Livro l400 = new Livro(400,"Design Patterns: Elements of Reusable Object-Oriented Software", 1, "Addison-Wesley Professional", 1994, new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"});
        Livro l401 = new Livro(401,"UML Distilled: A Brief Guide to the Standard Object Modeling Language", 3, "Addison-Wesley Professional", 2003, new String[]{"Martin Fowler"});

        // Adicionar exemplares
        addLivro(l100);
        addLivro(l100);
        addLivro(l101);
        addLivro(l200);
        addLivro(l201);
        addLivro(l300);
        addLivro(l300);
        addLivro(l400);
        addLivro(l400);

        // Cadastrar usuarios
        addUsuario(new UsuarioAlunoGrad(123, "João da Silva"));
        addUsuario(new UsuarioAlunoPos(456, "Luiz Fernando Rodrigues"));
        addUsuario(new UsuarioAlunoGrad(789, "Pedro Paulo"));
        addUsuario(new UsuarioProfessor(100, "Carlos Lucena"));
    }

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