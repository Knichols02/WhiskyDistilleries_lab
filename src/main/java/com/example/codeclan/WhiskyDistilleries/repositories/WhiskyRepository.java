package com.example.codeclan.WhiskyDistilleries.repositories;

import com.example.codeclan.WhiskyDistilleries.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
}
