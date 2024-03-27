package myservice.service.creatures;

import java.time.LocalDate;
import java.util.Date;

public record Pet(String id,String name, String color, String ownerId, LocalDate dateOfBirth){

}
