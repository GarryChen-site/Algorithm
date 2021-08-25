package leetcode.greedy.task_scheduler;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/25 20:47
 */
public class Solution {

    /**
     * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
     * Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
     *
     * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
     * that is that there must be at least n units of time between any two same tasks.
     *
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     *
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation:
     * A -> B -> idle -> A -> B -> idle -> A -> B
     * There is at least 2 units of time between any two same tasks.
     *
     * Input: tasks = ["A","A","A","B","B","B"], n = 0
     * Output: 6
     * Explanation: On this case any permutation of size 6 would work since n = 0.
     * ["A","A","A","B","B","B"]
     * ["A","B","A","B","A","B"]
     * ["B","B","B","A","A","A"]
     * ...
     * And so on.
     *
     * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * Output: 16
     * Explanation:
     * One possible solution is
     * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n)
    {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task: tasks)
        {
            counter[task - 'A']++;
            if(max == counter[task - 'A'])
            {
                maxCount++;
            }
            else if(max < counter[task - 'A'])
            {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}