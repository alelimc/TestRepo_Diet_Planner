package com.dietplanner.service;

import com.dietplanner.dto.MealPlanDTO;
import com.dietplanner.repository.MealPlanCustomRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealPlanService {

    private final MealPlanCustomRepository mealPlanCustomRepository;
    private final UserService userService;

    public MealPlanService(MealPlanCustomRepository mealPlanCustomRepository, UserService userService) {
        this.mealPlanCustomRepository = mealPlanCustomRepository;
        this.userService = userService;
    }

    // ✅ Fetch Meal Plans for the Logged-in User
    public List<MealPlanDTO> getLoggedInUserMealPlans() {
        String username = getLoggedInUsername();
        int accountId = userService.getUserIdByUsername(username);

        return mealPlanCustomRepository.getMealPlansByUserId(accountId);
    }

    // ✅ Get Logged-in Username
    private String getLoggedInUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}