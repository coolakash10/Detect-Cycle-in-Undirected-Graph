/*********************************************************************************************************************
     **
     **  Detecton of cycle using DFS

     **  Input in the form of List of edges
     **  Output detection of cycle in graph
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.util.*;
public class Main
{
    static int n;
    static LinkedList<Integer>list[];
    static int parent[];
    static boolean visited[];

    
    public static boolean dfs(int current,int parent)
    {
        visited[current]=true;
        
        for(Integer i:list[current])
        {
            if(!visited[i])
            {
                dfs(i,current);
            }
            else if(i!=parent)
                return true;
        }
        return false;    
    }
    
    public static boolean isCycle(int current,int parent)
    {
        return dfs(current,parent);
    }

	public static void main(String[] args) 
	{

	    n=4;
	    list=new LinkedList[n];
	    visited=new boolean[n];
	    
	    for(int i=0;i<n;i++)
	        list[i]=new LinkedList<Integer>();
	        
	    int [][]a={{0,1},{0,2},{1,3},{1,2}};     
            
        for(int i=0;i<a.length;i++)		
        {
            list[a[i][0]].add(a[i][1]);
            list[a[i][1]].add(a[i][0]);
        }
		if(isCycle(0,-1))
		    System.out.println("Graph contains Cycle");
		else    
		    System.out.println("Graph does not contains Cycle ");

	}

}
