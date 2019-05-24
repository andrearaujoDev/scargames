package br.com.scargames.controller;

import br.com.scargames.dao.GeneroDao;
import br.com.scargames.domain.Genero;
import br.com.scargames.domain.Jogo;
import br.com.scargames.domain.Produtora;
import br.com.scargames.services.GeneroService;
import br.com.scargames.services.JogoService;
import br.com.scargames.services.ProdutoraService;
import br.com.scargames.util.UtilMessages;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "jogoMB")
@SessionScoped
public class JogoMB {
    
    private Jogo jogo = new Jogo();
    private List<Jogo> jogos;
    private List<Integer> classificacao = new ArrayList<>();
    
    
    GeneroService generoService = new GeneroService();
    ProdutoraService produtoraService = new ProdutoraService();
    
    private String generoSelecionado;
    private String produtoraSelecionada;
    
    private int id_genero = 0;
    private int id_produtora = 0;
    
    private List<String> listagenero = new ArrayList<>();
    private List<String> listaprodutora = new ArrayList<>();
    
    Genero genero = new Genero();
    Produtora produtora = new Produtora();
    
    public JogoMB() {
        this.listar();
        classificacao.add(12);
        classificacao.add(14);
        classificacao.add(16);
        classificacao.add(18);
    }
    
    public String novo(){
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        JogoService service = new JogoService();
        
        //Pegando ID de genero
        for(Genero g : generoService.listar()){
            if(generoSelecionado.equals(g.getDescricao())){
                id_genero = g.getId();
            }
        }
        //Pegando ID de produtora
        for(Produtora p : produtoraService.listar()){
            if(produtoraSelecionada.equals(p.getNome())){
                id_produtora = p.getId();
            }
        }
        
        genero = new Genero();
        produtora = new Produtora();
        
        genero.setId(id_genero);
        produtora.setId(id_produtora);
        
        jogo.setGenero(genero);
        jogo.setProdutora(produtora);
        
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
        
        //Listar Genero no SelectOneMenu
        for(Genero g : generoService.listar()){
            listagenero.add(g.getDescricao());
        }
        //Listar Produtora no SelectOneMenu
        for(Produtora p : produtoraService.listar()){
            listaprodutora.add(p.getNome());
        }
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

    public List<Integer> getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(List<Integer> classificacao) {
        this.classificacao = classificacao;
    }

    public List<String> getListagenero() {
        return listagenero;
    }

    public void setListagenero(List<String> listagenero) {
        this.listagenero = listagenero;
    }

    public List<String> getListaprodutora() {
        return listaprodutora;
    }

    public void setListaprodutora(List<String> listaprodutora) {
        this.listaprodutora = listaprodutora;
    }

    public String getGeneroSelecionado() {
        return generoSelecionado;
    }

    public void setGeneroSelecionado(String generoSelecionado) {
        this.generoSelecionado = generoSelecionado;
    }

    public String getProdutoraSelecionada() {
        return produtoraSelecionada;
    }

    public void setProdutoraSelecionada(String produtoraSelecionada) {
        this.produtoraSelecionada = produtoraSelecionada;
    }
    
    

}
