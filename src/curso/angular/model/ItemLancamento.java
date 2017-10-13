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
@Table(name = "item_lancamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemLancamento.findAll", query = "SELECT i FROM ItemLancamento i"),
    @NamedQuery(name = "ItemLancamento.findById", query = "SELECT i FROM ItemLancamento i WHERE i.id = :id"),
    @NamedQuery(name = "ItemLancamento.findByDescricao", query = "SELECT i FROM ItemLancamento i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "ItemLancamento.findByValorUnit", query = "SELECT i FROM ItemLancamento i WHERE i.valorUnit = :valorUnit"),
    @NamedQuery(name = "ItemLancamento.findByQuantidade", query = "SELECT i FROM ItemLancamento i WHERE i.quantidade = :quantidade")})
public class ItemLancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "id")
    private Integer id;
    //@Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unit")
    private Float valorUnit;
    @Column(name = "quantidade")
    private Float quantidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemlancamentoid")
    private Collection<Lancamento> lancamentoCollection;

    public ItemLancamento() {
    }

    public ItemLancamento(Integer id) {
        this.id = id;
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

    public Float getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Float valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
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
        if (!(object instanceof ItemLancamento)) {
            return false;
        }
        ItemLancamento other = (ItemLancamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.ItemLancamento[ id=" + id + " ]";
    }
    
}
