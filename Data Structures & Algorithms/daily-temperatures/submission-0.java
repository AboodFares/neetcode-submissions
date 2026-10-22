class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int today = 0; today < temperatures.length; today++) {
            
            while(!stack.isEmpty() && temperatures[today] > temperatures[stack.peek()]) {
                int waitingday = stack.pop();
                answer[waitingday] = today - waitingday; 
            }
            stack.push(today);

            }
            return answer;
            
        }
        
    }

/*
temperatures, temperatures[i] is the temp on that day
answer, answer[i] how many days need to wait to get warmer temp (first warmer)

[70, 77, 50, 60, 55, 44, 33, 70]
[1, 6, 1, 4, 3, 2, 1, 0]

brute force:
nested loops that checks ever index

optimal:


*/