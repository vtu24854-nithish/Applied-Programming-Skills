class Solution {

    public List<Integer> countSmaller(int[] nums) {

        Integer[] result = new Integer[nums.length];
        Arrays.fill(result, 0);

        List<Integer> sorted = new ArrayList<>();

        for(int i = nums.length - 1; i >= 0; i--) {

            int index = findIndex(sorted, nums[i]);

            result[i] = index;

            sorted.add(index, nums[i]);
        }

        return Arrays.asList(result);
    }

    int findIndex(List<Integer> list, int target) {

        int left = 0;
        int right = list.size();

        while(left < right) {

            int mid = left + (right - left) / 2;

            if(list.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}