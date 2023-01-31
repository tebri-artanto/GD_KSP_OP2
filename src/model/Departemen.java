/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Departemen {
    private String kodeDepartemen;
    private String namaDepartemen;
    private int banyakAnggota;

    public Departemen() {
    }

    public Departemen(String kodeDepartemen, String namaDepartemen, int banyakAnggota) {
        this.kodeDepartemen = kodeDepartemen;
        this.namaDepartemen = namaDepartemen;
        this.banyakAnggota = banyakAnggota;
    }

    @Override
    public String toString() {
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

    public int getBanyakAnggota() {
        return banyakAnggota;
    }

    public void setBanyakAnggota(int banyakAnggota) {
        this.banyakAnggota = banyakAnggota;
    }

    public void showData() {
        System.out.println("Kode Departemen : " + kodeDepartemen);
        System.out.println("Nama Departemen : " + namaDepartemen);
        System.out.println("Banyak Anggota: " + banyakAnggota);
        System.out.println("\n");
    }

}
