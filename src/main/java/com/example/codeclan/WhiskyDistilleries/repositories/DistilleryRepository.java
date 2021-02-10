package com.example.codeclan.WhiskyDistilleries.repositories;

import com.example.codeclan.WhiskyDistilleries.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
}
