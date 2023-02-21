package befaster.solutions.CHK.MultiPricingOffers;


import java.util.Map;

public class MultiPricingOfferE implements MultiPricingOffer {


    @Override
    public void modifyBasket(Map<String, Integer> basket) {
        String product="E";
        Integer quantity=basket.get(product);
        if(basket.get(product)>2)
           basket.replace("B",basket.get("B")-quantity/2);
    }
}


