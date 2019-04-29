import model.Cell;

import java.io.*;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadCellFile {

    public static ArrayList<Cell> read(File file){
        ArrayList<Cell> cells = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(new FileInputStream(new File("c:\\Users\\Tom\\Downloads\\4g.csv")), "Cp1251"))) {


            String currentLine;


            while ((currentLine = bufferedReader.readLine()) != null) {
                Cell cell = new Cell();


                String[] data = currentLine.split(";");
                if(     data[0].equals("mcc")||
                        data[2].equals("")||
                        data[3].equals("")||
                        data[6].equals("")||
                        data[7].equals("")) continue;
                if(!data[1].equals("")){
                    cell.setMnc(Integer.parseInt(data[1]));
                }
                cell.setLac(Integer.parseInt(data[2]));
                cell.setCid(Integer.parseInt(data[3]));
                if(!data[5].equals("")){
                    cell.setLat(Float.parseFloat(data[5].replace(",", ".")));
                }
                if(!data[6].equals("")){
                    cell.setLon(Float.parseFloat(data[6].replace(",", ".")));
                }

                if(!data[7].equals("")){
                    cell.setAzimuth(Float.parseFloat(data[7].replace(",", ".")));
                }
                if(data.length>=9){
                    if(!data[8].equals(""))cell.setAdres(data[8]);
                }
                cell.setLcid();
                //System.out.println(cell);
                cells.add(cell);
            }
            return cells;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cells;
    }
}
