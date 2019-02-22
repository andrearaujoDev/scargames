package br.com.scargames.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name="logradouro")
    @Size(min=1,max=100)
    private String logradouro;
    @NotNull
    @Column(name="numero")
    @Size(min=1,max=20)
    private String numero;
    @NotNull
    @Column(name="complement0")
    @Size(min=1,max=30)
    private String complemento;
    @NotNull
    @Column(name="bairro")
    @Size(min=1,max=100)
    private String bairro;
    @NotNull
    @Column(name="cep")
    @Size(min=1,max=10)
    private String cep;
    @JoinColumn(name="cidade_endereco_id",referencedColumnName="id")
    @ManyToOne(optional=false)
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, Cidade cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
    
    
}
