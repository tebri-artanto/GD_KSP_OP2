package control;

import java.util.List;

import dao.DepartemenDAO;
import model.Departemen;
import table.TableDepartemen;

public class DepartemenControl {
    private DepartemenDAO dDAO = new DepartemenDAO();

    public void insertDataDepartemen(Departemen d) {
        dDAO.makeConnection();
        dDAO.insert(d);
        dDAO.closeConnection();
    }

    public Departemen getByKode(String kode) {
        // akan digunakan di StaffDAO untuk mengambil departemen
        Departemen d = null;
        dDAO.makeConnection();
        d = dDAO.get(kode);
        dDAO.closeConnection();

        return d;
    }

    public List<Departemen> searchDataDepartemen(String search) {
        dDAO.makeConnection();
        List<Departemen> departemenList = dDAO.search(search);
        dDAO.closeConnection();

        return departemenList;
    }

    public TableDepartemen showDataDepartemen(String search) {
        dDAO.makeConnection();
        List<Departemen> departemenList = this.searchDataDepartemen(search);
        TableDepartemen departemenData = new TableDepartemen(departemenList);
        dDAO.closeConnection();

        return departemenData;
    }

    public void updateDataDepartemen(Departemen d, String kodeDepartemen) {
        dDAO.makeConnection();
        dDAO.update(d, kodeDepartemen);
        dDAO.closeConnection();
    }

    public void deleteDataDepartemen(String kodeDepartemen) {
        dDAO.makeConnection();
        dDAO.delete(kodeDepartemen);
        dDAO.closeConnection();
    }
}
