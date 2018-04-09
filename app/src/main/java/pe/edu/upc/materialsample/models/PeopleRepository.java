package pe.edu.upc.materialsample.models;

public class PeopleRepository {
    private static PeopleRepository instance;

    public PeopleRepository(){
        instance = this;
    }

    public static PeopleRepository getInstance(){
        return instance;
    }
}
