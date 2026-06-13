class Solution {
    public int findNumbers(int[] nums) {
        
        int count = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			
			int digits = 0;
			int num = nums[i];
			
			if(num == 0)  digits = 1;
			else {
				while(num > 0) {
					digits++;
					num /= 10;
				}
				
			}
			
			if(digits % 2 == 0) count++;
			
		}	
		
		return count;
    }
}




// Not a general Solution
// class Solution {
//     public int findNumbers(int[] nums) {
//         int ans = 0;
//         for(int num : nums)  {
//             if((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || (num == 100000)) ans++;
//             else continue;
//         }
//         return ans;
//     }
// }
