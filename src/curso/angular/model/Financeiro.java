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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "financeiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financeiro.findAll", query = "SELECT f FROM Financeiro f"),
    @NamedQuery(name = "Financeiro.findById", query = "SELECT f FROM Financeiro f WHERE f.id = :id"),
    @NamedQuery(name = "Financeiro.findByDescricao", query = "SELECT f FROM Financeiro f WHERE f.descricao = :descricao")})
public class Financeiro implements Serializable {

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
    @JoinColumn(name = "condominio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Condominio condominioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "financeiroId")
    private Collection<LancamentoFinanceiro> lancamentoFinanceiroCollection;

    public Financeiro() {
    }

    public Financeiro(Integer id) {
        this.id = id;
    }

    public Financeiro(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    public Condominio getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Condominio condominioId) {
        this.condominioId = condominioId;
    }

    @XmlTransient
    public Collection<LancamentoFinanceiro> getLancamentoFinanceiroCollection() {
        return lancamentoFinanceiroCollection;
    }

    public void setLancamentoFinanceiroCollection(Collection<LancamentoFinanceiro> lancamentoFinanceiroCollection) {
        this.lancamentoFinanceiroCollection = lancamentoFinanceiroCollection;
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
        if (!(object instanceof Financeiro)) {
            return false;
        }
        Financeiro other = (Financeiro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.Financeiro[ id=" + id + " ]";
    }
    
}
