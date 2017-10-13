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
import javax.persistence.ManyToMany;
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
@Table(name = "unidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u"),
    @NamedQuery(name = "Unidade.findById", query = "SELECT u FROM Unidade u WHERE u.id = :id"),
    @NamedQuery(name = "Unidade.findByDescricao", query = "SELECT u FROM Unidade u WHERE u.descricao = :descricao")})
public class Unidade implements Serializable {

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
    @ManyToMany(mappedBy = "unidadeCollection")
    private Collection<Grupo> grupoCollection;
    @JoinColumn(name = "pessoa_id_responsavel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa pessoaIdResponsavel;
    @JoinColumn(name = "pessoa_id_proprietario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa pessoaIdProprietario;
    @JoinColumn(name = "tipo_unidade_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoUnidade tipoUnidadeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeId")
    private Collection<Vagasdisponivel> vagasdisponivelCollection;

    public Unidade() {
    }

    public Unidade(Integer id) {
        this.id = id;
    }

    public Unidade(Integer id, String descricao) {
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
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    public Pessoa getPessoaIdResponsavel() {
        return pessoaIdResponsavel;
    }

    public void setPessoaIdResponsavel(Pessoa pessoaIdResponsavel) {
        this.pessoaIdResponsavel = pessoaIdResponsavel;
    }

    public Pessoa getPessoaIdProprietario() {
        return pessoaIdProprietario;
    }

    public void setPessoaIdProprietario(Pessoa pessoaIdProprietario) {
        this.pessoaIdProprietario = pessoaIdProprietario;
    }

    public TipoUnidade getTipoUnidadeId() {
        return tipoUnidadeId;
    }

    public void setTipoUnidadeId(TipoUnidade tipoUnidadeId) {
        this.tipoUnidadeId = tipoUnidadeId;
    }

    @XmlTransient
    public Collection<Vagasdisponivel> getVagasdisponivelCollection() {
        return vagasdisponivelCollection;
    }

    public void setVagasdisponivelCollection(Collection<Vagasdisponivel> vagasdisponivelCollection) {
        this.vagasdisponivelCollection = vagasdisponivelCollection;
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
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.Unidade[ id=" + id + " ]";
    }
    
}
