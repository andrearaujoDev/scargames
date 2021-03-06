package br.com.scargames.services;

import br.com.scargames.dao.CartaoDao;
import br.com.scargames.domain.Cartao;
import java.util.List;

public class CartaoService {
     CartaoDao cartaoDao = new CartaoDao();
    
    public List<Cartao> listar(){
        return cartaoDao.lista();
    }
    
    public Cartao consultar(Integer id ){
        return cartaoDao.consulta(id);
    }
    
    public Boolean inserir(Cartao cartao){
        return cartaoDao.inserir(cartao);
    }
    
    public Boolean alterar(Cartao cartao){
        return cartaoDao.alterar(cartao);
    }
    
    public Boolean excluir(Cartao cartao){
        return cartaoDao.excluir(cartao);
    }

}
