package maze;


public class edge {
    public node a;
    public node b;
    public edge(node a, node b){
        this.a=a;
        this.b=b;
    }

    @Override
    public String toString() {
        return "edge{" +
                "a=" + a +
                ", b=" + b +
                '}'+"\n";
    }
}
