package br.com.scargames.services;

import br.com.scargames.dao.CidadeDao;
import br.com.scargames.domain.Cidade;
import java.util.List;

public class CidadeService {
     CidadeDao cidadeDao = new CidadeDao();
    
    public List<Cidade> listar(){
        return cidadeDao.lista();
    }
    
    public Cidade consultar(Integer id ){
        return cidadeDao.consulta(id);
    }
    
    public Boolean inserir(Cidade cidade){
        return cidadeDao.inserir(cidade);
    }
    
    public Boolean alterar(Cidade cidade){
        return cidadeDao.alterar(cidade);
    }
    
    public Boolean excluir(Cidade cidade){
        return cidadeDao.excluir(cidade);
    }
    
    
}
