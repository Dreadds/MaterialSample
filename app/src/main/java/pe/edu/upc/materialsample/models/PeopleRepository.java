package pe.edu.upc.materialsample.models;

import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {
    private static PeopleRepository instance;
    List<Person> people;

    public PeopleRepository(){
        instance = this;
    }

    public static PeopleRepository getInstance(){
        return instance;
    }

    public  List<Person> getPeople(){
        if(people == null) init();
        return people;
    }

    private  PeopleRepository init(){
        people = new ArrayList<>();
        people.add(new Person("John", "Doe"));
        people.add(new Person("Jason", "Bourne"));
        return  this;
    }
}
