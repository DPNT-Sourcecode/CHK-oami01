package befaster.solutions.CHK;

import befaster.solutions.CHK.MultiPricingOffers.*;



import befaster.solutions.CHK.SpecialOffers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
//La CHK_R4 mi-am dat seama ca nu trebuie sa o fac interfata si sa am implementare in functie de un Map pentru fiecare oferta

public class CheckoutSolution {
    public static Integer checkout(String skus) {

        Map<String, Integer> prices = new HashMap<>();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);
        prices.put("E",40);
        prices.put("F",10);
        prices.put("G",20);
        prices.put("H",10);
        prices.put("I",35);
        prices.put("J",60);
        prices.put("K",70);
        prices.put("L",90);
        prices.put("M",15);
        prices.put("N",40);
        prices.put("O",10);
        prices.put("P",50);
        prices.put("Q",30);
        prices.put("R",50);
        prices.put("S",20);
        prices.put("T",20);
        prices.put("U",40);
        prices.put("V",50);
        prices.put("W",20);
        prices.put("X",17);
        prices.put("Y",10);
        prices.put("Z",50);
        prices.put("", 0);

        Map<String, SpecialOffer> specialOffers = new HashMap<>();
        specialOffers.put("A",new SpecialOfferA());
        specialOffers.put("B",new SpecialOfferB());
        specialOffers.put("E",new SpecialOfferE());
        specialOffers.put("K",new SpecialOfferK());
        specialOffers.put("P",new SpecialOfferP());
        specialOffers.put("Q",new SpecialOfferQ());
        specialOffers.put("V",new SpecialOfferV());
        specialOffers.put("H",new SpecialOfferH());


       Map<String, MultiPricingOffer> multiPricingOffer=new HashMap<>();
       multiPricingOffer.put("E",new MultiPricingOfferE());
       multiPricingOffer.put("F",new MultiPricingOfferF());
       multiPricingOffer.put("N",new MultiPricingOfferN());
       multiPricingOffer.put("R",new MultiPricingOfferR());
       multiPricingOffer.put("U",new MultiPricingOfferU());

        String[] groupOffer= new String[]{"S", "T", "X", "Y", "Z"};

        Map<String, Integer> basket = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            String currentProduct = String.valueOf(skus.charAt(i));
            if (prices.containsKey(currentProduct) == false) {
                return -1;
            }

            if (basket.containsKey(currentProduct)) {
                basket.replace(currentProduct, basket.get(currentProduct) + 1);
            } else {
                basket.put(currentProduct, 1);
            }
        }

        int total = 0;

        for(Map.Entry<String, MultiPricingOffer> entry:multiPricingOffer.entrySet())
        {
            String product=entry.getKey();
            if(basket.containsKey(product)) {
                basket=entry.getValue().modifyBasket(basket);
            }
        }

        Vector<String> groupOfThree = new Vector<>();
        for(int i=0;i<groupOffer.length;i++)
        {
           if(basket.containsKey(groupOffer[i]))
           {
               groupOfThree.add(groupOffer[i]);
           }
           if(groupOfThree.size()==3)
           {
               for(int j=0;j<3;j++)
                   basket.replace(groupOfThree.get(j),basket.get(groupOfThree.get(j))-1);
               total+=45;
               i=0;
               groupOfThree.removeAllElements();
           }
        }


        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
           String product=entry.getKey();
           Integer quantity=entry.getValue();
           if(specialOffers.containsKey(product))
           {
               total+=specialOffers.get(product).getReward(basket,prices);
           }
           else
           {
               total+=prices.get(product)*quantity;
           }

        }

        return total;

    }
}



