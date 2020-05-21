package leetcode_210;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];  // 入度表
        int [][] edge = new int[numCourses][numCourses];   //邻阶矩阵
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            edge[prerequisite[1]][prerequisite[0]] = 1;
        }
        List<Integer> finished = new LinkedList<>();
        int[] res = new int[numCourses];
        int count = 0;
        int subject;
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0){
                finished.add(i);
                res[count] = i;
                count ++;
            }
        }
        while (!finished.isEmpty()){
            subject = finished.get(0);
            finished.remove(0);
            for (int i = 0; i < numCourses; i++) {
                if(edge[subject][i] == 1){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        finished.add(i);
                        res[count] = i;
                        count++;
                    }
                }
            }
        }
        if(count < numCourses){
            return new int[0];
        }
        return  res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOrder(2,new int[][]{{1,0},{0,1}})));
    }
}
