/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.angular.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findById", query = "SELECT g FROM Grupo g WHERE g.id = :id"),
    @NamedQuery(name = "Grupo.findByDescricao", query = "SELECT g FROM Grupo g WHERE g.descricao = :descricao")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 20)
    @Column(name = "descricao")
    private String descricao;
    @JoinTable(name = "grupo_unidade", joinColumns = {
        @JoinColumn(name = "grupo_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "unidade_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Unidade> unidadeCollection;
    @JoinTable(name = "grupo_servico", joinColumns = {
        @JoinColumn(name = "grupo_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "servico_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Servico> servicoCollection;
    @JoinColumn(name = "condominio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Condominio condominioId;
    @JoinColumn(name = "subsindico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa subsindico;

    public Grupo() {
    }

    public Grupo(Integer id) {
        this.id = id;
    }

    public Grupo(Integer id, String descricao) {
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

    @XmlTransient
    public Collection<Unidade> getUnidadeCollection() {
        return unidadeCollection;
    }

    public void setUnidadeCollection(Collection<Unidade> unidadeCollection) {
        this.unidadeCollection = unidadeCollection;
    }

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    public Condominio getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Condominio condominioId) {
        this.condominioId = condominioId;
    }

    public Pessoa getSubsindico() {
        return subsindico;
    }

    public void setSubsindico(Pessoa subsindico) {
        this.subsindico = subsindico;
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
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.Grupo[ id=" + id + " ]";
    }
    
}
