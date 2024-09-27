import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sum3 {
    public static void main (String[] args){
        List<List<Integer>> g=summer();
        for(List<Integer> k:g){
            System.out.println(k);
        }
    }
    public static List<List<Integer>> summer(){
        int[] nums={-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // Step 2: Iterate through each element in the sorted array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid adding duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Set two pointers, one at the element after 'i' and one at the end of the array
            int left = i + 1;
            int right = nums.length - 1;

            // Step 4: Apply the two-pointer technique to find valid triplets
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet, add it to the result list
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move left pointer to the right, skipping over duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Move right pointer to the left, skipping over duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers to the next positions after processing the current triplet
                    left++;
                    right--;
                } else if (sum < 0) {
                    // If the sum is less than 0, we need to increase the sum by moving the left pointer
                    left++;
                } else {
                    // If the sum is greater than 0, we need to decrease the sum by moving the right pointer
                    right--;
                }
            }
        }

        // Return the final list of unique triplets
        return res;
    }
}
