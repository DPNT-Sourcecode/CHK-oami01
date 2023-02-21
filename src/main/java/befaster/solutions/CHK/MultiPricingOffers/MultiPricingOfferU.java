package befaster.solutions.CHK.MultiPricingOffers;

import java.util.Map;

public class MultiPricingOfferU implements MultiPricingOffer {
    @Override
    public Map<String, Integer> modifyBasket(Map<String, Integer> basket) {
        String product="U";
        Integer quantity=basket.get(product);
        if(basket.get(product)>=4)
        {
            Integer newValue=basket.get("B")-quantity/4;
            basket.remove("B");
            basket.put("B",newValue);
        }
        return basket;
    }
}

