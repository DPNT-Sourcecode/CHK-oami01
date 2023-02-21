package befaster.solutions.CHK;

import befaster.solutions.CHK.MultiPricingOffers.MultiPricingOffer;
import befaster.solutions.CHK.MultiPricingOffers.MultiPricingOfferE;
import befaster.solutions.CHK.MultiPricingOffers.MultiPricingOfferF;
import befaster.solutions.CHK.SpecialOffers.SpecialOffer;
import befaster.solutions.CHK.SpecialOffers.SpecialOfferA;
import befaster.solutions.CHK.SpecialOffers.SpecialOfferB;

import java.util.HashMap;
import java.util.Map;


public class CheckoutSolution {
    public static Integer checkout(String skus) {

        Map<String, Integer> prices = new HashMap<>();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);
        prices.put("E",40);
        prices.put("F",10);
        prices.put("", 0);

        Map<String, SpecialOffer> specialOffers = new HashMap<>();
        specialOffers.put("A",new SpecialOfferA());
        specialOffers.put("B",new SpecialOfferB());

       Map<String, MultiPricingOffer> multiPricingOffer=new HashMap<>();
       multiPricingOffer.put("E",new MultiPricingOfferE());
       multiPricingOffer.put("F",new MultiPricingOfferF());

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

        for(Map.Entry<String, MultiPricingOffer> entry:multiPricingOffer.entrySet())
        {
            String product=entry.getKey();
            if(basket.containsKey(product)) {
                basket=entry.getValue().modifyBasket(basket);
            }
        }




        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
           String product=entry.getKey();
           Integer quantity=entry.getValue();
           if(specialOffers.containsKey(product))
           {
               total+=specialOffers.get(product).getReward(basket,prices);
           }
           else
           {
               total+=prices.get(product)*quantity;
           }

        }

        return total;

    }
}




