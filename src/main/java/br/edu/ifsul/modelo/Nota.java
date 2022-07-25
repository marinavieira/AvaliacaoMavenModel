/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author marina.ferreira
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Min(value = 0, message = "A nota não deve ser negativa")
    @NotNull(message = "A nota deve ser informada")
    @Column(name = "nota", nullable = false, columnDefinition = "decimal(6,3)")
    private Double nota;
    @NotBlank(message = "O aluno deve ser informado")
    @Length(max = 40, message = "O aluno não pode ter mais que {max} caracteres")
    @Column(name = "aluno", length = 50, nullable = false)
    private String aluno;
    @NotNull(message = "A prova deve ser informada")
    @ManyToOne
    @JoinColumn(name = "prova", referencedColumnName = "id", nullable = false)
    private Prova prova;

    public Nota() {
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Nota other = (Nota) obj;
        return Objects.equals(this.id, other.id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

}
