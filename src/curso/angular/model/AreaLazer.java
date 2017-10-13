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
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "area_lazer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaLazer.findAll", query = "SELECT a FROM AreaLazer a"),
    @NamedQuery(name = "AreaLazer.findById", query = "SELECT a FROM AreaLazer a WHERE a.id = :id"),
    @NamedQuery(name = "AreaLazer.findByDescricao", query = "SELECT a FROM AreaLazer a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "AreaLazer.findByArea", query = "SELECT a FROM AreaLazer a WHERE a.area = :area")})
public class AreaLazer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    //@Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    //@Size(max = 20)
    @Column(name = "area")
    private String area;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaDeLazerId")
    private Collection<AgendamentoLazer> agendamentoLazerCollection;
    @JoinColumn(name = "tipo_area_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoAreaLazer tipoAreaId;

    public AreaLazer() {
    }

    public AreaLazer(Integer id) {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlTransient
    public Collection<AgendamentoLazer> getAgendamentoLazerCollection() {
        return agendamentoLazerCollection;
    }

    public void setAgendamentoLazerCollection(Collection<AgendamentoLazer> agendamentoLazerCollection) {
        this.agendamentoLazerCollection = agendamentoLazerCollection;
    }

    public TipoAreaLazer getTipoAreaId() {
        return tipoAreaId;
    }

    public void setTipoAreaId(TipoAreaLazer tipoAreaId) {
        this.tipoAreaId = tipoAreaId;
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
        if (!(object instanceof AreaLazer)) {
            return false;
        }
        AreaLazer other = (AreaLazer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.AreaLazer[ id=" + id + " ]";
    }
    
}
