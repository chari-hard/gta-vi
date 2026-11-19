package com.dt2.gtavi.controllers;

import com.dt2.gtavi.entities.Missao;
import com.dt2.gtavi.repositories.MissaoRepository;
import jakarta.persistence.Column;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/missoes")
public class MissaoController {
    private final MissaoRepository repository;

    public MissaoController(MissaoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Missao> mostrar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id){
        repository.findById(id);
    }

    @PostMapping
    public void cadastrar(@RequestBody Missao m){
        repository.save(m);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable int id, @RequestBody Missao m){
        Missao missao = repository.getReferenceById(id);
        missao.setNome(m.getNome());
        missao.setLocal(m.getLocal());
        missao.setDificuldade(m.getDificuldade());
        missao.setImagem(m.getImagem());
        missao.setDescricao(m.getDescricao());
        repository.save(missao);
    }
}
