package myservice.service.controllers;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetchingEnvironment;
import myservice.service.*;
import myservice.service.creatures.Person;
import myservice.service.creatures.Pet;
import myservice.service.services.PetService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetsController {
// 95 STR to 115 STR
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

    @QueryMapping
    List<Pet> petSearch(@Argument PetSearchInput input){
        return petService.petSearch(input);
    }

    @QueryMapping
    DataFetcherResult<List<Pet>> petErrorTest(DataFetchingEnvironment env) {
        List<Pet> result = petService.pets;
        GraphQLError error = GraphqlErrorBuilder.newError(env)
                .errorType(ErrorType.DataFetchingException)
                .message("Data could only be partially loaded")
                .build();
        return DataFetcherResult.<List<Pet>>newResult()
                .data(result)
                .error(error)
                .build();
    }


    @SchemaMapping(typeName = "Pet", field = "owner")
    Person owner(Pet pet) {
        System.out.println(pet.ownerId());
        return petService.getPerson(pet.ownerId());
    }

    @MutationMapping
    ChangePetNamePayload changePetName(
            @Argument String id,
            @Argument String newName
    ){
        return petService.changePetName(id,newName);
    }

    // TEMP

}
