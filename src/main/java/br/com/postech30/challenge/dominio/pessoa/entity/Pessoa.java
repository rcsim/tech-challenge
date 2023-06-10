package br.com.postech30.challenge.dominio.pessoa.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Vector;

public class Pessoa {

    private final Collection<Pessoa> parentesco = new Vector<>();
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDate dataNascimento, String sexo) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public Pessoa adicionaParentesco(Pessoa p) {
        parentesco.add(p);
        return this;
    }

    public Pessoa removeParentesco(Pessoa p) {
        parentesco.remove(p);
        return this;
    }

    public Collection<Pessoa> getParentesco() {
        return Collections.unmodifiableCollection(parentesco);
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Pessoa setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Pessoa setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getSexo() {
        return sexo;
    }

    public Pessoa setSexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(parentesco, pessoa.parentesco) && Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(dataNascimento, pessoa.dataNascimento) && Objects.equals(sexo, pessoa.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentesco, id, nome, dataNascimento, sexo);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "parentesco=" + parentesco +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
