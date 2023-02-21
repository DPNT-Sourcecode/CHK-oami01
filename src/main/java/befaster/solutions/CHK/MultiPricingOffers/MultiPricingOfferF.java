package befaster.solutions.CHK.MultiPricingOffers;

import java.util.Map;

public class MultiPricingOfferF implements MultiPricingOffer{
    @Override
    public Map<String,Integer> modifyBasket(Map<String, Integer> basket) {
        String product="F";
        Integer quantity=basket.get(product);
        if(basket.get(product)>3) {
            Integer newValue=basket.get("F")-quantity/2;
            basket.remove("F");
            basket.put("F",newValue);
        }
        return basket;
    }
}




