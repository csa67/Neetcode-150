package Queues;

/*
 * You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.
 */
class Solution {
    /*
     * Since each task cannot be repeated in n-space, maximum would be maxfreq * n.
     * but other tasks could be done in the remaining time.
     * 
     * part count = How many gaps between the max tasks
     * part length = How many slots we need to fill between max tasks.
     * 
     * if there are more than 1 elements with maxcount - then there are fewer gaps to fill → because more can go together.
     * 
     * empty slots would be total idle spots to fill.
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;

        for(char task:tasks){
            counter[task-'A']++;
            if(max == counter[task-'A']){
                maxCount++;
            }else if(max < counter[task-'A']){
                max = counter[task-'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n-(maxCount-1);
        int emptySlots = partCount * partLength;

        int remtasks = tasks.length - max * maxCount;
        int idles=Math.max(0,emptySlots-remtasks);

        return tasks.length+idles;
    }
}