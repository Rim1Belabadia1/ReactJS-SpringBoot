package com.labbackend.labbackendx.repository;

import com.labbackend.labbackendx.model.Doctorant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorantRepository extends JpaRepository<Doctorant, Long> {
    // You can define custom query methods here if needed
}
