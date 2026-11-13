package com.adrian.oficina_api.controller;

import com.adrian.oficina_api.model.Veiculo;
import com.adrian.oficina_api.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService service;
    public VeiculoController (VeiculoService service) { this.service = service;}

    @GetMapping
    public List<Veiculo> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Veiculo buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@RequestBody Veiculo v) { return service.cadastrar(v); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) { service.deletar(id); }

    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo dados) {
        return service.atualizar(id, dados);
    }
    
    @PatchMapping("/{id}")
    public Veiculo atualizarParcial(@PathVariable Long id, @RequestBody Veiculo dados) {
        return service.atualizarParcial(id, dados);
    }
}
