package com.dt2.gtavi.controllers;

import com.dt2.gtavi.entities.Personagem;
import com.dt2.gtavi.repositories.PersonagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personagens")
public class PersonagemController {

    private final PersonagemRepository repository;
    public PersonagemController(PersonagemRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Personagem> mostrar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id){
        repository.findById(id);
    }

    @PostMapping
    public String criarPersonagem(@RequestBody Personagem lucas){
        try {
            return "Calvo com sucesso " + repository.save(lucas);
        } catch (Exception e){
            return "Dados incorretos";
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Personagem p){
        Personagem personagem = repository.getReferenceById(id);
        personagem.setNome(p.getNome());
        personagem.setApelido(p.getApelido());
        personagem.setCategoria(p.getCategoria());
        personagem.setDescricao(p.getDescricao());
        personagem.setImagem(p.getImagem());
        repository.save(personagem);
    }

}
