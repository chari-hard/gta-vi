package com.dt2.gtavi.controllers;
import com.dt2.gtavi.entities.Carro;
import com.dt2.gtavi.repositories.CarroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carros")
public class CarroController {

    private final CarroRepository repository;
    public CarroController(CarroRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Carro> mostrar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id){
        repository.findById(id);
    }

    @PostMapping
    public void criarCarro(@RequestBody Carro c){
        repository.save(c);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Carro c){
        Carro carro = repository.getReferenceById(id);
        carro.setNome(c.getNome());
        carro.setMarca(c.getMarca());
        carro.setCategoria(c.getCategoria());
        carro.setDescricao(c.getDescricao());
        carro.setImagem(c.getImagem());
        repository.save(carro);
    }

}

