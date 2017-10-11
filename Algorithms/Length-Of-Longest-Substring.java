//////////////////////////////////////////////////////////////////////////////////////
/*

PROBLEM STATEMENT:
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring

Problem Source: Leetcode

Difficulty Level : Medium

*/
//////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        String ss="";
        String temps="";
        int length=0;
        int templ=0;
        int tracker=0;
        if(s.length()==0) return 0;
        else
        {
            for(int i=0;i<s.length();i++)
            {
                if(temps.indexOf(s.charAt(i))<0)
                {
                    temps=temps+s.charAt(i);
                    templ+=1;

                }
                else
                {
                    if(templ>length)
                    {
                        length=templ;
                        ss=temps;
                    }
                    temps=temps.substring(temps.indexOf(s.charAt(i))+1,temps.length())+s.charAt(i);
                    templ=temps.length();
                    
                }
            }
            if(templ>length)
                    {
                        length=templ;
                        ss=temps;
                    }
            return length;
        }
        
    }
}