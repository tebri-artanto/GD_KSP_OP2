/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import dao.StaffDAO;
import model.Staff;
import table.TableStaff;

public class StaffControl {

    private StaffDAO sDAO = new StaffDAO();

    public void insertDataStaff(Staff s) {
        sDAO.makeConnection();
        sDAO.insert(s);
        sDAO.closeConnection();
    }

    public String showDataStaff() {
        sDAO.makeConnection();
        List<Staff> staffData = sDAO.showStaff("");
        sDAO.closeConnection();

        String staffString = "";
        for (int i = 0; i < staffData.size(); i++) {
            staffString = staffString + staffData.get(i).showDataKaryawan()
                    + " | ";

        }
        return staffString;
    }

    public Staff searchStaff(String noStaff) {
        Staff s = null;
        sDAO.makeConnection();
        s = sDAO.searchStaff(noStaff);
        sDAO.closeConnection();

        return s;

    }

    public void updateDataStaff(Staff s, String noStaff) {
        sDAO.makeConnection();
        sDAO.updateStaff(s, noStaff);
        sDAO.closeConnection();
    }

    public void deleteDataStaff(String noStaff) {
        sDAO.makeConnection();
        sDAO.deleteStaff(noStaff);
        sDAO.closeConnection();
    }

    // di versi lama, ada showTable di sini, tapi tidak digunakan

    public Staff searchTableStaff(String noStaff) {
        sDAO.makeConnection();
        Staff s = sDAO.searchStaff(noStaff);
        sDAO.closeConnection();

        return s;

    }
    public TableStaff showTableStaff(String search) {
        sDAO.makeConnection();
        List<Staff> staffList = sDAO.showStaff(search);
        TableStaff tableStaff = new TableStaff(staffList);
        sDAO.closeConnection();
        return tableStaff;
    }

}