/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Departemen {
    private String kodeDepartemen;
    private String namaDepartemen;
    private int tahunBerdiri;
    
    public Departemen()
    {
    }

    public Departemen(String kodeDepartemen, String namaDepartemen, int tahunBerdiri) {
        this.kodeDepartemen = kodeDepartemen;
        this.namaDepartemen = namaDepartemen;
        this.tahunBerdiri = tahunBerdiri;
    }
    
    @Override
    public String toString(){
        return namaDepartemen;
    }

    public String getKodeDepartemen() {
        return kodeDepartemen;
    }

    public void setKodeDepartemen(String kodeDepartemen) {
        this.kodeDepartemen = kodeDepartemen;
    }

    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    public void setNamaDepartemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
    }

    public void showData()
    {
        System.out.println("Kode Departemen : "+kodeDepartemen);
        System.out.println("Nama Departemen : "+namaDepartemen);
        System.out.println("Tahun Berdiri : "+tahunBerdiri);
        System.out.println("\n");
    }
    
}
