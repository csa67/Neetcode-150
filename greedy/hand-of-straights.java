package greedy;

import java.util.HashMap;

class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // HashMap to store the count of each card value
        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            int count = cardCount.getOrDefault(card, 0);
            cardCount.put(card, count + 1);
        }

        for(int card:hand){
            int start = card;
            while(cardCount.getOrDefault(start-1, 0) > 0){
                start--; //helps figure out where the seq is starting
            }

            while(start <= card){
                while(cardCount.getOrDefault(start, 0) > 0){

                    for(int next = start;next<start+groupSize;next++){
                    
                        if (cardCount.getOrDefault(next, 0) == 0) {
                            return false;
                        }
                        
                        int count = cardCount.get(next);
                        if(count == 1) cardCount.remove(next);
                        else cardCount.put(next, count);
                    }

                    start++;
                }
            }
        }

        return true;

    }
}
