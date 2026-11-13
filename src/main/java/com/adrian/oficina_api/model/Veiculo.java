package com.adrian.oficina_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    private String modelo;
    private Integer ano;

    public Veiculo() {}

    public Long getId() { return id; }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public Integer getAno() { return ano; }

    public void setId(Long id) { this.id = id; }
    public void setPlaca(String placa) { this.placa = placa; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAno(Integer ano) { this.ano = ano; }


}