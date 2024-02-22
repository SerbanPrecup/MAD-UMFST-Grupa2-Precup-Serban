public class Car {
    private int speed;
    private double regularPrice;
    private String color;

    public Car(int speed,double regularPrice, String color){
        this.color=color;
        this.regularPrice=regularPrice;
        this.speed=speed;
    }
    double getSalePrice(){
        return regularPrice;
    }
}
