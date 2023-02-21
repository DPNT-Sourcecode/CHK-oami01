package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Stream;

import static jdk.nashorn.internal.runtime.JSType.toInteger;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        Map<String, Integer> prices= (Map<String, Integer>) Stream.of(
                new AbstractMap.SimpleEntry<String,Integer>("A",50) ,
                new AbstractMap.SimpleEntry<String,Integer>("B",30),
                new AbstractMap.SimpleEntry<String,Integer>("C",20),
                new AbstractMap.SimpleEntry<String,Integer>("D",15)
        );

        Map<String, Integer> specialOffers= (Map<String, Integer>) Stream.of(
                new AbstractMap.SimpleEntry<String,Integer>("3A",130) ,
                new AbstractMap.SimpleEntry<String,Integer>("2B",45)
        );

        if(specialOffers.containsKey(skus))
            return specialOffers.get(skus);
        else {
            return (skus.charAt(0))*prices.get(skus.charAt(1));
        }

    }
}



