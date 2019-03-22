package br.com.scargames.services;

import br.com.scargames.dao.EnderecoDao;
import br.com.scargames.domain.Endereco;

import java.util.List;

public class EnderecoService {
     EnderecoDao enderecoDao = new EnderecoDao();
    
    public List<Endereco> listar(){
        return enderecoDao.lista();
    }
    
    public Endereco consultar(Integer id ){
        return enderecoDao.consulta(id);
    }
    
    public Boolean inserir(Endereco endereco){
        return enderecoDao.inserir(endereco);
    }
    
    public Boolean alterar(Endereco endereco){
        return enderecoDao.alterar(endereco);
    }
    
    public Boolean excluir(Endereco endereco){
        return enderecoDao.excluir(endereco);
    }
    
}
