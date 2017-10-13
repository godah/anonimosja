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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "condominio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condominio.findAll", query = "SELECT c FROM Condominio c"),
    @NamedQuery(name = "Condominio.findById", query = "SELECT c FROM Condominio c WHERE c.id = :id"),
    @NamedQuery(name = "Condominio.findByNome", query = "SELECT c FROM Condominio c WHERE c.nome = :nome"),
    @NamedQuery(name = "Condominio.findByLogradouro", query = "SELECT c FROM Condominio c WHERE c.logradouro = :logradouro"),
    @NamedQuery(name = "Condominio.findByBairro", query = "SELECT c FROM Condominio c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "Condominio.findByCidade", query = "SELECT c FROM Condominio c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "Condominio.findByNumero", query = "SELECT c FROM Condominio c WHERE c.numero = :numero"),
    @NamedQuery(name = "Condominio.findByCep", query = "SELECT c FROM Condominio c WHERE c.cep = :cep"),
    @NamedQuery(name = "Condominio.findByComplemento", query = "SELECT c FROM Condominio c WHERE c.complemento = :complemento")})
public class Condominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 60)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 30)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "numero")
    private String numero;
    //@Size(max = 10)
    @Column(name = "cep")
    private String cep;
    //@Size(max = 45)
    @Column(name = "complemento")
    private String complemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominioId")
    private Collection<Financeiro> financeiroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominioId")
    private Collection<Mensagem> mensagemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominioId")
    private Collection<Grupo> grupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio")
    private Collection<PessoaCondominio> pessoaCondominioCollection;
    @JoinColumn(name = "sindico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa sindico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominioId")
    private Collection<Notificacao> notificacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominioId")
    private Collection<AgendamentoLazer> agendamentoLazerCollection;

    public Condominio() {
    }

    public Condominio(Integer id) {
        this.id = id;
    }

    public Condominio(Integer id, String nome, String logradouro, String bairro, String cidade, String numero) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @XmlTransient
    public Collection<Financeiro> getFinanceiroCollection() {
        return financeiroCollection;
    }

    public void setFinanceiroCollection(Collection<Financeiro> financeiroCollection) {
        this.financeiroCollection = financeiroCollection;
    }

    @XmlTransient
    public Collection<Mensagem> getMensagemCollection() {
        return mensagemCollection;
    }

    public void setMensagemCollection(Collection<Mensagem> mensagemCollection) {
        this.mensagemCollection = mensagemCollection;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    @XmlTransient
    public Collection<PessoaCondominio> getPessoaCondominioCollection() {
        return pessoaCondominioCollection;
    }

    public void setPessoaCondominioCollection(Collection<PessoaCondominio> pessoaCondominioCollection) {
        this.pessoaCondominioCollection = pessoaCondominioCollection;
    }

    public Pessoa getSindico() {
        return sindico;
    }

    public void setSindico(Pessoa sindico) {
        this.sindico = sindico;
    }

    @XmlTransient
    public Collection<Notificacao> getNotificacaoCollection() {
        return notificacaoCollection;
    }

    public void setNotificacaoCollection(Collection<Notificacao> notificacaoCollection) {
        this.notificacaoCollection = notificacaoCollection;
    }

    @XmlTransient
    public Collection<AgendamentoLazer> getAgendamentoLazerCollection() {
        return agendamentoLazerCollection;
    }

    public void setAgendamentoLazerCollection(Collection<AgendamentoLazer> agendamentoLazerCollection) {
        this.agendamentoLazerCollection = agendamentoLazerCollection;
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
        if (!(object instanceof Condominio)) {
            return false;
        }
        Condominio other = (Condominio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.Condominio[ id=" + id + " ]";
    }
    
}
