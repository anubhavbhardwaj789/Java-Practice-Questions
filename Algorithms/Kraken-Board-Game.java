////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
PROBLEM STATEMENT:
Given a board game Kraken with m*n grid. The player is suppose to start at top left corner and has to reach
bottom right cell. But he is allowed to move either right or down of diagonally right down. Finish the function
KrakenCount which takes n and m as inputs and returns total possible umber of ways to traverse from top left to
bottom right cell.

Difficulty Level : Medium

Author: Anubhav Bhardwaj
*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////


static int krakenCount(int m, int n) 
{
        
       int[][] a = new int[m][n];
    
    //initialize first row and column
    for(int i=0;i<n;i++)
    {
        a[0][i]=1;
    }
    for(int i=0;i<m;i++)
    {
        a[i][0]=1;
    }
    for(int i=1;i<m;i++)
    {
        for(int j=1;j<n;j++)
        {
            a[i][j]=a[i-1][j]+a[i][j-1]+a[i-1][j-1];
        }
    }
    return a[m-1][n-1];


    }
