package greedy;

class Solution {
    /*
     * Since it is a circular array, if we start at first index and do one pass we can find the index at which we can start.
     * If you can’t get past station i, then none of the stations between your current start and i could’ve helped, because: They all collectively couldn’t provide enough gas to make it to i+1
     * If one segment fails, all stations inside it are invalid starts, So total gas shouldn't go less than 0.
     * At each station: tank += gas[i] - cost[i].
     * If at any station, tank goes below 0, next station could be a better starting point.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0;
        int currGain= 0;
        int ans = 0;

        for(int i=0; i<gas.length;i++){
            int gain = gas[i] - cost[i];
            totalGain+=gain;
            currGain+=gain;

            if(currGain <0){
                ans = i+1;
                currGain = 0;
            }
        }

        return totalGain >= 0 ? ans : -1;
    }
}