/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Staff;

public class TableStaff extends AbstractTableModel {
    private List<Staff> list;

    public TableStaff(List<Staff> list) {
        this.list = list;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNoStaff();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getJenisKelamin();
            case 3:
                return list.get(rowIndex).getJamKerja();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Staff";
            case 1:
                return "Nama";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "Jam Kerja";
            default:
                return null;
        }
    }
}
