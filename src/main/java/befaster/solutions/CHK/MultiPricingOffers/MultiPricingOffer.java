package befaster.solutions.CHK.MultiPricingOffers;

import java.util.Map;

public interface MultiPricingOffer {

    abstract void modifyBasket(Map<String,Integer> basket);
}

