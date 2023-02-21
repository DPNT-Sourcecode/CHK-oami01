package befaster.solutions.CHK.SpecialOffers;

import java.util.Map;

public class SpecialOfferA implements SpecialOffer{


    @Override
    public Integer getReward(Map<String, Integer> basket) {
        String product="A";
        Integer quantity=basket.get(product);
        if(quantity>=5)
        {
            return quantity/5*
        }
    }
}

