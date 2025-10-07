package br.com.criandoapivortex.projetovortex.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length =300, nullable = true)
    private String nome;

    @Column(name = "email", length = 50, nullable = true)
    private String email;

    @Column(name = "senha", columnDefinition = "TEXT", nullable = true)
    private String senha;

    @Column(name = "telefone", length = 15, nullable = true)
    private String telefone;




    @Column(name = "pontuacao", columnDefinition = "INT default 0")
    private Integer pontuacao = 0;

    // link unico - IA
    @Column(name = "link_indicacao", unique = true, nullable = false)
    private String linkIndicacao;

    //credencial para o indicador IA
    @Column(name = "indicado_por_id", nullable = true)
    private Integer indicadoPorId;


    @PrePersist
    public void generateLink() {
        if (linkIndicacao == null || linkIndicacao.isEmpty()) {
            this.linkIndicacao = UUID.randomUUID().toString();
        }
    }


    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getLinkIndicacao() {
        return linkIndicacao;
    }

    public void setLinkIndicacao(String linkIndicacao) {
        this.linkIndicacao = linkIndicacao;
    }

    public Integer getIndicadoPorId() {
        return indicadoPorId;
    }

    public void setIndicadoPorId(Integer indicadoPorId) {
        this.indicadoPorId = indicadoPorId;
    }



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}