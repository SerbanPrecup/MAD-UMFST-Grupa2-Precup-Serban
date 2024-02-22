public class Main {
    public static boolean ePrim(int nr){
        boolean ok=true;
        for(int i=2;i<=nr/2;i++)
            if(nr%i==0)
                ok=false;
        return ok;
    }
    public static void main(String[] args) {
        for(int i=3;i<100;i=i+2){
            if(ePrim(i) && ePrim(i+2)){
                int i2=i+2;
                System.out.println("(" + i + ", "+ i2 +" )");
            }
        }
    }
}