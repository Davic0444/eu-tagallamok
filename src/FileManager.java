import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileManager {

    List<Entity> states = new ArrayList<Entity>();

    public List<Entity> fileReader(String fileName){

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            while (br.ready()){
                String row = br.readLine();
                String[] rowData = row.split(";");

                Entity newEntityObj = new Entity(
                        rowData[0],
                        LocalDate.parse(rowData[1], DateTimeFormatter.ofPattern("yyyy.MM.dd")));
                states.add(newEntityObj);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return states;
    }


}
