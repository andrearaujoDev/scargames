package br.com.scargames.controller;

import br.com.scargames.domain.Cidade;
import br.com.scargames.services.CidadeService;
import br.com.scargames.util.UtilMessages;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cidadeMB")
@SessionScoped
public class CidadeMB {
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;
    private List<String> nomes_estado = new ArrayList<>();
    public CidadeMB() {
        this.listar();
        nomes_estado.add("RJ");
        nomes_estado.add("MG");
        nomes_estado.add("SP");
        nomes_estado.add("RS");
    }
    
    public String novo(){
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        CidadeService service = new CidadeService();
        
        if(service.inserir(cidade)){
            UtilMessages.messageInfo("Cadastrado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
           
        }else{
            return null;
        }
    }
    
    public String alterar(){
        CidadeService service = new CidadeService();
        if(service.alterar(cidade)){
            UtilMessages.messageInfo("Alterado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String excluir(Cidade cidade){
        CidadeService service = new CidadeService();
        if(service.excluir(cidade)){
            UtilMessages.messageInfo("Excluido com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    public String carregarDados(Cidade cidade){
        this.cidade = cidade;
        return "alter.xhtml?faces-redirect=true";
    }
    

    public void listar(){
        CidadeService service = new CidadeService();
        cidades = service.listar();
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public Cidade getCidade(){
        return cidade;
    }
    
    public void setCidade(Cidade cidade){
        this.cidade = cidade;
    }


    public List<String> getNomes_estado() {
        return nomes_estado;
    }

    public void setNomes_estado(List<String> nomes_estado) {
        this.nomes_estado = nomes_estado;
    }
    
    

    
    
}
