package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static jdk.nashorn.internal.runtime.JSType.toInteger;

public class CheckoutSolution {
    public static Integer checkout(String skus) {

        Map<String, Integer> prices = new HashMap<>();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);
        prices.put("", 0);

        Map<String, Integer> specialOffers = new HashMap<>();
        specialOffers.put("3A", 130);
        specialOffers.put("2B", 45);

        Map<String,Integer> basket=new HashMap<>();

        for(int i=0;i<skus.length();i++)
        {
            if(prices.containsKey(skus.charAt(i))==false)
            {
                return -1;
            }

            if(basket.containsKey(skus.charAt(i)))
            {
                basket.put("");
            }
        }

    }

}





