package befaster.solutions.CHK.SpecialOffers;

import java.util.Map;

public class SpecialOfferE implements SpecialOffer {

    @Override
    public Integer getReward(Map<String, Integer> basket,Map<String, Integer> prices) {
        String product="E";
        Integer quantity=basket.get(product);
        basket.put("B",basket.get("B")-quantity/2);
        return quantity*prices.get(product);
    }
}
