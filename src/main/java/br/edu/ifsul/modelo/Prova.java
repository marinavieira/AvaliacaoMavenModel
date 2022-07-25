package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author marina.ferreira
 */
@Entity
@Table(name = "prova")
public class Prova implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_prova", sequenceName = "seq_prova_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_prova", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O descricao não pode ser em branco")
    @Length(max = 80, message = "O descricao não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 80, nullable = false)
    private String descricao;
    @NotBlank(message = "O conteudo não pode ser em branco")
    @Length(max = 80, message = "O conteudo não pode ter mais que {max} caracteres")
    @Column(name = "conteudo", length = 80, nullable = false)
    private String conteudo;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da prova deve ser informada")
    @Column(name = "data_prova", nullable = false)
    private Calendar dataProva;
    @Min(value = 0, message = "A media não deve ser negativa")
    @NotNull(message = "A media ser informada")
    @Column(name = "media_geral", nullable = false, columnDefinition = "decimal(6,3)")
    private Double mediaGeral;
    @NotBlank(message = "O professor não pode ser em branco")
    @Length(max = 80, message = "O professor não pode ter mais que {max} caracteres")
    @Column(name = "professor", length = 50, nullable = false)
    private String professor;
    @OneToMany(mappedBy = "prova", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();

    public Prova() {

    }

    public void adicionarNota(Nota obj) {
        obj.setProva(this);
        this.getNotas().add(obj);
    }

    public void removerNota(int index) {
        this.notas.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prova other = (Prova) obj;
        return Objects.equals(this.id, other.id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Calendar getDataProva() {
        return dataProva;
    }

    public void setDataProva(Calendar dataProva) {
        this.dataProva = dataProva;
    }

    public Double getMediaGeral() {
        return mediaGeral;
    }

    public void setMediaGeral(Double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

}
