package leet.code;

/*Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
 and you may not use the same element twice.

You can return the answer in any order.*/
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {

		int[] index = new int[2];
		int sum;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					sum = nums[i] + nums[j];
					if (target == sum) {
						index[0] = i;
						index[1] = j;						
						break;
					}
				}
			}
		}
		return index;

	}
	
	
	public static void main(String args[]) {
		int[] index = twoSum(new int[] {3,2,4}, 6);
		System.out.println(index[0]);
		System.out.println(index[1]);
	}
}
