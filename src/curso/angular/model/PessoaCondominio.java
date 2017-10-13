/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.angular.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "pessoa_condominio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaCondominio.findAll", query = "SELECT p FROM PessoaCondominio p"),
    @NamedQuery(name = "PessoaCondominio.findByPessoaId", query = "SELECT p FROM PessoaCondominio p WHERE p.pessoaCondominioPK.pessoaId = :pessoaId"),
    @NamedQuery(name = "PessoaCondominio.findByCondominioId", query = "SELECT p FROM PessoaCondominio p WHERE p.pessoaCondominioPK.condominioId = :condominioId"),
    @NamedQuery(name = "PessoaCondominio.findByDataInicio", query = "SELECT p FROM PessoaCondominio p WHERE p.dataInicio = :dataInicio"),
    @NamedQuery(name = "PessoaCondominio.findByDataFim", query = "SELECT p FROM PessoaCondominio p WHERE p.dataFim = :dataFim")})
public class PessoaCondominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PessoaCondominioPK pessoaCondominioPK;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @JoinColumn(name = "condominio_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Condominio condominio;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public PessoaCondominio() {
    }

    public PessoaCondominio(PessoaCondominioPK pessoaCondominioPK) {
        this.pessoaCondominioPK = pessoaCondominioPK;
    }

    public PessoaCondominio(int pessoaId, int condominioId) {
        this.pessoaCondominioPK = new PessoaCondominioPK(pessoaId, condominioId);
    }

    public PessoaCondominioPK getPessoaCondominioPK() {
        return pessoaCondominioPK;
    }

    public void setPessoaCondominioPK(PessoaCondominioPK pessoaCondominioPK) {
        this.pessoaCondominioPK = pessoaCondominioPK;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaCondominioPK != null ? pessoaCondominioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaCondominio)) {
            return false;
        }
        PessoaCondominio other = (PessoaCondominio) object;
        if ((this.pessoaCondominioPK == null && other.pessoaCondominioPK != null) || (this.pessoaCondominioPK != null && !this.pessoaCondominioPK.equals(other.pessoaCondominioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.PessoaCondominio[ pessoaCondominioPK=" + pessoaCondominioPK + " ]";
    }
    
}
