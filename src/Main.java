import dao.CellDAO;
import dao.service.ConnectionDB;
import javafx.scene.control.Cell;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //ConnectionDB.getConnection();
        CellDAO.insertCells(ReadCellFile.read(new File("c:\\Users\\Tom\\Downloads\\4g.csv")));
    }
}
