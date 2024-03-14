package myservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.io.PipedWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PetsController {

    PetService petService;

    public PetsController(PetService petService){
        this.petService = petService;
    }
    @QueryMapping
    List<Pet> pets(){
        return petService.pets;
    }

    @QueryMapping
    Pet pet(@Argument String name) {
        return petService.findPetByName(name);
    }

    @SchemaMapping(typeName = "Pet", field = "owner")
    Person owner(Pet pet) {
        return petService.getPerson(pet.ownerId());
    }
}
