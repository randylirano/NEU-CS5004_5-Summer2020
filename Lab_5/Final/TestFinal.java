/**
 * TestFinal
 */

public class TestFinal {
    public static void main(String[] args) {
        System.out.println(Math.PI);

        /*
        Any attempt to modify instances with final keyword will not even compile the program
        because changing immutable variable is not allowed.
        */
        // Math.PI = 5;
    }
    
}

class Test {
    private final int VAR1 = 1000;
    private int var2;

    public Test() {
        this.var2 = 0;    
    }

    // public boolean setVar1(int var1) {
    //     this.VAR1 = var1;
    //     return true;
    // }
}