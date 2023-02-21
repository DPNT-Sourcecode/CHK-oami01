package befaster.solutions.CHK.MultiPricingOffers;

import java.util.Map;

public class MultiPricingOfferN implements MultiPricingOffer{
    @Override
    public Map<String, Integer> modifyBasket(Map<String, Integer> basket) {
        String product="N";
        Integer quantity=basket.get(product);
        if(basket.get(product)>=3&&basket.containsKey("M"))
        {
            Integer newValue=basket.get("M")-quantity/3;
            basket.remove("M");
            basket.put("M",newValue);
        }
        return basket;
    }
}
