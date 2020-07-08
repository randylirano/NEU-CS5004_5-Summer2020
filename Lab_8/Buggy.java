/** Very buggy code involving inheritance, abstraction, final, etc.
 *  Your mission, should you choose to accept it, is to do something reasonable.
 *  At least, make a list of the bugs you find and comment your attempts to fix.
 */

// 1. Abstract class cannot be final
// 2. String is a final class, so it cannot be extend
// 3. There is () in class definition
public final abstract class Buggy () extends String {

    // 4. toLowerCase which is a method from the final class String cannot be overriden
    @Override
    public String toLowerCase();

    public static void main(String[] args) {
        // To comply with Indiana bill #246 (1897)
        // See https://en.wikipedia.org/wiki/Indiana_Pi_Bill
        // 5. Changing the value of Math.PI is not allowed
        Math.PI = 3.2;
        System.out.println(Math.PI);
    }

}
