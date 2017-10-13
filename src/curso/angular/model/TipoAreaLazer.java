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
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "tipo_area_lazer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAreaLazer.findAll", query = "SELECT t FROM TipoAreaLazer t"),
    @NamedQuery(name = "TipoAreaLazer.findById", query = "SELECT t FROM TipoAreaLazer t WHERE t.id = :id"),
    @NamedQuery(name = "TipoAreaLazer.findByDescricao", query = "SELECT t FROM TipoAreaLazer t WHERE t.descricao = :descricao")})
public class TipoAreaLazer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    //@Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAreaId")
    private Collection<AreaLazer> areaLazerCollection;

    public TipoAreaLazer() {
    }

    public TipoAreaLazer(Integer id) {
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

    @XmlTransient
    public Collection<AreaLazer> getAreaLazerCollection() {
        return areaLazerCollection;
    }

    public void setAreaLazerCollection(Collection<AreaLazer> areaLazerCollection) {
        this.areaLazerCollection = areaLazerCollection;
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
        if (!(object instanceof TipoAreaLazer)) {
            return false;
        }
        TipoAreaLazer other = (TipoAreaLazer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.TipoAreaLazer[ id=" + id + " ]";
    }
    
}
