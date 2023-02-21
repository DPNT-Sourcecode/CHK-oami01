package befaster.solutions.CHK.MultiPricingOffers;

import java.util.Map;

public class MultiPricingOfferF implements MultiPricingOffer{
    @Override
    public void modifyBasket(Map<String, Integer> basket) {
        String product="F";
        Integer quantity=basket.get(product);
        if(basket.get(product)>3)
            basket.replace("F",basket.get("F")-quantity/2);
    }
}


