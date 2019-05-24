package br.com.scargames.controller;

import br.com.scargames.domain.Produtora;
import br.com.scargames.services.ProdutoraService;
import br.com.scargames.util.UtilMessages;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean(name = "produtoraMB")
@SessionScoped
public class ProdutoraMB {
    
    private Produtora produtora = new Produtora();
    private List<Produtora> produtoras;
    public ProdutoraMB() {
        this.listar();
    }
    
    public String novo(){
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        ProdutoraService service = new ProdutoraService();
        if(service.inserir(produtora)){
            UtilMessages.messageInfo("Cadastrado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
           
        }else{
            return null;
        }
    }
    
    public String alterar(){
        ProdutoraService service = new ProdutoraService();
        if(service.alterar(produtora)){
            UtilMessages.messageInfo("Alterado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String excluir(Produtora produtora){
        ProdutoraService service = new ProdutoraService();
        if(service.excluir(produtora)){
            UtilMessages.messageInfo("Excluido com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    public String carregarDados(Produtora produtora){
        this.produtora = produtora;
        return "alter.xhtml?faces-redirect=true";
    }
    

    public void listar(){
        ProdutoraService service = new ProdutoraService();
        produtoras = service.listar();
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    public List<Produtora> getProdutoras() {
        return produtoras;
    }

    public void setProdutoras(List<Produtora> produtoras) {
        this.produtoras = produtoras;
    }
    
    
    
}
