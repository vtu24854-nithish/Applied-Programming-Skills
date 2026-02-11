class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n);
        long long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long long leftSum = 0;
        for (int i = 0; i < n; i++) {
            long long rightSum = totalSum - leftSum - nums[i];         
            long long leftPart = (long long)nums[i] * i - leftSum;
            long long rightPart = rightSum - (long long)nums[i] * (n - i - 1);
            result[i] = leftPart + rightPart;
            leftSum += nums[i];
        }
        return result;
    }
};
