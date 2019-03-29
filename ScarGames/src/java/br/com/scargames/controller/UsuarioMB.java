package br.com.scargames.controller;

import br.com.scargames.domain.Usuario;
import br.com.scargames.services.UsuarioService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "usuarioMB")
@RequestScoped
public class UsuarioMB implements Serializable{
    Usuario usuario = new Usuario();
    
    public String email;
    public String senha;
    
    public UsuarioMB() {
        
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
            return null;
        }
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
}
