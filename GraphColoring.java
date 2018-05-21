
import java.util.*;

/**
 * Implementation of the DSatur heuristic for graph coloring.
 *
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class GraphColoring {
    
    /** Creates a new instance of GraphColoring */
    public GraphColoring() {
    }
    
    public static void main(String [] args) throws Exception
    {
        System.out.println("Reading Graph...");
        /* Read the graph from Constants.FILE */
        Graph graph = GraphReader.readGraph();
        
        /* Compute Clique */
        LinkedHashSet clique = MaxClique.computeClique(graph);
        
        /* Color the vertices of the clique with different colors */
        int k = clique.size();
        Iterator it = clique.iterator();
        int col = 1;
        while(it.hasNext())
        {
            int vertex = ((Integer)it.next()).intValue();
            Node node = graph.nodes[vertex];
            node.colorNode(col);
            col++;
        }
            
        Node [] nodes = graph.nodes;
        PossibleColorsComparator comparator = new PossibleColorsComparator();
        TreeSet uncoloredNodes = new TreeSet(comparator);
        List listNodes = new ArrayList();
        LinkedHashSet flags = new LinkedHashSet();
        for(int i=0; i<nodes.length; i++)
        {
            Node node = nodes[i];
            if(node.color == Constants.UNCOLORED)
            {
                node.computeDegreeSat(graph);
                uncoloredNodes.add(node);
                listNodes.add(node);
                flags.add(new Integer(node.value));
            }
        }
        
        while(!uncoloredNodes.isEmpty())
        {
            Node node = (Node)uncoloredNodes.first();
            uncoloredNodes.remove(node);
            flags.remove(new Integer(node.value));
            //System.out.println(uncoloredNodes.size());
            for(int i=1; ;i++)
            {
                if(node.isValidColor(graph, i))
                {
                    node.colorNode(i);
                    LinkedHashSet list = node.list;
                    it = list.iterator();
                    while(it.hasNext())
                    {
                        int vertex = ((Integer)it.next()).intValue();
                        Node n = graph.nodes[vertex];
                        
                        if(uncoloredNodes.contains(n))
                        {
                            uncoloredNodes.remove(n);       
                            n.computeDegreeSat(graph);
                            uncoloredNodes.add(n);
                        }
                    }
                    
                    if(i > k)
                    {
                        k = i;
                    }
                    break;
                }
            }
        }
        
        System.out.println(k + " coloring found using DSatur.");
        System.out.println("Applying Iterated Greedy Improvement...");
        
        int [] colors = IteratedGreedy.iteratedGreedy(k, graph);
        int maxColor = -1;
        for(int i=0; i<colors.length; i++)
        {
            graph.nodes[i].color = colors[i];
            if(maxColor == -1)
            {
                maxColor = colors[i];
            }
            else if(maxColor < colors[i])
            {
                maxColor = colors[i];
            }
        }
        
        System.out.println("Applying Local Search...");
        colors = LocalSearch.localSearch(graph, maxColor);
        maxColor = -1;
        for(int i=0; i<colors.length; i++)
        {
            if(maxColor == -1)
            {
                maxColor = colors[i];
            }
            else if(maxColor < colors[i])
            {
                maxColor = colors[i];
            }
        }
        
        System.out.println("Final Coloring of graph possible with " + maxColor + " colors.");
        System.out.println("Colors of Vertices: ");
        for(int i=0; i<colors.length; i++)
        {
            System.out.print(colors[i] + " ");
        }
    }
    
    public static class PossibleColorsComparator implements Comparator
    {
        public int compare(Object o1, Object o2)
        {
            Node node1 = (Node)o1;
            Node node2 = (Node)o2;
            
            if(node1.value == node2.value)
            {
                return 0;
            }
            
            if(node1.degreeSat < node2.degreeSat)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }
}
