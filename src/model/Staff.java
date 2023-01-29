/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Teprutz
 */
public class Staff extends Karyawan{
    private String noStaff;

    public Staff(String noStaff, String nama, int jamKerja, String jenisKelamin) {
        super(nama, jamKerja, jenisKelamin);
        this.noStaff = noStaff;
    }

    public String getNoStaff() {
        return noStaff;
    }

    public void setNoStaff(String noStaff) {
        this.noStaff = noStaff;
    }
    
    @Override
    public long hitungGaji(){
        return jamKerja * 1000000;
    }
    
    @Override
    public String showDataKaryawan(){
        return "Staff dengan nomor "+ noStaff + ", bernama "+ nama +
                ", berjenis kelamin " + jenisKelamin +
                " , memiliki gaji total = " +this.hitungGaji();
        
    }
}
