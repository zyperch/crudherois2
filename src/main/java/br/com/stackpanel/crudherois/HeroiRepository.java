package br.com.stackpanel.crudherois;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {
    Optional<Heroi> findHeroiByNome(String nome);

    Optional<Heroi> findHeroiByPoderAtaque(Integer poderAtaque);
    Optional<Heroi> findHeroiByPoderDefesa(Integer poderDefesa);
    Optional<Heroi> findHeroiByVida(Integer vida);

    Optional<Heroi> findHeroiByNomeOrPoderAtaqueOrPoderDefesaOrVida(String nome, Integer poderataque, Integer poderDefesa, Integer vida);




}
