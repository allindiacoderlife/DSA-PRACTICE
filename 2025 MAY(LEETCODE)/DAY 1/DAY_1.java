// 2071. Maximum Number of Tasks You Can Assign
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
public class DAY_1 {
    private int[] tasks;
    private int[] workers;
    private int pills;
    private int strength;
    private int totalTask;
    private int totalWorker;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks = tasks;
        this.workers = workers;
        this.pills = pills;
        this.strength = strength;
        totalTask = tasks.length;
        totalWorker = workers.length;
        int left = 0, right = Math.min(totalTask, totalWorker);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int x) {
        int task = 0;
        Deque<Integer> Q = new ArrayDeque<>();
        int res = pills;
        for (int i = totalWorker - x; i < totalWorker; ++i) {
            while (task < x && tasks[task] <= workers[i] + strength) {
                Q.offer(tasks[task++]);
            }
            if (Q.isEmpty()) {
                return false;
            }
            if (Q.peekFirst() <= workers[i]) {
                Q.pollFirst();
            } else if (res == 0) {
                return false;
            } else {
                --res;
                Q.pollLast();
            }
        }
        return true;
    }
}
