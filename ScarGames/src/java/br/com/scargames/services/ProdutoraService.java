package br.com.scargames.services;

import br.com.scargames.dao.ProdutoraDao;
import br.com.scargames.domain.Produtora;

import java.util.List;

public class ProdutoraService {
     ProdutoraDao produtoraDao = new ProdutoraDao();
    
    public List<Produtora> listar(){
        return produtoraDao.lista();
    }
    
    public Produtora consultar(Integer id ){
        return produtoraDao.consulta(id);
    }
    
    public Boolean inserir(Produtora produtora){
        return produtoraDao.inserir(produtora);
    }
    
    public Boolean alterar(Produtora produtora){
        return produtoraDao.alterar(produtora);
    }
    
    public Boolean excluir(Produtora produtora){
        return produtoraDao.excluir(produtora);
    }
    
}
