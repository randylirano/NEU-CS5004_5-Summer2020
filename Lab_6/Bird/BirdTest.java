package Bird;

/**
 * BirdTest.java
 */

/**
 * CS5005 Lab 6: Problem 0 to 6 - Bird Class and Its Subclasses.
 * This class test programmer-defined bird objects.
 *
 * @author Randy Lirano
 * @since 2020-06-18
 */

public class BirdTest {

    public static void main(String[] args) {
        // Test Constructor
        Bird b = new Bird();
        // System.out.println("Bird Info: " + b);
        // System.out.println("Number of Wings: " + b.getNumWings());
        // System.out.println();

        // Test Setter
        // b.setColor("Black");
        // String[] newFoodType = {"small mammals", "snails", "invertebrate larvae"};
        // b.setFoodTypes(newFoodType);
        // System.out.println("Bird Info: " + b);

        // Test Moa Subclass
        Moa m = new Moa();
        // System.out.println("Bird Info: " + m);
        // System.out.println("Number of Wings: " + m.getNumWings());
        // String[] newFoodType = {"small mammals", "snails", "invertebrate larvae"};
        // m.setFoodTypes(newFoodType);
        // System.out.println("Bird Info: " + m);

        // Test TalkingBird Subclass
        TalkingBird tb = new TalkingBird();
        // System.out.println("Bird Info: " + tb);

        // Test Mynah Subclass
        Mynah my = new Mynah();
        // System.out.println("Bird Info: " + my);

        // Test Falcon Subclass
        PereGrineFalcon falcon = new PereGrineFalcon();
        // System.out.println("Bird Info: " + falcon);

        Bird[] arr = new Bird[5];
        arr[0] = b;
        arr[1] = m;
        arr[2] = tb;
        arr[3] = my;
        arr[4] = falcon;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

/**
 * Programmer-defined bird object
 */
class Bird {
    // Class instances
    private double wingSpan;
    private String color;
    private String[] foodTypes = new String[7];

    private final int NUM_WINGS = 2;
    public final static String[] allFoods = {"berries", "nectar", "seeds", "nuts", "small mammals", "snails", "invertebrate larvae"};

    // Default no arguments constructor
    public Bird() {
        setWingSpan(2.0);
        setColor("Blue");
        setFoodTypes(new String[] {Bird.allFoods[0]});
    }

    // Getters
    public double getWingSpan() {
        return this.wingSpan;
    }

    public String getColor() {
        return this.color;
    }

    public String[] getFoodTypes() {
        String[] foodTypes = new String[this.foodTypes.length];
        for (int i = 0; i < foodTypes.length; i++) {
            foodTypes[i] = this.foodTypes[i];
        }
        return foodTypes;
    }

    public int getNumWings() {
        return this.NUM_WINGS;
    }

    // Setters
    public void setWingSpan(double wingSpan) {
        boolean validWingSpan = checkWingSpan(wingSpan);
        if (validWingSpan) {
            this.wingSpan = wingSpan;
        }
    }

    private boolean checkWingSpan(double wingSpan) {
        if (wingSpan > 0.0) {
            return true;
        }
        return false;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFoodTypes(String[] foodTypes) {
        // Check if the given foodTypes contains any invalid food
        // invalid food is food that is not in the allFoods array
        boolean validFoodType = checkFoodTypes(foodTypes);

        if (validFoodType) {
            for (int i = 0; i < foodTypes.length; i++) {
                this.foodTypes[i] = foodTypes[i];
            }
        }
    }

    private boolean checkFoodTypes(String[] foodTypes) {
        boolean validFood = true;
        for (String food: foodTypes) {
            validFood = checkFood(food);
            if (validFood == false) {
                return validFood;
            }
        }
        return true;
    }

    private boolean checkFood(String food) {
        for (String item : allFoods) {
            if (item.equalsIgnoreCase(food)) {
                return true;
            }
        }
        return false;
    }

    // toString
    public String toString() {
        String birdFood = "";
        for (String food : getFoodTypes()) {
            birdFood = birdFood + " | " + food;
        }
        return "Wing Span: " + getWingSpan() + ", Color: " + getColor() + ", Food Types: " + birdFood;
    }

    // equal
    public boolean equals(Bird other) {
        return (this.wingSpan == other.wingSpan) && (this.color.equalsIgnoreCase(other.color)) && (this.foodTypes.equals(other.foodTypes));
    }
}

/**
 * Programmer-defined Moa class.
 * This is a subclass of the pre-defined Bird class
 */
class Moa extends Bird {
    public Moa() {
        super();
        
    }

    @Override
    public int getNumWings() {
        return 0;
    }

    @Override
    public void setWingSpan(double wingSpan) {
        System.out.println("Cannot set wing span, Moa has no wing");
    }

    @Override
    public double getWingSpan() {
        return 0.0;
    }
}

/**
 * Programmer-defined TalkingBird class.
 * This is a subclass of the pre-defined Bird class
 */
class TalkingBird extends Bird {
    // Subclass instance for the number of phrase / words in its vocabulary
    private int vocab;

    public TalkingBird() {
        super();
        setVocab(1);
    }

    // Getter method
    public int getVocab() {
        return this.vocab;
    }

    // Setter method
    public void setVocab(int vocab) {
        if (checkVocab(vocab)) {
            this.vocab = vocab;
        } else {
            System.out.println("ERROR: Invalid Number of Vocab");
        }
    }

    private boolean checkVocab(int vocab) {
        if (vocab > 0 && vocab < 100) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", vocab: " + getVocab();
    }
}

class Mynah extends TalkingBird {
    public Mynah() {
        super();
        setFoodTypes(Bird.allFoods);
    }
}

class Parrot extends TalkingBird {
    private final String greeting = "Hello";
    
    public Parrot() {
        super();
        setFoodTypes(Bird.allFoods);
    }

    public String getGreeting() {
        return this.greeting;
    }

    @Override
    public String toString() {
        return super.toString() + ", Favorite Greeting: " + getGreeting();
    }
}

class PereGrineFalcon extends Bird {
    private int topSpeed = 240;

    public PereGrineFalcon() {
        setWingSpan(4.0);
        setColor("Brown");
        setFoodTypes(new String[] {Bird.allFoods[4]});
    }

    public int getTopSpeed() {
        return this.topSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", Hunting Dive Speed: " + getTopSpeed();
    }
}