package com.adrian.oficina_api.controller;

import com.adrian.oficina_api.service.NumeroService;
import org.springframework.web.bind.annotation.*;

@RestController
public class NumeroController {
    private final NumeroService service;
    public NumeroController(NumeroService service) { this.service = service; }

    @GetMapping("/numero")
    public int numero() { return service.numero(); }

    @GetMapping("/numero/dobro")
    public int dobro() { return service.dobro(); }
}
