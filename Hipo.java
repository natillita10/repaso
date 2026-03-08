public class Hipo{

    String color;
    int tamaño;

    public Hipo(String color, int tamaño){
        this.color=color;
        this.tamaño=tamaño;

    }

    public String getColor(){
        return this.color;
    }

    public String setColor(String color){
        this.color = color;
        return color;
    }

    public int getTamaño(){
        return this.tamaño;
    }

    public int setTamaño(int tamaño){
        this.tamaño = tamaño;
        return tamaño;
    }

    public String toString(){
        return(color+","+tamaño);
    }

}
