package myservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
   public List<Pet> pets = new ArrayList<>();
   public List<Person> persons = new ArrayList<>();
    @PostConstruct
    void init(){
        // Инициализируем список питомцев при создании объекта контроллера
        pets.add(new Pet("Alfa", "Black","ID1", LocalDate.of(2014, 2, 21)));
        pets.add(new Pet("Aqtos", "Latte","ID1", LocalDate.of(2010, 5, 5)));
        persons.add(new Person("ID1","Nurkhan","Kuangaliyev"));
    }

    Pet findPetByName(String name){
        for (Pet pet : pets) {
            if (pet.name().equals(name)) {
                System.out.println("Hereerererereeeeeeeeeeeeeeeeeeeeeeeeeeee");
                return pet;
            }
        }
        return null;
    }
    Person getPerson(String id){
        for(Person person: persons){
            if(person.id().equals(id)) return person;
        }
        return null;
    }
    Person getPersonByName(String firstName){
        for(Person person: persons){
            if(person.firstName().equals(firstName)) return person;
        }
        return null;
    }
    List<Pet> petSearch(PetSearchInput input){
        List<Pet> result = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.name().equals(input.namePattern()) || getPersonByName(input.ownerPattern()).equals(input.ownerPattern())) {
                System.out.println("Hereerererereeeeeeeeeeeeeeeeeeeeeeeeeeee");
                result.add(pet);
            }
        }
        return result;
    }
}
