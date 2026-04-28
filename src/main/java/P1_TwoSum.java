import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**

Given an array of integers nums and an integer target, return indices
of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.

*/

public class P1_TwoSum {

    //method 1
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    //method 2
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args){

        P1_TwoSum solution = new P1_TwoSum();
        int[] answer = solution.twoSum2(new int[]{3,7,3,4}, 6);
        System.out.println(Arrays.toString(answer));
    }

}
