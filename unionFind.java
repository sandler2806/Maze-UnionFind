package maze;
import java.util.ArrayList;
import java.util.Collections;

public class unionFind {
    public static void main(String[] args) {
        int m=20;
        int n=20;

        node[][] mat=new node[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j]=new node(i,j);
            }
        }
        ArrayList<edge> edges=getEdges(mat);
        Collections.shuffle(edges);
        for (int i = 0; i <edges.size() ; i++) {
            if(Find(edges.get(i).a.i,edges.get(i).a.j,mat)!=Find(edges.get(i).b.i,edges.get(i).b.j,mat)){
                Union(edges.get(i).a, edges.get(i).b, mat);
            }
            else {
                edges.remove(edges.get(i--));
            }
        }
        int[][]matrix=matrix(mat,edges);
        maze.draw(matrix);
    }
    public static ArrayList<edge> getEdges(node [][] mat){
        ArrayList<edge> edges=new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                if(i< (mat.length-1)){
                    edges.add(new edge(new node(mat[i][j].i,mat[i][j].j),new node(mat[i+1][j].i,mat[i+1][j].j)));
                }
                if(j<(mat[0].length-1)){
                    edges.add(new edge(new node(mat[i][j].i,mat[i][j].j),new node(mat[i][j+1].i,mat[i][j+1].j)));
                }
            }
        }
        return edges;
    }
    public static int[][] matrix(node[][]mat,ArrayList<edge>edges){
        int [][]matrix=new int[(2*mat.length)+1][(2*mat[0].length)+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=1;
            }
        }
        for (edge edge : edges) {
            matrix[(2 * edge.a.i) + 1][(2 * edge.a.j) + 1] = 0;
            matrix[(2 * edge.b.i) + 1][(2 * edge.b.j) + 1] = 0;
            matrix[edge.b.i + 1 + edge.a.i][edge.a.j + 1 + edge.b.j] = 0;
        }
        matrix[1][0]=8;
        matrix[matrix.length-2][matrix[0].length-1]=9;
        return matrix;
    }
    public static node Find(int i,int j,node[][]mat) {

        node n=mat[i][j];
        if(n.i!=i||n.j!=j)
        {
            node parent=Find(n.i,n.j,mat);
            n.i=parent.i;
            n.j=parent.j;
            return parent;

        }
        return n;
    }

    public static void Union(node a, node b,node[][]mat) {
        node p1=Find(a.i,a.j,mat);
        node p2=Find(b.i,b.j,mat);
        if(p1!=p2)
        {
            if(p1.size<=p2.size)
            {
                p1.i=p2.i;
                p1.j=p2.j;
                p2.size+=p1.size;

            }
            else
            {
                p2.i=p1.i;
                p2.j=p1.j;
                p1.size+=p2.size;

            }

            }
    }
}
