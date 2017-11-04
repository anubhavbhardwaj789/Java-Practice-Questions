/*
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Task Schedular - Ordered

PROBLEM STATEMENT:

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters 
represent different tasks.Tasks have to be done in original order. Each task could be done in one interval. For 
each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n 
intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 14
Explanation: A -> idel -> idel -> A -> idel -> idel -> A -> B -> idel -> idel -> B  idel -> idel -> B
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/


class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(tasks.length==0)return 0;
        Map<Character,Integer>tracker=new HashMap<Character,Integer>(); //Stores the tasks and the last executed time of it
        int timer=0;
        
        for(int i=0;i<tasks.length;i++)
        {
            if(!tracker.containsKey(tasks[i]))
            {
                timer++;
                tracker.put(tasks[i],timer);
                System.out.println("Task : "+tasks[i]+" Exeuted at time:"+timer);
            }
            else
            {
                timer++;
                if(timer<(tracker.get(tasks[i])+n+1))
                {
                    timer=tracker.get(tasks[i])+n+1;
                    tracker.put(tasks[i],timer);
                    System.out.println("Task : "+tasks[i]+" Exeuted at time:"+timer);
                }
                else
                {
                    tracker.put(tasks[i],timer);
                    System.out.println("Task : "+tasks[i]+" Exeuted at time:"+timer);
                }
            }
        }
        return timer;
        
    }
}