package br.com.stackpanel.crudherois;

import jakarta.persistence.*;

@Entity
@Table(name = "herois")
public class Heroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer poderAtaque;

    @Column(nullable = false)
    private Integer poderDefesa;

    @Column(nullable = false)
    private Integer vida;

    public Heroi(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(Integer poderAtaque) {
        this.poderAtaque = poderAtaque;
    }

    public Integer getPoderDefesa() {
        return poderDefesa;
    }

    public void setPoderDefesa(Integer poderDefesa) {
        this.poderDefesa = poderDefesa;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

}
