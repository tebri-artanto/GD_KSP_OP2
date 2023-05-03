package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Departemen;

public class TableDepartemen extends AbstractTableModel {
    private List<Departemen> list;

    public TableDepartemen(List<Departemen> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKodeDepartemen();
            case 1:
                return list.get(rowIndex).getNamaDepartemen();
            case 2:
                return list.get(rowIndex).getBanyakAnggota();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Departemen";
            case 1:
                return "Nama Departemen";
            case 2:
                return "Banyak Anggota";
            default:
                return null;
        }
    }
}
