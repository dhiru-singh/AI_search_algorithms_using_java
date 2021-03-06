package AIprograms;
import java.util.*;
import java.util.Map.Entry;
public class BFS 
{
   
    Map <Character, LinkedList<Character>> adjList;
    BFS()
    {
        adjList = new HashMap<Character, LinkedList<Character>>();
    }
    
    void addList(Character parent,LinkedList<Character> child)
    {
        adjList.put(parent,child);
    }
    
    void Search(Character start,LinkedList<Character> g_nodes){
        
        
        for (int j=0; j<g_nodes.size(); j++) {
            if(start.equals(g_nodes.get(j)))
            {
                System.out.println("Goal Node Found!");
                System.out.println(start);
            }
        }
        
         Queue<Character> listQueue = new LinkedList<Character>();
         LinkedList<Character> explored = new LinkedList<Character>();
         Character temp;
         listQueue.add(start);
         
          while(!listQueue.isEmpty()){
              Character node = listQueue.remove();
               int flag=0;
              
              for(int i=0;i<explored.size();i++)
              {
                  if(explored.get(i)==node)
                      flag=1;
              }
              if(flag==0)
                 explored.add(node);
               for (int j=0; j<g_nodes.size(); j++) {
                    if(g_nodes.get(j)==node)
                        {
                            System.out.println("Goal Node Found!");
                            System.out.println(explored);
                            return;
                        }
                }
               
               for(int i=0;i<adjList.get(node).size();i++)
               {
                   if(adjList.get(node).get(0)!='-')
                        listQueue.add(adjList.get(node).get(i));
               }
          }
       
    }

    public static void main(String[] args)
    {
        BFS bfs = new BFS();
        LinkedList<Character> tempChildlist = new LinkedList<Character>();
        Character start_node;
        LinkedList<Character> nodes,goal_nodes;
        Scanner s = new Scanner(System.in);
        int no_of_nodes,no_of_child_nodes,no_goal_nodes;
        System.out.print("Enter the Number of Nodes : ");
        no_of_nodes=s.nextInt();
        nodes= new LinkedList<Character>();
        System.out.println("Enter the name Individual  nodes : ");
        for(int i=0;i<no_of_nodes;i++)
        {
            nodes.add(s.next().charAt(0));
        }
        for(int i=0;i<no_of_nodes;i++)
        {
            System.out.println("Enter the Child Nodes of "+nodes.get(i));
            System.out.print(nodes.get(i)+" Has How many Chidren? : ");
            no_of_child_nodes=s.nextInt();
            tempChildlist= new LinkedList<Character>();
                if(no_of_child_nodes!=0)
                {System.out.println("Child Nodes are : ");
                for(int j=0;j<no_of_child_nodes;j++)
                {
                    tempChildlist.add(s.next().charAt(0));
                }
                bfs.addList(nodes.get(i),tempChildlist);
                }
                else
                {
                    tempChildlist.add('-');
                     bfs.addList(nodes.get(i),tempChildlist);
                }
             
        }
     
       System.out.print("Enter the no.of Goal nodes : ");
       no_goal_nodes=s.nextInt();
       goal_nodes = new LinkedList<Character>();
        for (int i = 0; i < no_goal_nodes; i++)
            goal_nodes.add(s.next().charAt(0));
        
        System.out.println("Enter the start node : ");
        start_node=s.next().charAt(0);
       
        System.out.print("Goal nodes : ");
        for (int i = 0; i < goal_nodes.size(); i++)
            System.out.print(goal_nodes.get(i) + " ");
        System.out.print("\nStart nodes : "+start_node);
        System.out.println();
        Set<Entry<Character,LinkedList<Character>>> hashSet=bfs.adjList.entrySet();
        for(Entry entry:hashSet ) {
            System.out.println(entry.getKey()+"->"+entry.getValue());
        } 
       
        
        bfs.Search(start_node, goal_nodes);
    }
}