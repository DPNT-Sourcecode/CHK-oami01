package befaster.solutions.CHK.MultiPricingOffers;

import java.util.Map;

public class MultiPricingOfferR implements MultiPricingOffer {
    @Override
    public Map<String, Integer> modifyBasket(Map<String, Integer> basket) {
        String product = "R";
        Integer quantity = basket.get(product);
        if (basket.get(product) >= 3 && basket.containsKey("Q")) {
            Integer newValue = basket.get("Q") - quantity / 3;
            basket.remove("Q");
            basket.put("Q", newValue);
        }

        return basket;
    }
}