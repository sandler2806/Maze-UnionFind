package maze;
public class node {
    public int size;
    public int i;
    public int j;
    public node(int i, int j){
        this.i=i;
        this.j=j;
        this.size=1;
    }

    @Override
    public String toString() {
        return "node{" +
//                "size=" + size +
                ", i=" + i +
                ", j=" + j +
                '}';
    }
}
