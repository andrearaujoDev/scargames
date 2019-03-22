package br.com.scargames.services;

import br.com.scargames.dao.JogoDao;
import br.com.scargames.domain.Jogo;

import java.util.List;

public class JogoService {
     JogoDao jogoDao = new JogoDao();
    
    public List<Jogo> listar(){
        return jogoDao.lista();
    }
    
    public Jogo consultar(Integer id ){
        return jogoDao.consulta(id);
    }
    
    public Boolean inserir(Jogo jogo){
        return jogoDao.inserir(jogo);
    }
    
    public Boolean alterar(Jogo jogo){
        return jogoDao.alterar(jogo);
    }
    
    public Boolean excluir(Jogo jogo){
        return jogoDao.excluir(jogo);
    }
    
}
