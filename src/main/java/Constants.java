
/**
 * Constants.
 *
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class Constants {

    public static int NUMBER_NODES; // populated by GraphReader.readGraph()

    /*
     * The file from which the graph has to be read.
     * The format is specified by the following URL:
     * http://www.nlsde.buaa.edu.cn/~kexu/benchmarks/graph-benchmarks.htm
     */
    //public static String FILE = "data.col";

    /* The number of iterations */
    public static int CLIQUE_ITERATIONS = 2000;

    /* Uncolored Vertex Value */
    public static int UNCOLORED = -1;

    /* Time to spend on one k */
    public static long TIME = 1000;

    /* If optimal coloring is known this field can be populated. This will
     * significantly reduce the duration for which the algorithm runs.
     *
     * If you populate this field, make sure that you increase the TIME constant to
     * a higher value so that it would try its best to find the KNOWN_K coloring
     */
    public static int KNOWN_K = 0;

    /* Constants for random restart for MaxClique */
    public static final int TOLERANCE = 250;

    /* Maximum iterations to spend on finding a unique random restart */
    public static int MAX_UNIQUE_ITERATIONS = 100;

    // iterated greedy
    public static int ITERATED_GREEDY_ITERATIONS = 1000;
    public static final double DECREASING = 0.1;
    public static final double REVERSE = 0.05;
    public static final double INCREASING = 0.8;
    public static final double RANDOM = 0.05;

    // local search
    public static boolean LOCAL_SEARCH = true;
    public static int LOCAL_SEARCH_ITERATIONS = 1000;
    public static long LOCAL_SEARCH_MAX_TIME = 1000; // milliseconds

}
