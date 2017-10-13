/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.angular.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "vagasdisponivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vagasdisponivel.findAll", query = "SELECT v FROM Vagasdisponivel v"),
    @NamedQuery(name = "Vagasdisponivel.findById", query = "SELECT v FROM Vagasdisponivel v WHERE v.id = :id"),
    @NamedQuery(name = "Vagasdisponivel.findByValor", query = "SELECT v FROM Vagasdisponivel v WHERE v.valor = :valor"),
    @NamedQuery(name = "Vagasdisponivel.findByQuantidade", query = "SELECT v FROM Vagasdisponivel v WHERE v.quantidade = :quantidade")})
public class Vagasdisponivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "quantidade")
    private Integer quantidade;
    @JoinColumn(name = "unidade_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unidade unidadeId;

    public Vagasdisponivel() {
    }

    public Vagasdisponivel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Unidade getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Unidade unidadeId) {
        this.unidadeId = unidadeId;
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
        if (!(object instanceof Vagasdisponivel)) {
            return false;
        }
        Vagasdisponivel other = (Vagasdisponivel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.Vagasdisponivel[ id=" + id + " ]";
    }
    
}
