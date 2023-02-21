package befaster.solutions.CHK.SpecialOffers;

import java.util.Map;

public class SpecialOfferA implements SpecialOffer{


    @Override
    public Integer getReward(Map<String, Integer> basket,Map<String, Integer> prices) {
        String product="A";
        Integer quantity=basket.get(product);
        int reward=0;
        reward+=quantity/5*200;
        quantity-=quantity/5*5;
        reward+=quantity/3*130;
        quantity-=quantity/3*3;
        reward+=quantity*prices.get(product);
        return reward;
    }


}
