package nmirauta.persistenz;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class JsonWorttrainer implements PersistenzArt{
    String path;
    public JsonWorttrainer(){
        this.path ="/Users/nxti.hype/Desktop/Schule/SEW/5. Jahrgang/sew9-2324-worttrainer-NatiMirauta7/Worttrainer/src/main/java/nmirauta/worte.json";
    }

    @Override
    public int[] statistik() {
        int statistik[] = new int[2];
        try(FileReader reader = new FileReader(path)) {

            JSONTokener tokener = new JSONTokener(reader);
            JSONObject jsonObject = new JSONObject(tokener);
            statistik[0] = jsonObject.getInt("richtig");
            statistik[1] = jsonObject.getInt("falsch");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return statistik;
    }

    @Override
    public boolean speichern(int richtig, int falsch) {
        try (FileReader reader = new FileReader(path)) {
            JSONObject jsonObject = new JSONObject(reader);

            jsonObject.put("richtig", richtig);
            jsonObject.put("falsch", falsch);

            try (FileWriter writer = new FileWriter(path)) {
                writer.write(jsonObject.toString(4));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}