public class Televizor {
    private int diagonala;
    private double pret;
    private String marca;
    Televizor(int diagonala,double pret,String marca){
        this.marca=marca;
        this.diagonala=diagonala;
        this.pret=pret;
    }
    public int getDiagonala(){
        return this.diagonala;
    }
    public double getPret(){
        return this.pret;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setDiagonala(int diagonala){
        this.diagonala=diagonala;
    }
    public void setPret(double pret){
        this.pret=pret;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
}
