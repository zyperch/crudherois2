package br.com.stackpanel.crudherois;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HeroiService {
    private final HeroiRepository heroiRepository;

    public HeroiService(HeroiRepository heroiRepository) {
        this.heroiRepository = heroiRepository;
    }

    public Heroi save(Heroi heroi){
        return heroiRepository.save(heroi);
    }

    public List<Heroi> findAllHerois(){
        return heroiRepository.findAll();
    }

    public Optional<Heroi> findHerois(String nome, Integer poderataque, Integer poderDefesa, Integer vida){
        return heroiRepository.findHeroiByNomeOrPoderAtaqueOrPoderDefesaOrVida(nome, poderataque, poderDefesa, vida);
    }

    public Optional<Heroi> findHeroisById(Long id){
        return heroiRepository.findById(id);
    }

    public Optional<Heroi> findHeroiByNome(String nome){
        return heroiRepository.findHeroiByNome(nome);
    }

    public Optional<Heroi> findHeroiByPoderAtaque(Integer poderAtaque){
        return heroiRepository.findHeroiByPoderAtaque(poderAtaque);
    }

    public Optional<Heroi> findHeroiByPoderDefesa(Integer poderDefesa){
        return heroiRepository.findHeroiByPoderDefesa(poderDefesa);
    }

    public Optional<Heroi> findHeroiByVida(Integer vida){
        return heroiRepository.findHeroiByVida(vida);
    }

    public ResponseEntity<?> atacar(Long id, Integer dano){
        Heroi alvo = heroiRepository.findById(id).get();

        Integer vidaDoAlvo = alvo.getVida();
        Integer defesaDoAlvo = alvo.getPoderDefesa();

        Integer danoRecebido = defesaDoAlvo - dano;
        Integer vidaAtual = danoRecebido - vidaDoAlvo;
        if (dano <= defesaDoAlvo){
            return new ResponseEntity<>("O herói não sofreu danos, tente novamente.", HttpStatus.BAD_REQUEST);
        } else{
            alvo.setVida(vidaAtual);
            heroiRepository.save(alvo);
            return new ResponseEntity<>("O herói sofreu danos. Vida atual: " + vidaDoAlvo, HttpStatus.OK);
        }

    }

}
