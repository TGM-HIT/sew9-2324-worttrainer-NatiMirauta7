package nmirauta.persistenz;

public interface PersistenzArt {
    int[] statistik();
    boolean speichern(int richtig, int falsch);
}