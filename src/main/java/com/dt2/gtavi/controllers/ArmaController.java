package com.dt2.gtavi.controllers;

import com.dt2.gtavi.entities.Arma;
import com.dt2.gtavi.repositories.ArmaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/armas")
public class ArmaController {

    private final ArmaRepository repository;
    public ArmaController(ArmaRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Arma> mostrar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id){
        repository.findById(id);
    }

    @PostMapping
    public void criarArma(@RequestBody Arma a){
        repository.save(a);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Arma a){
        Arma arma = repository.getReferenceById(id);
        arma.setNome(a.getNome());
        arma.setFabricante(a.getFabricante());
        arma.setCategoria(a.getCategoria());
        arma.setDescricao(a.getDescricao());
        arma.setImagem(a.getImagem());
        repository.save(arma);
    }

}
