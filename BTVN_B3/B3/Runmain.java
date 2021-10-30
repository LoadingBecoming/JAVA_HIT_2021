package B3;

public class Runmain {
    public static void main(String[] args) {
        Guns DiepBeDe = new Guns();
        Guns DoanXinhGai = new Guns();

        while(true){
            DiepBeDe.Shoot(DiepBeDe.Rand());
            DoanXinhGai.Shoot(DoanXinhGai.Rand());

            if(DiepBeDe.getAmmoNumber() == 0 && DoanXinhGai.getAmmoNumber() == 0){
                DiepBeDe.Load(DiepBeDe.Rand());
                DoanXinhGai.Load(DoanXinhGai.Rand());
            }
            else if(DiepBeDe.getAmmoNumber() == 0 && DoanXinhGai.getAmmoNumber() != 0){
                System.out.println("DoanXinhGai wins!");
                return;
            }
            else if(DiepBeDe.getAmmoNumber() != 0 && DoanXinhGai.getAmmoNumber() == 0){
                System.out.println("DiepBeDe wins");
                return;
            }
        }
    }
}

