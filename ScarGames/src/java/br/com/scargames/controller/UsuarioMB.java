package br.com.scargames.controller;

import br.com.scargames.domain.Usuario;
import br.com.scargames.services.UsuarioService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "usuarioMB")
@RequestScoped
public class UsuarioMB implements Serializable{
    Usuario usuario = new Usuario();
    
    private List<Usuario> usuarios;
    
    public String email;
    public String senha;
    
    public UsuarioMB() {
        this.listar();
    }
    
    public void inicializarHibernate(){
        UsuarioService service = new UsuarioService();
        service.inicializarHibernate();
    }
    
    public String autenticar(){
        UsuarioService usuarioService = new UsuarioService();
        usuario = new Usuario(email,senha);
        if(usuarioService.autenticar(usuario)){
            return "/private/index.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Dados Invalidos !");
            return null;
        }
    }
    
    public void listar(){
        UsuarioService service = new UsuarioService();
        usuarios = service.listar();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    
}
