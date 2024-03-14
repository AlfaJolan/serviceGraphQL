package myservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.io.PipedWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PetsController {
    List<Pet> pets = new ArrayList<>();

    @PostConstruct
    void init(){
        // Инициализируем список питомцев при создании объекта контроллера
        pets.add(new Pet("Alfa", "Black"));
        pets.add(new Pet("Aqtos", "Latte"));
    }
    @QueryMapping
    List<Pet> pets(){
        return pets;
    }

    @QueryMapping
    Pet pet(@Argument String name) {
        for (Pet pet : pets) {
                if (pet.name().equals(name)) {
                    System.out.println("Hereerererereeeeeeeeeeeeeeeeeeeeeeeeeeee");
                    return pet;
                }
            }
        return new Pet("False" ,"Red"); // Если питомец не найден
    }
}
