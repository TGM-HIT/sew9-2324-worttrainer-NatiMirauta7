import nmirauta.model.WortEintrag;
import nmirauta.persistenz.JsonWorttrainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Tests {
    @Test
    public void urlCheck(){
        WortEintrag w = new WortEintrag("Katze", "https://cdn-icons-png.flaticon.com/256/2138/2138218.png");
        Assertions.assertTrue(w.setUrl("https://cdn-icons-png.flaticon.com/256/2138/2138218.png"));
        Assertions.assertFalse(w.setUrl("fhafaf"));
    }
    @Test
    public void wortCheck(){
        WortEintrag w = new WortEintrag("Katze", "https://cdn-icons-png.flaticon.com/256/2138/2138218.png");
        Assertions.assertTrue(w.setWort("Hund"));
        Assertions.assertFalse(w.setUrl("1"));
    }
    @Test
    public void speichernCheck(){
        JsonWorttrainer w = new JsonWorttrainer();
        //Assertions.assertTrue(w.speichern(1,2));
    }


}
