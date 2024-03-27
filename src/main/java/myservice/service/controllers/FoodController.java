package myservice.service.controllers;

import myservice.service.food.Burger;
import myservice.service.food.Pizza;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FoodController {
    @QueryMapping
    List<Object> fastFood(){
        return List.of(new Pizza("Hawaiian", true), new Burger("BBQ XXL", true));
    }
}
