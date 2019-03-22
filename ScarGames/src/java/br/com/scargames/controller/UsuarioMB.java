package br.com.scargames.controller;

import br.com.scargames.domain.Usuario;
import br.com.scargames.services.UsuarioService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "usuarioMB")
@RequestScoped
public class UsuarioMB implements Serializable{
    
    private Usuario usuario;
    
    public UsuarioMB() {
        
    }
    
    public String autenticar(){
        UsuarioService usuarioService = new UsuarioService();
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
    
    
    
}
