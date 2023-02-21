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

        Map<String, Integer> specialOffers = new HashMap<>();
        specialOffers.put("3A", 130);
        specialOffers.put("2B", 45);

        if (specialOffers.containsKey(skus))
            return specialOffers.get(skus);
        else {
            int pricePerProduct=prices.get(String.valueOf(skus.charAt(skus.length()-1)));
            if(skus.length()>1)
            {
                skus=skus.substring(0,skus.length()-1);
                return Integer.parseInt(skus)*pricePerProduct;
            }
            else{
                return pricePerProduct;
            }

        }

    }
}
