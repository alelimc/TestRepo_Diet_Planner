package com.dietplanner.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealPlanDTO {
    private String username;
    private String fullname;
    private String dietPreference;
    private int caloricIntakeGoal;
    private double weight;
    private String mealplanname;
    private String mealname;
    private int calories;
    private int carbohydrate;
    private int fat;
    private int protein;
    private int mealquantity;
    private String assignedDay;
}
