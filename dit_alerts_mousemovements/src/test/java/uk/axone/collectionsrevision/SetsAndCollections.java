package uk.axone.collectionsrevision;

import org.testng.annotations.Test;

import java.util.*;

public class SetsAndCollections {
    @Test
    public void testCollections(){

        String[] fruitsSet = new String[]{"apple", "orange", "beets", "melons"};

        Set<String> fruits = new HashSet<String>(Arrays.asList(fruitsSet));
        Iterator<String> itr = fruits.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        List<String> fruitslist = new ArrayList<>(Arrays.asList(fruitsSet));
        Iterator<String> itr1 = fruitslist.iterator();
        while (itr1.hasNext()){
            System.out.println(itr1.next());
        }

        Collections.sort(fruitslist);
        System.out.println("sorted list " + fruitslist);



    }
}
