public class Main {
    public static void main(String[] args) {
        Televizor tv= new Televizor(124,2399.99,"Samsung");
        tv.setMarca("LG");
        tv.setDiagonala(110);
        tv.setPret(2199.99);
        System.out.println(tv.getMarca() +" "+ tv.getDiagonala() +" "+ tv.getPret());
    }
}