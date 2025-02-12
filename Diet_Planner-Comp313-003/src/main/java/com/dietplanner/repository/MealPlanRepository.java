package com.dietplanner.repository;

import com.dietplanner.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Integer> {
    // This repository now only manages MealPlan as a JPA entity.
}
