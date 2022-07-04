package com.amotek.planningandfeedback.infrastructure.adapter.persistance.repository;

import com.amotek.planningandfeedback.infrastructure.adapter.persistance.entity.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetTrainingsJpaRepository extends JpaRepository<TrainingEntity, String> {

}
