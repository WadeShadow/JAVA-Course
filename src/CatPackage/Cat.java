package CatPackage;

import java.util.Random;

public class Cat {
    private String eyesColor;
    private String name;
    private String personalVoice;   //A phrase, inherent only to this kind of cat
    private String breed;               //Variety of cats that this one belongs to
    private String gender;
    private int irritabilityLevel; // 0 corresponds to a very patient and cute animal, 5 - to a very angry and hateful
    private double height;      //measured in centimeters
    private double length;      //also in centimeters



    public Cat(String eyesColor, String name, String personalVoice, String bread, String gender, int irritabilityLevel, double height, double length) {
        this.eyesColor = eyesColor;
        this.name = name;
        this.personalVoice = personalVoice;
        this.breed = bread;
        this.gender = gender;
        this.irritabilityLevel = irritabilityLevel;
        this.height = height;
        this.length = length;
    }

    public void makeNoise() {
        if (irritabilityLevel == 5) {
            System.out.println(personalVoice.toUpperCase());
            System.out.println(personalVoice.toUpperCase());
            System.out.println(personalVoice.toUpperCase());
            return;
        }
        System.out.println(personalVoice);
    }

    public void jump() {         // Cats can jump for a 1-4 meters
        System.out.println("Jump for a " + (new Random().nextInt(3) + 1) + "meters");
    }

    public void fallInLove(Cat otherCat) {
        if (this.breed.equalsIgnoreCase(otherCat.breed)&&!this.gender.equalsIgnoreCase(otherCat.gender)) {
            irritabilityLevel = 5;
            System.out.println("Nice cat has been detected. Irritability level of " + this.name +" has changed to 'Angry'");
            return;
        }
        System.out.println("Not my cup of tea");
    }       //Fall in love only when different breeds and genders

    public void askForName(String humanSpeech) {
        if (humanSpeech.equals(name)) {
            System.out.println("Yeeeeeeeees?");
            return;
        }
        System.out.println(personalVoice);
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public String getName() {
        return name;
    }
}
