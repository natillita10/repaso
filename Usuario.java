public class Usuario {
    int id;
    String name;
    int age;
    String city;
    String gender;

    public Usuario(int id, String name, int age, String city, String gender){
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.gender = gender;

    }

    public int getId(){
        return this.id;
    }

    public String getCity(){
        return this.city;
    }

    public String toString(){
        return(id+","+name+","+age+","+city+","+gender);
    }

}