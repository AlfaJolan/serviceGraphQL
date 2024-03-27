package myservice.service;

import java.time.LocalDate;
import java.util.Date;

record Pet(String id,String name, String color, String ownerId, LocalDate dateOfBirth){

}
