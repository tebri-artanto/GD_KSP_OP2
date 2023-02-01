package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Departemen;

public class DepartemenDAO {
    public static Connection CON;
    public static final String URL = "jdbc:mysql://";
    public static final String PATH = "localhost:3306/ksp_xxxx";

    public void makeConnection() {
        System.out.println("Opening Database.....");
        try {
            CON = DriverManager.getConnection(URL + PATH, "root", "");
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

    // Di DAO ini, kita akan menggunakan Prepared Statement untuk menghindari SQL
    // Injection

    public void insert(Departemen D) {
        String sql = "INSERT INTO departemen (kodeDepartemen, namaDepartemen, banyakAnggota) VALUES (?, ?, ?)";
        System.out.println("Adding Departemen...");

        try {
            PreparedStatement statement = CON.prepareStatement(sql);

            // Prepared Statement: Menghindari SQL Injection
            statement.setString(1, D.getKodeDepartemen());
            statement.setString(2, D.getNamaDepartemen());
            statement.setInt(3, D.getBanyakAnggota());

            int result = statement.executeUpdate();
            System.out.println("Added" + result + "departemen \n");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Departemen...");
            System.out.println(e);
        }
    }

    public Departemen get(String kode) {
        String sql = "SELECT * FROM departemen WHERE kodeDepartemen = ?";
        System.out.println("Getting Departemen...");

        Departemen D = null;
        try {
            PreparedStatement statement = CON.prepareStatement(sql);

            // Prepared Statement
            statement.setString(1, kode);

            ResultSet result = statement.executeQuery();

            if (result != null) {
                while (result.next()) {
                    D = new Departemen(
                            result.getString("kodeDepartemen"),
                            result.getString("namaDepartemen"),
                            result.getInt("banyakAnggota"));
                }
                result.close();
            }
            statement.close();
        } catch (Exception e) {
            System.out.println("Error getting Departemen...");
            System.out.println(e);
        }
        return D;
    }

    public List<Departemen> search(String query) {
        String sql = "SELECT * FROM departemen WHERE kodeDepartemen LIKE ? OR namaDepartemen LIKE ?";
        System.out.println("Searching Departemen...");

        ArrayList<Departemen> listDepartemen = new ArrayList<Departemen>();
        try {
            PreparedStatement statement = CON.prepareStatement(sql);

            // Prepared Statement
            statement.setString(1, "%" + query + "%");
            statement.setString(2, "%" + query + "%");

            ResultSet result = statement.executeQuery();

            if (result != null) {
                while (result.next()) {
                    Departemen D = new Departemen(
                            result.getString("kodeDepartemen"),
                            result.getString("namaDepartemen"),
                            result.getInt("banyakAnggota"));
                    listDepartemen.add(D);
                }
                result.close();
            }
            statement.close();
        } catch (Exception e) {
            System.out.println("Error searching Departemen...");
            System.out.println(e);
        }
        return listDepartemen;
    }

    public void update(Departemen D, String kodeDepartemen) {
        String sql = "UPDATE departemen SET namaDepartemen = ?, banyakAnggota = ? WHERE kodeDepartemen = ?";
        System.out.println("Updating Departemen...");

        try {
            PreparedStatement statement = CON.prepareStatement(sql);

            // Prepared Statement
            statement.setString(1, D.getNamaDepartemen());
            statement.setInt(2, D.getBanyakAnggota());
            statement.setString(3, kodeDepartemen);

            int result = statement.executeUpdate();
            System.out.println("Updated" + result + "departemen \n");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating Departemen...");
            System.out.println(e);
        }
    }

    public void delete(String kodeDepartemen) {
        String sql = "DELETE FROM departemen WHERE kodeDepartemen = ?";
        System.out.println("Deleting Departemen...");

        try {
            PreparedStatement statement = CON.prepareStatement(sql);

            // Prepared Statement
            statement.setString(1, kodeDepartemen);

            int result = statement.executeUpdate();
            System.out.println("Deleted" + result + "departemen \n");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Departemen...");
            System.out.println(e);
        }
    }
}
