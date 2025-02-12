package com.dietplanner.controller;

import com.dietplanner.dto.MealPlanDTO;
import com.dietplanner.service.MealPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MealPlanController {

    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping("/my-plans")
    public String myPlans(Model model) {
        List<MealPlanDTO> mealPlans = mealPlanService.getLoggedInUserMealPlans();
        model.addAttribute("mealPlans", mealPlans);

        if (!mealPlans.isEmpty()) {
            model.addAttribute("username", mealPlans.get(0).getUsername());
            model.addAttribute("dietPreference", mealPlans.get(0).getDietPreference());
            model.addAttribute("caloricIntakeGoal", mealPlans.get(0).getCaloricIntakeGoal());
            model.addAttribute("weight", mealPlans.get(0).getWeight());
        }

        return "myplan";
    }
}
