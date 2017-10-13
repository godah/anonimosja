/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.angular.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "tipo_lancamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLancamento.findAll", query = "SELECT t FROM TipoLancamento t"),
    @NamedQuery(name = "TipoLancamento.findById", query = "SELECT t FROM TipoLancamento t WHERE t.id = :id"),
    @NamedQuery(name = "TipoLancamento.findByDescricao", query = "SELECT t FROM TipoLancamento t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TipoLancamento.findBySigla", query = "SELECT t FROM TipoLancamento t WHERE t.sigla = :sigla")})
public class TipoLancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "sigla")
    private String sigla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoLancamentoId")
    private Collection<Lancamento> lancamentoCollection;

    public TipoLancamento() {
    }

    public TipoLancamento(Integer id) {
        this.id = id;
    }

    public TipoLancamento(Integer id, String descricao, String sigla) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @XmlTransient
    public Collection<Lancamento> getLancamentoCollection() {
        return lancamentoCollection;
    }

    public void setLancamentoCollection(Collection<Lancamento> lancamentoCollection) {
        this.lancamentoCollection = lancamentoCollection;
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
        if (!(object instanceof TipoLancamento)) {
            return false;
        }
        TipoLancamento other = (TipoLancamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.TipoLancamento[ id=" + id + " ]";
    }
    
}
