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
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "terceiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terceiro.findAll", query = "SELECT t FROM Terceiro t"),
    @NamedQuery(name = "Terceiro.findById", query = "SELECT t FROM Terceiro t WHERE t.id = :id"),
    @NamedQuery(name = "Terceiro.findByNome", query = "SELECT t FROM Terceiro t WHERE t.nome = :nome"),
    @NamedQuery(name = "Terceiro.findByDescricao", query = "SELECT t FROM Terceiro t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Terceiro.findByTelefone", query = "SELECT t FROM Terceiro t WHERE t.telefone = :telefone"),
    @NamedQuery(name = "Terceiro.findByEMail", query = "SELECT t FROM Terceiro t WHERE t.eMail = :eMail"),
    @NamedQuery(name = "Terceiro.findByAprovacao", query = "SELECT t FROM Terceiro t WHERE t.aprovacao = :aprovacao")})
public class Terceiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    //@Size(max = 45)
    @Column(name = "nome")
    private String nome;
    //@Size(max = 60)
    @Column(name = "descricao")
    private String descricao;
    //@Size(max = 14)
    @Column(name = "telefone")
    private String telefone;
    //@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    //@Size(max = 20)
    @Column(name = "email")
    private String eMail;
    @Column(name = "aprovacao")
    private Boolean aprovacao;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa pessoaId;

    public Terceiro() {
    }

    public Terceiro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Boolean getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
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
        if (!(object instanceof Terceiro)) {
            return false;
        }
        Terceiro other = (Terceiro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.Terceiro[ id=" + id + " ]";
    }
    
}
