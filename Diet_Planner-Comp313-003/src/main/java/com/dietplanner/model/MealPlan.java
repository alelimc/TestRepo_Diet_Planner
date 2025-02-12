package com.dietplanner.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meal_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealPlanid")
    private int mealPlanId;

    @ManyToOne
    @JoinColumn(name = "accountid", referencedColumnName = "accountid", nullable = false)
    private User user; // Maps to the account table

    @Column(name = "mealplanname", nullable = false)
    private String mealPlanName;

    @Column(name = "totalcalories")
    private Integer totalCalories;

    @Column(name = "totalcarbohydrate")
    private Integer totalCarbohydrate;

    @Column(name = "totalfat")
    private Integer totalFat;

    @Column(name = "totalprotein")
    private Integer totalProtein;
}
