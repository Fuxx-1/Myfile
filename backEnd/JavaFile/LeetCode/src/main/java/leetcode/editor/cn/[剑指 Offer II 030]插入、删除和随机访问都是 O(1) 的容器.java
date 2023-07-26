package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> map;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        int index = nums.size();
        nums.add(val);
        map.put(val, index);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        map.put(last, index);
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
