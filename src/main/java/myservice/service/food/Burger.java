package myservice.service.food;

import myservice.service.food.Food;

public record Burger(String name, Boolean Fatness) implements Food {
}
