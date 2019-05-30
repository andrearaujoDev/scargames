package br.com.scargames.controller;

import br.com.scargames.domain.Cartao;
import br.com.scargames.services.CartaoService;
import br.com.scargames.util.UtilMessages;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "cartaoMB")
@SessionScoped
public class CartaoMB {
    
    private Cartao cartao = new Cartao();
    private List<Cartao> cartoes;
    
    
    public CartaoMB() {
        this.listar();
    }
    
    public String novo(){
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        CartaoService service = new CartaoService();
        
        if(service.inserir(cartao)){
            UtilMessages.messageInfo("Cadastrado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
           
        }else{
            return null;
        }
    }
    
    public String alterar(){
        CartaoService service = new CartaoService();
        if(service.alterar(cartao)){
            UtilMessages.messageInfo("Alterado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String excluir(Cartao cartao){
        CartaoService service = new CartaoService();
        if(service.excluir(cartao)){
            UtilMessages.messageInfo("Excluido com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    public String carregarDados(Cartao cartao){
        this.cartao = cartao;
        return "alter.xhtml?faces-redirect=true";
    }
    

    public void listar(){
        CartaoService service = new CartaoService();
        cartoes = service.listar();
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }
    
    
    
}
