package com.adrian.oficina_api.service;

import com.adrian.oficina_api.model.Veiculo;
import com.adrian.oficina_api.repository.VeiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class VeiculoService {
    private final VeiculoRepository repo;
    public VeiculoService(VeiculoRepository repo) { this.repo = repo; }

    public List<Veiculo> listar() { return repo.findAll(); }

    public Veiculo buscar(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Veiculo não encontrado"));
    }

    public Veiculo cadastrar(Veiculo v) {
        if (repo.existsByPlacaIgnoreCase(v.getPlaca())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Placa já cadastrada.");
        }
        return repo.save(v);
    }

    public void deletar(Long id) {
        buscar(id);
        repo.deleteById(id);
    }
    
}
