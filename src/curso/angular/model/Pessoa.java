/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.angular.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.id = :id"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByCnpj", query = "SELECT p FROM Pessoa p WHERE p.cnpj = :cnpj"),
    @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Pessoa.findByLogin", query = "SELECT p FROM Pessoa p WHERE p.login = :login"),
    @NamedQuery(name = "Pessoa.findBySenha", query = "SELECT p FROM Pessoa p WHERE p.senha = :senha"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByVipAte", query = "SELECT p FROM Pessoa p WHERE p.vipAte = :vipAte")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    //@Size(max = 45)
    @Column(name = "cpf")
    private String cpf;
    //@Size(max = 45)
    @Column(name = "cnpj")
    private String cnpj;
    //@Size(max = 14)
    @Column(name = "telefone")
    private String telefone;
    //@Size(max = 45)
    @Column(name = "login")
    private String login;
    //@Size(max = 20)
    @Column(name = "senha")
    private String senha;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 20)
    @Column(name = "email")
    private String email;
    @Column(name = "vip_ate")
    @Temporal(TemporalType.DATE)
    private Date vipAte;
    @JoinColumn(name = "tipo_pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoPessoa tipoPessoaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subsindico")
    private Collection<Grupo> grupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaIdResponsavel")
    private Collection<Unidade> unidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaIdProprietario")
    private Collection<Unidade> unidadeCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId")
    private Collection<Terceiro> terceiroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId")
    private Collection<LancamentoFinanceiro> lancamentoFinanceiroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private Collection<PessoaCondominio> pessoaCondominioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sindico")
    private Collection<Condominio> condominioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId")
    private Collection<Notificacao> notificacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId")
    private Collection<AgendamentoLazer> agendamentoLazerCollection;

    public Pessoa() {
    }

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getVipAte() {
        return vipAte;
    }

    public void setVipAte(Date vipAte) {
        this.vipAte = vipAte;
    }

    public TipoPessoa getTipoPessoaId() {
        return tipoPessoaId;
    }

    public void setTipoPessoaId(TipoPessoa tipoPessoaId) {
        this.tipoPessoaId = tipoPessoaId;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    @XmlTransient
    public Collection<Unidade> getUnidadeCollection() {
        return unidadeCollection;
    }

    public void setUnidadeCollection(Collection<Unidade> unidadeCollection) {
        this.unidadeCollection = unidadeCollection;
    }

    @XmlTransient
    public Collection<Unidade> getUnidadeCollection1() {
        return unidadeCollection1;
    }

    public void setUnidadeCollection1(Collection<Unidade> unidadeCollection1) {
        this.unidadeCollection1 = unidadeCollection1;
    }

    @XmlTransient
    public Collection<Terceiro> getTerceiroCollection() {
        return terceiroCollection;
    }

    public void setTerceiroCollection(Collection<Terceiro> terceiroCollection) {
        this.terceiroCollection = terceiroCollection;
    }

    @XmlTransient
    public Collection<LancamentoFinanceiro> getLancamentoFinanceiroCollection() {
        return lancamentoFinanceiroCollection;
    }

    public void setLancamentoFinanceiroCollection(Collection<LancamentoFinanceiro> lancamentoFinanceiroCollection) {
        this.lancamentoFinanceiroCollection = lancamentoFinanceiroCollection;
    }

    @XmlTransient
    public Collection<PessoaCondominio> getPessoaCondominioCollection() {
        return pessoaCondominioCollection;
    }

    public void setPessoaCondominioCollection(Collection<PessoaCondominio> pessoaCondominioCollection) {
        this.pessoaCondominioCollection = pessoaCondominioCollection;
    }

    @XmlTransient
    public Collection<Condominio> getCondominioCollection() {
        return condominioCollection;
    }

    public void setCondominioCollection(Collection<Condominio> condominioCollection) {
        this.condominioCollection = condominioCollection;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.Pessoa[ id=" + id + " ]";
    }
    
}
