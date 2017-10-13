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
@Table(name = "lancamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lancamento.findAll", query = "SELECT l FROM Lancamento l"),
    @NamedQuery(name = "Lancamento.findById", query = "SELECT l FROM Lancamento l WHERE l.id = :id"),
    @NamedQuery(name = "Lancamento.findByDescricao", query = "SELECT l FROM Lancamento l WHERE l.descricao = :descricao"),
    @NamedQuery(name = "Lancamento.findByValortotal", query = "SELECT l FROM Lancamento l WHERE l.valortotal = :valortotal")})
public class Lancamento implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valortotal")
    private Float valortotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lancamentoId")
    private Collection<LancamentoFinanceiro> lancamentoFinanceiroCollection;
    @JoinColumn(name = "Item_lancamento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemLancamento itemlancamentoid;
    @JoinColumn(name = "tipo_lancamento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoLancamento tipoLancamentoId;

    public Lancamento() {
    }

    public Lancamento(Integer id) {
        this.id = id;
    }

    public Lancamento(Integer id, String descricao) {
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

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    @XmlTransient
    public Collection<LancamentoFinanceiro> getLancamentoFinanceiroCollection() {
        return lancamentoFinanceiroCollection;
    }

    public void setLancamentoFinanceiroCollection(Collection<LancamentoFinanceiro> lancamentoFinanceiroCollection) {
        this.lancamentoFinanceiroCollection = lancamentoFinanceiroCollection;
    }

    public ItemLancamento getItemlancamentoid() {
        return itemlancamentoid;
    }

    public void setItemlancamentoid(ItemLancamento itemlancamentoid) {
        this.itemlancamentoid = itemlancamentoid;
    }

    public TipoLancamento getTipoLancamentoId() {
        return tipoLancamentoId;
    }

    public void setTipoLancamentoId(TipoLancamento tipoLancamentoId) {
        this.tipoLancamentoId = tipoLancamentoId;
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
        if (!(object instanceof Lancamento)) {
            return false;
        }
        Lancamento other = (Lancamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.Lancamento[ id=" + id + " ]";
    }
    
}
