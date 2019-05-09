package br.com.scargames.controller;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.services.BandeiraService;
import br.com.scargames.util.UtilMessages;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "bandeiraMB")
@SessionScoped
public class BandeiraMB {
    private Bandeira bandeira = new Bandeira();
    private List<Bandeira> bandeiras;
    public BandeiraMB() {
        this.listar();
    }
    
    public String novo(){
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        BandeiraService service = new BandeiraService();
        if(service.inserir(bandeira)){
            UtilMessages.messageInfo("Cadastrado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
           
        }else{
            return null;
        }
    }
    
    public String alterar(){
        BandeiraService service = new BandeiraService();
        if(service.alterar(bandeira)){
            UtilMessages.messageInfo("Alterado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String excluir(Bandeira bandeira){
        BandeiraService service = new BandeiraService();
        if(service.excluir(bandeira)){
            UtilMessages.messageInfo("Excluido com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    public String carregarDados(Bandeira bandeira){
        this.bandeira = bandeira;
        return "alter.xhtml?faces-redirect=true";
    }
    

    public void listar(){
        BandeiraService service = new BandeiraService();
        bandeiras = service.listar();
    }

    public List<Bandeira> getBandeiras() {
        return bandeiras;
    }

    public void setBandeiras(List<Bandeira> bandeiras) {
        this.bandeiras = bandeiras;
    }
    
    public Bandeira getBandeira(){
        return bandeira;
    }
    
    public void setBandeira(Bandeira bandeira){
        this.bandeira = bandeira;
    }
       

}


