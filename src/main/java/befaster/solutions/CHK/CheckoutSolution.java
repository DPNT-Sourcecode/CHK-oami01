package befaster.solutions.CHK;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

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
            String product=entry.getKey();
            Integer quantity=entry.getValue();
          if(specialOffers.containsKey(product))
            {
                Integer quantityForSpecial=specialOffers.get(product).getKey();
                Integer priceForSpecial=specialOffers.get(product).getValue();
                total+=quantity/quantityForSpecial*priceForSpecial+quantity%quantityForSpecial*prices.get(product);
            }
          else
          {
              total+=prices.get(product)*quantity;
          }
        }

        return total;

    }
}


