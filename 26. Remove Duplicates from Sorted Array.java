//My solution 
class Solution 
{
    public int removeDuplicates(int[] nums)
    {
        int count =0, prev=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]!=nums[i]) 
            { 
                nums[prev]=nums[i];
                prev ++;
            }
        }
        return prev;
    }
}

// optimum solution
class Solution
{
    public int removeDuplicates(int[] nums)
    {
        int j = 1; 
        for (int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] != nums[i+1])
            {
                nums[j++] = nums[i+1];
            }
        }
        return j;
    }
}
