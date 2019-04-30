package dao;

import dao.service.ConnectionDB;
import model.Cell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CellDAO {
    public static void insertCells(ArrayList<Cell> cells){
        String sql = "INSERT INTO [dbo].[stations] ([lcid],[lac],[cid],[mnc],[lat],[lon],[azimuth],[adres],[Shape])\n" +
                "VALUES(?,?,?,?,?,?,?,?,geometry::STGeomFromText(?, 4326))";
//'Point (20 180)'
        int counter=0;
        for (Cell cell:cells) {
            try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
                preparedStatement.setLong(1,cell.getLcid());
                preparedStatement.setInt(2,cell.getLac());
                preparedStatement.setInt(3,cell.getCid());
                preparedStatement.setInt(4,cell.getMnc());
                preparedStatement.setDouble(5,cell.getLat());
                preparedStatement.setDouble(6,cell.getLon());
                preparedStatement.setDouble(7,cell.getAzimuth());
                preparedStatement.setString(8,cell.getAdres());
                preparedStatement.setString(9,"Point ("+cell.getLon()+" "+cell.getLat()+")");

                preparedStatement.execute();
                //preparedStatement.addBatch();
                counter++;
                if (counter % 1000 == 0 || counter == cells.size()) {
                    //preparedStatement.executeBatch(); // Execute every 1000 items.
                    System.out.println(counter);
                    Thread.currentThread().sleep(30000);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
