package Stacks;

import java.util.Arrays;
import java.util.Stack;

/*
 * There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.

You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.

A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.

A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.

If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.

Return the number of car fleets that will arrive at the destination.
 */

 /*
  * Fleets are formed when a higher speed car meets a lower speed car, so 2 cars catch up when they are at the same position. If all cars start at diff position, how can they meet? 
  if the car at the prev position is moving at a faster speed to the target than the one closer to the target.
  if time taken by prev car <= current car, then they would fleet together.
  so calculate the times, sort them based on positions(Descending) and start comparing from closest to farthest. 
  */
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            double time = (double)(target - position[i]) / speed[i];  
            cars[i] = new Car(position[i], time);
        }

        Arrays.sort(cars, (a, b) -> b.position - a.position);  // sort by position descending

        Stack<Double> stack = new Stack<>();  // use Double here

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || stack.peek() < cars[i].time) {
                stack.push(cars[i].time);  // push time only if it's a new fleet
            }
        }

        return stack.size();
    }

    class Car {
        int position;
        double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}
