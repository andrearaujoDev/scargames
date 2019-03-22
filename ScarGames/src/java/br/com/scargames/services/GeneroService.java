package br.com.scargames.services;

import br.com.scargames.dao.GeneroDao;
import br.com.scargames.domain.Genero;
import java.util.List;

public class GeneroService {
     GeneroDao GeneroDao = new GeneroDao();
    
    public List<Genero> listar(){
        return GeneroDao.lista();
    }
    
    public Genero consultar(Integer id ){
        return GeneroDao.consulta(id);
    }
    
    public Boolean inserir(Genero Genero){
        return GeneroDao.inserir(Genero);
    }
    
    public Boolean alterar(Genero Genero){
        return GeneroDao.alterar(Genero);
    }
    
    public Boolean excluir(Genero Genero){
        return GeneroDao.excluir(Genero);
    }
    
}
