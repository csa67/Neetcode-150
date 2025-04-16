package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites){
            int courseToTake = prereq[0];
            int prereqToComplete = prereq[1];

            adjList.get(prereqToComplete).add(courseToTake);
            inDegree[courseToTake]++;
        }

        Queue<Integer> courseSchedule = new LinkedList<>();
        List<Integer> finalSchedule = new ArrayList<>();

        for(int i=0; i<numCourses;i++){
            if(inDegree[i] == 0)
                courseSchedule.add(i);
        }

        int coursesDone = 0;
        while(!courseSchedule.isEmpty()){
            int currcourse = courseSchedule.poll();
            finalSchedule.add(currcourse);
            coursesDone++;

            for(int next:adjList.get(currcourse)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    courseSchedule.add(next);
                }
            }
        }


     return coursesDone == numCourses 
    ? finalSchedule.stream().mapToInt(i -> i).toArray() 
    : new int[0];

    }
}
