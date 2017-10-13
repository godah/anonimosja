/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.angular.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luciano
 */
@Entity
@Table(name = "lancamento_financeiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LancamentoFinanceiro.findAll", query = "SELECT l FROM LancamentoFinanceiro l"),
    @NamedQuery(name = "LancamentoFinanceiro.findById", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.id = :id"),
    @NamedQuery(name = "LancamentoFinanceiro.findByDataLancamento", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.dataLancamento = :dataLancamento"),
    @NamedQuery(name = "LancamentoFinanceiro.findByDescricao", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.descricao = :descricao"),
    @NamedQuery(name = "LancamentoFinanceiro.findByServicoPessoaServicoId", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.servicoPessoaServicoId = :servicoPessoaServicoId"),
    @NamedQuery(name = "LancamentoFinanceiro.findByServicoPessoaPessoaId", query = "SELECT l FROM LancamentoFinanceiro l WHERE l.servicoPessoaPessoaId = :servicoPessoaPessoaId")})
public class LancamentoFinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "data_lancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 60)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "servico_pessoa_servico_id")
    private Integer servicoPessoaServicoId;
    @Column(name = "servico_pessoa_pessoa_id")
    private Integer servicoPessoaPessoaId;
    @JoinColumn(name = "servico_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Servico servicoId;
    @JoinColumn(name = "financeiro_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Financeiro financeiroId;
    @JoinColumn(name = "lancamento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lancamento lancamentoId;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa pessoaId;

    public LancamentoFinanceiro() {
    }

    public LancamentoFinanceiro(Integer id) {
        this.id = id;
    }

    public LancamentoFinanceiro(Integer id, Date dataLancamento, String descricao) {
        this.id = id;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getServicoPessoaServicoId() {
        return servicoPessoaServicoId;
    }

    public void setServicoPessoaServicoId(Integer servicoPessoaServicoId) {
        this.servicoPessoaServicoId = servicoPessoaServicoId;
    }

    public Integer getServicoPessoaPessoaId() {
        return servicoPessoaPessoaId;
    }

    public void setServicoPessoaPessoaId(Integer servicoPessoaPessoaId) {
        this.servicoPessoaPessoaId = servicoPessoaPessoaId;
    }

    public Servico getServicoId() {
        return servicoId;
    }

    public void setServicoId(Servico servicoId) {
        this.servicoId = servicoId;
    }

    public Financeiro getFinanceiroId() {
        return financeiroId;
    }

    public void setFinanceiroId(Financeiro financeiroId) {
        this.financeiroId = financeiroId;
    }

    public Lancamento getLancamentoId() {
        return lancamentoId;
    }

    public void setLancamentoId(Lancamento lancamentoId) {
        this.lancamentoId = lancamentoId;
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
        if (!(object instanceof LancamentoFinanceiro)) {
            return false;
        }
        LancamentoFinanceiro other = (LancamentoFinanceiro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.LancamentoFinanceiro[ id=" + id + " ]";
    }
    
}
