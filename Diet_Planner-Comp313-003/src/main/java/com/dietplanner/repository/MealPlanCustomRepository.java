package com.dietplanner.repository;

import com.dietplanner.dto.MealPlanDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MealPlanCustomRepository {

    private final EntityManager entityManager;

    public MealPlanCustomRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    public List<MealPlanDTO> getMealPlansByUserId(int userId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GetUserMealPlans");

        query.registerStoredProcedureParameter(1, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.setParameter(1, userId);

        List<Object[]> results = query.getResultList();
        return results.stream().map(record -> {
            MealPlanDTO mealPlan = new MealPlanDTO();
            mealPlan.setUsername((String) record[0]);
            mealPlan.setFullname((String) record[1]);
            mealPlan.setDietPreference((String) record[2]);
            mealPlan.setCaloricIntakeGoal((Integer) record[3]);
            mealPlan.setWeight((Double) record[4]);
            mealPlan.setMealname((String) record[5]);
            mealPlan.setMealname((String) record[6]);
            mealPlan.setCalories((Integer) record[7]);
            mealPlan.setCarbohydrate((Integer) record[8]);
            mealPlan.setFat((Integer) record[9]);
            mealPlan.setMealquantity((Integer) record[10]);
            mealPlan.setAssignedDay((String) record[11]);
            return mealPlan;
        }).toList();
    }
}
