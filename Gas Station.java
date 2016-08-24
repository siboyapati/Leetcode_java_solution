public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        def canCompleteCircuit(self, gas, cost):
            if sum(gas)<sum(cost):
                return -1
            left_gas=0
            start_index=0
            for i in range(len(gas)):
                if left_gas<0:
                    left_gas=gas[i]-cost[i]
                    start_index=i
                else:
                    left_gas+=gas[i]-cost[i]
            return start_index
        */
        int totalLeftGas = 0;
        int leftGas = 0;
        int startIndex = 0;
        for(int i=0; i<gas.length; i++) {
            totalLeftGas += gas[i]-cost[i];
            if(leftGas<0) {
                leftGas=gas[i]-cost[i];
                startIndex= i;
            } else {
                leftGas += gas[i]-cost[i];
            }
        }
        return totalLeftGas<0?-1:startIndex;
    }
}
