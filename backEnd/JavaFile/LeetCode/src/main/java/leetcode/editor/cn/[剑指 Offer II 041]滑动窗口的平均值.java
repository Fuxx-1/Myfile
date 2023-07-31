package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class MovingAverage {

    Queue<Integer> queue = null;
    Integer sum = null;
    Integer size = null;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if (sum == null || queue == null) throw new RuntimeException("MovingAverageInitException");
        if (queue.size() == size) sum -= queue.poll();
        queue.add(val);
        sum += val;
        return (double) sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
