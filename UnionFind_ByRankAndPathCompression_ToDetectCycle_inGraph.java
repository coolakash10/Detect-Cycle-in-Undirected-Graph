/*********************************************************************************************************************
     **
     **  Union Find Algorithm to detect cycle in graph by Rank and Path Compression

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
    static LinkedList<Edge>list=new LinkedList<>();
    static int parent[];
    static int rank[];

    static class Edge
    {
        int edge1;
        int edge2;
        Edge(int s,int d)
        {
            edge1=s;
            edge2=d;
        }
    }

    public static int findParent(int edge)
    {
        if(parent[edge]==edge)
            return edge;
            
        //path Compression     
        parent[edge]=findParent(parent[edge]);
        
        return parent[edge];
    }
    
    public static void union(int edge1,int edge2)
    {
        int p1=findParent(edge1);
        int p2=findParent(edge2);
        
        //union by rank
        if(rank[p1]>rank[p2])
            parent[p2]=p1;
        else if(rank[p1]<rank[p2])    
            parent[p1]=p2;
        else
        {
            parent[p1]=p2;
            rank[p2]++;
        }
            
    }

    public static boolean isCycle()
    {
        rank=new int[n];
        Arrays.fill(rank,0);
        
        parent=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
            
        for(Edge e:list)
        {
           int edge1=e.edge1;
           int edge2=e.edge2;
           
           int p1=findParent(edge1);
           int p2=findParent(edge2);
           
           if(p1==p2)
            return true;
            
           union(edge1,edge2);
        }
        return false;
    }

	public static void main(String[] args) 
	{

	    n=4;
		list.add(new Edge(0,1));
		list.add(new Edge(0,2));
		list.add(new Edge(1,3));
		list.add(new Edge(1,2));
		
		if(isCycle())
		    System.out.println("Graph contains Cycle");
		else    
		    System.out.println("Graph does not contains Cycle ");

	}

}
