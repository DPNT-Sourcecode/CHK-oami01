package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import javafx.util.Pair;

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

        Map<String,Pair<Integer,Integer>> specialOffers = new HashMap<>();
        specialOffers.put("A",new Pair<>(3,130));
        specialOffers.put("B",new Pair<>(2,45));

        Map<String, Integer> basket = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            String currentProduct = String.valueOf(skus.charAt(i));
            if (prices.containsKey(currentProduct) == false) {
                return -1;
            }

            if (basket.containsKey(currentProduct)) {
                basket.replace(currentProduct, basket.get(currentProduct) + 1);
            } else {
                basket.put(currentProduct, 1);
            }
        }

        int total = 0;
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
          if(specialOffers.containsKey(entry.getKey()))
            {
                if(specialOffers.get(entry.getKey()).)
            }
        }

        return total;

    }
}

