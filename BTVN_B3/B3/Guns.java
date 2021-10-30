package B3;

import java.util.Random;

public class Guns {
    private int ammoNumber = 100;
    private String weaponName;

    public int Load(int x){
        ammoNumber += x;
        return ammoNumber;
    }
    public int Shoot(int x){
       if(ammoNumber >= x){
           ammoNumber -= x;
       }
        return ammoNumber;
    }
    public Guns(){}

    public Guns(int ammoNumber, String weaponName) {
        this.ammoNumber = ammoNumber;
        this.weaponName = weaponName;
    }

    public int Rand(){
        double x = Math.random();
        x = x * 10 + 1;
        int randomX = (int) x;
        return randomX;
    }

    public int getAmmoNumber() {
        return ammoNumber;
    }

    public void setAmmoNumber(int ammoNumber) {
        this.ammoNumber = ammoNumber;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
