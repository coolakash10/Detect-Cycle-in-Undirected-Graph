/*********************************************************************************************************************
     **
     **  Detecton of cycle using BFS

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
   
    
    public static boolean bfs(int current)
    {
        
        Queue<Integer> queue=new LinkedList<>();
        visited[current]=true;
        Arrays.fill(parent,-1);
        
        queue.add(current);
        
        while(queue.size()!=0)
        {
            Integer u=queue.poll();
            
            for(Integer i:list[u])
            {
                if(!visited[i])
                {
                    queue.add(i);
                    visited[i]=true;
                    parent[i]=u;
                }
                else if(parent[u]!=i)
                    return true;
            }
        }
        return false;
    }
    
    public static boolean isCycle(int current)
    {
        return bfs(current);
    }

	public static void main(String[] args) 
	{

	    n=4;
	    list=new LinkedList[n];
	    visited=new boolean[n];
	    parent=new int[n];
	    for(int i=0;i<n;i++)
	        list[i]=new LinkedList<Integer>();
	        
	    int [][]a={{0,1},{0,2},{1,3},{1,2}};     
            
        for(int i=0;i<a.length;i++)		
        {
            list[a[i][0]].add(a[i][1]);
            list[a[i][1]].add(a[i][0]);
        }
		if(isCycle(0))
		    System.out.println("Graph contains Cycle");
		else    
		    System.out.println("Graph does not contains Cycle ");

	}

}
