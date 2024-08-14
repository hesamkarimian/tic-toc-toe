import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hesam.karimian
 * @created 21/06/2024
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list1=new ArrayList<String>();
        list1.add("Mango");
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Grapes");

        Collections.sort(list1);
    }
}
