package befaster.solutions.CHK.SpecialOffers;

import javafx.util.Pair;
import java.util.Map;
import java.util.Vector;

public class SpecialOfferH implements SpecialOffer{
    @Override
    public Integer getReward(Map<String, Integer> basket, Map<String, Integer> prices) {
        String product="H";
        Integer quantity=basket.get(product);
        int reward=0;
        Vector<Pair<Integer,Integer>> offers=new Vector<>();
        offers.add(new Pair<>(10,80));
        offers.add(new Pair<>(5,45));

        for(int i=0;i<offers.size();i++)
        {
            reward+=quantity/offers.get(i).getKey()*offers.get(i).getValue();
            quantity-=quantity/offers.get(i).getKey()*offers.get(i).getKey();
        }
        return reward+quantity*prices.get(product);
    }
}
