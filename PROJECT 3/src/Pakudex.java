import java.util.Arrays;

public class Pakudex {
    private int capacity; // how many you can store
    private int size; // how many you have
    private Pakuri[] array;

    public Pakudex(){
        capacity = 20;
        array = new Pakuri[capacity];
    }
    // default Pakudex
    public Pakudex(int capacity){
        this.capacity = capacity;
        array = new Pakuri[capacity];
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return capacity;
    }
    // all the getters needed
    public String[] getSpeciesArray(){
        if (size == 0) {
            return null;
        }

        String [] speciesArray = new String[size];
        for (int i = 0; i < size; i++){
           speciesArray[i] = array[i].getSpecies();
        }
        return speciesArray;
        // return array of species ordered in Pakudex
        // if no species then null
    }
    public int[] getStats(String species){

        int [] pakuriStats = new int[3];
        int num = 0;

        if (size == 0){
            return null;
        }
        for (int i = 0; i < size; i++){
            if (species.equals(array[i].getSpecies())){
                pakuriStats[num] = array[i].getAttack();
                num++;
                pakuriStats[num] = array[i].getDefense();
                num++;
                pakuriStats[num] = array[i].getSpeed();

                // causing null point exceptions

                return pakuriStats;
            }
        // finds if a species is within the Pakudex
        // if it is, it assigns its respective attack, defense, and speed to a new array

        }
        return null;
    }
    public void sortPakuri(){
        Arrays.sort(array, 0, size);
        // sort Pakuri names based on Java standard lexicographical ordering
    }
    public boolean addPakuri(String species){
        if (size == capacity) {
            return false;
        }
        // if the array if full
        for(int i = 0; i < size; i++){
            if (array[i].getSpecies().equals(species)){
                return false;
            }
        }
        array[size] = new Pakuri(species);
        size++;
        return true;
        // add new Pakuri each time increasing the size of the array until it reaches capacity
    }
    public boolean evolveSpecies(String species){
        for (int i =0; i < size; i++){
           if (array[i].getSpecies().equals(species)){
               array[i].evolve();
               return true;
           }
        }
        // if the species is within the array it can evolve
        // otherwise returns false
        return false;
    }

    /* citations
    - issues creating Pakuri array TA Paul
    - compareTo application TA Zachary
    - fixing evolveSpecies and sortPakuri methods TA Zachary
     */

}
