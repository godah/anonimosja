/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonimosja.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author luciano
 */
@Entity
public class Referencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String nome;
	private String tel;
	private String email;
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "idServicofeito")
    private ServicoFeito servicoFeito = new ServicoFeito();
    

	public Referencia() {
    }

    public Referencia(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ServicoFeito getServicoFeito() {
		return servicoFeito;
	}

	public void setServicoFeito(ServicoFeito servicoFeito) {
		this.servicoFeito = servicoFeito;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencia)) {
            return false;
        }
        Referencia other = (Referencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.anonimosja.model.Pessoa[ id=" + id + " ]";
    }
    
}
