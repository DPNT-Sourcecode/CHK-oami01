package befaster.solutions.CHK.MultiPricingOffers;


import java.util.Map;

public class MultiPricingOfferE implements MultiPricingOffer {


    @Override
    public Map<String,Integer> modifyBasket(Map<String, Integer> basket) {
        String product="E";
        Integer quantity=basket.get(product);
        if(basket.get(product)>2)
        {
            Integer newValue=basket.get("B")-quantity/2;
            basket.remove("B");
            basket.put("B",newValue);
        }
        return basket;
    }
}




