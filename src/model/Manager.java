/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class Manager extends Karyawan{
    private String tanggungJawab;

    public Manager(String tanggungJawab, String nama, int jamKerja, String jenisKelamin, Departemen departemen) {
        super(nama, jamKerja, jenisKelamin, departemen);
        this.tanggungJawab = tanggungJawab;
    }

    public String getTanggungJawab() {
        return tanggungJawab;
    }

    public void setTanggungJawab(String tanggungJawab) {
        this.tanggungJawab = tanggungJawab;
    }
    
    @Override
    public long hitungGaji(){
        return jamKerja * 1000000;
    }
    
    
}
