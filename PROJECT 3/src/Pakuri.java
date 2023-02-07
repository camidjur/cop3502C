public class Pakuri implements Comparable <Pakuri>{
    private String species;
    private int attack, defense, speed;

    public Pakuri (String species){
        this.species = species;

        //Set initial values for attack, defense, and speed
        attack = (species.length() * 7) + 9;
        defense = (species.length() *5 ) + 17;
        speed = (species.length() *6) + 13;
        // initialize others
    }
    public String getSpecies(){
        return species;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getSpeed(){
        return speed;
    }
    // all the getters needed for the program
    public void setAttack(int newAttack){
        this.attack = newAttack;
    }
    public void evolve(){
        this.attack = attack*2;
        this.defense = defense*4;
        this.speed = speed*3;
    }
    @Override
    public int compareTo(Pakuri o) {
        return this.species.compareTo(o.species);
    }
    // needed in order to check whether the arrays contain a specific element
}
