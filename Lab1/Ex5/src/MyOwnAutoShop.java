public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan sedan = new Sedan(100,5000.45,"blue",4);
        Ford ford1 = new Ford(90,3230,"black",2003,40);
        Ford ford2 = new Ford(90,1440.76,"red",2001,70);
        Car car = new Car(120,3300.2,"gray");
        System.out.println("Pretul la Sedan este: "+sedan.getSalePrice());
        System.out.println("Pretul la primul Ford este: "+ ford1.getSalePrice());
        System.out.println("Pretul la al doilea Ford este: "+ ford2.getSalePrice());
        System.out.println("Pretul la Car este: " + car.getSalePrice());
    }
}
