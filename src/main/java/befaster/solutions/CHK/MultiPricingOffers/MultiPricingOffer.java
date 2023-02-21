package befaster.solutions.CHK.MultiPricingOffers;

import java.util.Map;

public interface MultiPricingOffer {

    abstract Map<String,Integer> modifyBasket(Map<String,Integer> basket);
}


