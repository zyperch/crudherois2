package br.com.stackpanel.crudherois;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/herois")
public class HeroiController {
    private final HeroiService heroiService;

    public HeroiController(HeroiService heroiService) {
        this.heroiService = heroiService;
    }

    @PostMapping
    public ResponseEntity<?> saveHeroi(@RequestBody Heroi heroi){
        return ResponseEntity.status(HttpStatus.CREATED).body(heroiService.save(heroi));
    }

    @GetMapping
    public ResponseEntity<List<Heroi>> findAllHerois(){
        return ResponseEntity.status(HttpStatus.OK).body(heroiService.findAllHerois());
    }

    @GetMapping("/{id}")
    public Optional<Heroi> findHeroiById(@PathVariable Long id){
        return heroiService.findHeroisById(id);
    }

    @GetMapping("/buscar/nome")
    public Optional<Heroi> findByName(@PathParam(value = "nome") String nome)
    {
        return heroiService.findHeroiByNome(nome);
    }

    @GetMapping("/buscar/poderataque")
    public Optional<Heroi> findByPoderAtaque(@PathParam(value = "nome") Integer poderataque)
    {
        return heroiService.findHeroiByPoderAtaque(poderataque);
    }
    @GetMapping("/buscar/poderdefesa")
    public Optional<Heroi> findByPoderDefesa(@PathParam(value = "nome") Integer poderdefesa)
    {
        return heroiService.findHeroiByPoderDefesa(poderdefesa);
    }

    @GetMapping("/buscar/vida")
    public Optional<Heroi> findByVida(@PathParam(value = "nome") Integer vida)
    {
        return heroiService.findHeroiByVida(vida);
    }

    @PostMapping("/atacar/{id}")
    public ResponseEntity<?> atacar(@PathVariable Long id, @RequestBody Integer dano){
        return ResponseEntity.status(HttpStatus.OK).body(heroiService.atacar(id, dano));
    }


}
