package CatPackage;

public class CatMain {
    public static void main(String[] args) {
        //Cats initialization
        Cat murka = new Cat("blue","Murka","Myaaaaaaaau","scottish", "female", 2, 30, 40);
        Cat gnedoi = new Cat("brown","Gnedoi", "SemkiEst?","Scottish", "male", 4, 40, 50);

        //      Lets marry gnedoi to murka
        gnedoi.fallInLove(murka);
        System.out.println("-----------------------");

        //What can he say now?
        gnedoi.makeNoise();
        System.out.println("-----------------------");

        // We have seen a cat outside. We take it home only if it has blue eyes and is not so big (height<35, length <45)
        //  What about gnedoi?
        estimateTheCat(gnedoi);

        //And what about murka?
        estimateTheCat(murka);

    }
    public static void estimateTheCat(Cat thisOne){
        if(thisOne.getEyesColor().equalsIgnoreCase("blue")&&thisOne.getHeight()<35&&thisOne.getLength()<45){
            System.out.println("What a pretty cat. Lets take it home");
            return;
        }
        System.out.println("What a monster. Get away");
    }
}
