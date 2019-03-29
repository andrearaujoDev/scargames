package br.com.scargames.controller;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.services.BandeiraService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "bandeiraMB")
@ViewScoped
public class BandeiraMB {
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
    
    public String inserir(Bandeira bandeira){
        BandeiraService service = new BandeiraService();
        if(service.inserir(bandeira)){
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }

    public void listar(){
        BandeiraService service = new BandeiraService();
        bandeiras = service.listar();
    }

    public List<Bandeira> getBandeira() {
        return bandeiras;
    }

    public void setBandeira(List<Bandeira> bandeira) {
        this.bandeiras = bandeira;
    }
    

}


