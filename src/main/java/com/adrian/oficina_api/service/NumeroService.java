package com.adrian.oficina_api.service;

import com.adrian.oficina_api.repository.NumeroRepository;
import org.springframework.stereotype.Service;

@Service
public class NumeroService {
    private final NumeroRepository repo;
    public NumeroService(NumeroRepository repo) { this.repo = repo; }

    public int numero() { return repo.buscar(); }

    public int dobro() { return repo.buscar() * 2; }
}
