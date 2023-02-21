package befaster.solutions.CHK.SpecialOffers;

import java.util.Map;

public class SpecialOfferB implements SpecialOffer{

    @Override
    public Integer getReward(Map<String, Integer> basket,Map<String, Integer> prices) {
        String product="B";
        Integer quantity=basket.get(product);
        int reward=0;
        reward=quantity/2*45;
        quantity-=quantity/2*2;
        reward+=quantity*prices.get(product);
        return reward;
    }
}
