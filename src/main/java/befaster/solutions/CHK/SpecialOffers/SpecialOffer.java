package befaster.solutions.CHK.SpecialOffers;

import java.util.Map;

public interface SpecialOffer {


    abstract Integer getReward(Map<String, Integer> basket);

}

