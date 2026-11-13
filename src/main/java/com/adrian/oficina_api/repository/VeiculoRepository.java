package com.adrian.oficina_api.repository;

import com.adrian.oficina_api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    boolean existsByPlacaIgnoreCase(String placa);
}

