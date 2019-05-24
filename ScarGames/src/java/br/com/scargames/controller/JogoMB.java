package br.com.scargames.controller;

import br.com.scargames.domain.Jogo;
import br.com.scargames.services.JogoService;
import br.com.scargames.util.UtilMessages;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "jogoMB")
@SessionScoped
public class JogoMB {
    
    private Jogo jogo = new Jogo();
    private List<Jogo> jogos;
    
    
    public JogoMB() {
        this.listar();
    }
    
    public String novo(){
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        JogoService service = new JogoService();
        
        if(service.inserir(jogo)){
            UtilMessages.messageInfo("Cadastrado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
           
        }else{
            return null;
        }
    }
    
    public String alterar(){
        JogoService service = new JogoService();
        if(service.alterar(jogo)){
            UtilMessages.messageInfo("Alterado com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String excluir(Jogo jogo){
        JogoService service = new JogoService();
        if(service.excluir(jogo)){
            UtilMessages.messageInfo("Excluido com sucesso !!!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    public String carregarDados(Jogo jogo){
        this.jogo = jogo;
        return "alter.xhtml?faces-redirect=true";
    }
    

    public void listar(){
        JogoService service = new JogoService();
        jogos = service.listar();
    }
    
    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

}
