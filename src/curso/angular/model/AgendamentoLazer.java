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
@Table(name = "agendamento_lazer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgendamentoLazer.findAll", query = "SELECT a FROM AgendamentoLazer a"),
    @NamedQuery(name = "AgendamentoLazer.findById", query = "SELECT a FROM AgendamentoLazer a WHERE a.id = :id"),
    @NamedQuery(name = "AgendamentoLazer.findByInicio", query = "SELECT a FROM AgendamentoLazer a WHERE a.inicio = :inicio"),
    @NamedQuery(name = "AgendamentoLazer.findByFim", query = "SELECT a FROM AgendamentoLazer a WHERE a.fim = :fim"),
    @NamedQuery(name = "AgendamentoLazer.findByEvento", query = "SELECT a FROM AgendamentoLazer a WHERE a.evento = :evento"),
    @NamedQuery(name = "AgendamentoLazer.findByAprovacao", query = "SELECT a FROM AgendamentoLazer a WHERE a.aprovacao = :aprovacao"),
    @NamedQuery(name = "AgendamentoLazer.findByDataaprovacao", query = "SELECT a FROM AgendamentoLazer a WHERE a.dataaprovacao = :dataaprovacao")})
public class AgendamentoLazer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fim;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "evento")
    private String evento;
    @Column(name = "aprovacao")
    private Boolean aprovacao;
    @Column(name = "dataaprovacao")
    @Temporal(TemporalType.DATE)
    private Date dataaprovacao;
    @JoinColumn(name = "area_de_lazer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AreaLazer areaDeLazerId;
    @JoinColumn(name = "condominio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Condominio condominioId;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa pessoaId;

    public AgendamentoLazer() {
    }

    public AgendamentoLazer(Integer id) {
        this.id = id;
    }

    public AgendamentoLazer(Integer id, Date inicio, Date fim, String evento) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.evento = evento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Boolean getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Date getDataaprovacao() {
        return dataaprovacao;
    }

    public void setDataaprovacao(Date dataaprovacao) {
        this.dataaprovacao = dataaprovacao;
    }

    public AreaLazer getAreaDeLazerId() {
        return areaDeLazerId;
    }

    public void setAreaDeLazerId(AreaLazer areaDeLazerId) {
        this.areaDeLazerId = areaDeLazerId;
    }

    public Condominio getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Condominio condominioId) {
        this.condominioId = condominioId;
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
        if (!(object instanceof AgendamentoLazer)) {
            return false;
        }
        AgendamentoLazer other = (AgendamentoLazer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino2.model.AgendamentoLazer[ id=" + id + " ]";
    }
    
}
