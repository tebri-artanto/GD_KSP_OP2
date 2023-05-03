/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Departemen;
import model.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import control.DepartemenControl;

public class StaffDAO {
    public static Connection CON;
    public static final String URL = "jdbc:mysql://";
    public static final String PATH = "localhost:3306/ksp_xxxx";

    public void makeConnection() {
        System.out.println("Opening Database.....");
        try {
            CON = DriverManager.getConnection(URL + PATH, "pbouser", "");
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Error opening");
            System.out.println(e);
        }
    }

    public void closeConnection() {
        System.out.println("Closing database...");
        try {
            CON.close();
            System.out.println("Success");

        } catch (Exception e) {
            System.out.println("Error closing database");
            System.out.println(e);
        }
    }

    public void insert(Staff s) {
        String sql = "insert into staff(noStaff, nama, jamKerja, jenisKelamin, kodeDepartemen) values('"
                + s.getNoStaff() + "','" + s.getNama() + "'," + s.getJamKerja() + ",'"
                + s.getJenisKelamin() + "', " + s.getDepartemen().getKodeDepartemen() + ")";
        System.out.println("Adding Staff...");

        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " staff \n");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Staff...");
            System.out.println(e);
        }
    }

    // possible duplicate
    public List<Staff> showStaff(String search) {
        String sql = "select * from staff s join departemen d on s.kodeDepartemen = d.kodeDepartemen "
                + "WHERE noStaff LIKE '%" + search + "%'";
        System.out.println("Mengambil data staff....");

        List<Staff> list = new ArrayList<>();

        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Departemen d = new Departemen(
                            rs.getString("d.kodeDepartemen"),
                            rs.getString("d.namaDepartemen"),
                            rs.getInt("d.banyakAnggota"));

                    Staff s = new Staff(
                            rs.getString("s.noStaff"),
                            rs.getString("s.nama"),
                            rs.getInt("s.jamKerja"),
                            rs.getString("s.jenisKelamin"),
                            d);
                    list.add(s);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        return list;
    }

    public Staff searchStaff(String noStaff) {
        String sql = "select * from staff s join departemen d on s.kodeDepartemen = d.kodeDepartemen "
                + "where noStaff = '" + noStaff + "'";
        // [!] Query berubah [!]
        System.out.println("Searching Staff...");

        Staff s = null;

        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Departemen d = new Departemen(
                            rs.getString("d.kodeDepartemen"),
                            rs.getString("d.namaDepartemen"),
                            rs.getInt("d.banyakAnggota"));

                    s = new Staff(
                            rs.getString("s.noStaff"),
                            rs.getString("s.nama"),
                            Integer.parseInt(rs.getString("s.jamKerja")),
                            rs.getString("s.jenisKelamin"),
                            d);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        return s;
    }

    public void updateStaff(Staff s, String noStaff) {
        String sql = "update staff set nama = '" + s.getNama() +
                "',jamKerja = '" + s.getJamKerja() +
                "',jenisKelamin = '" + s.getJenisKelamin() +
                "',kodeDepartemen = '" + s.getDepartemen().getKodeDepartemen() +
                "' where noStaff = '" + noStaff + "'";
        System.out.println("Editing Staff...");

        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edit " + result + "staff\n" + noStaff);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Staff...");
            System.out.println(e);
        }
    }

    public void deleteStaff(String noStaff) {
        String sql = "delete from staff where noStaff = '" + noStaff + "'";
        System.out.println("Deleting staff...");

        try {
            Statement s = CON.createStatement();
            int result = s.executeUpdate(sql);
            System.out.println("Delete " + result + " Staff\n");
            s.close();
        } catch (Exception e) {
            System.out.println("Error deleting staff...");
            System.out.println(e);
        }
    }

}
