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

    public Veiculo atualizar(Long id, Veiculo dados) {
        Veiculo v = buscar(id);
        validarPlaca(v, dados.getPlaca());

        v.setPlaca(dados.getPlaca());
        v.setModelo(dados.getModelo());
        v.setAno(dados.getAno());
        return repo.save(v);
    }

    public Veiculo atualizarParcial(Long id, Veiculo dados) {
        Veiculo v = buscar(id);

        if (dados.getPlaca() != null) {
            validarPlaca(v, dados.getPlaca());
            v.setPlaca(dados.getPlaca());
        }
        if (dados.getModelo() != null) v.setModelo(dados.getModelo());
        if (dados.getAno() != null) v.setAno(dados.getAno());

        return repo.save(v);

    }

    private void validarPlaca(Veiculo atual, String novaPlaca) {
        boolean mudouPlaca = !atual.getPlaca().equalsIgnoreCase(novaPlaca);
        if (mudouPlaca && repo.existsByPlacaIgnoreCase(novaPlaca)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Placa ja cadastrada.");
        }
    }
    
}
