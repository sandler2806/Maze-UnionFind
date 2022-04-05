package maze;
import javax.swing.*;
import java.awt.*;

public class maze extends JFrame {

    private int [][] mat;

    public maze(int[][]maze){
        this.mat =maze;
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int y=750/this.mat.length;
        int x=750/this.mat[0].length;
        if(x<y){
            y=x;
        }
        g.translate(30,30);
        for (int row = 0; row <this.mat.length ; row++) {
            for (int col = 0; col < this.mat[0].length ; col++) {
                Color color;
                if(this.mat[row][col]==1){
                    color=Color.BLACK;
                }
                else if(this.mat[row][col]==8){
                     color=Color.GREEN;
                }
                else if(this.mat[row][col]==9){
                     color=Color.RED;
                }
                else{
                     color=Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(y*(col),y*(row),y,y);
                g.setColor(Color.BLACK);
                g.drawRect(y*(col),y*(row),y,y);
            }
        }

    }

//    public static void main(String[] args) {
    public static void draw(int[][]mat){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                maze maze1 =new maze(mat);
                maze1.setVisible(true);

            }
        });
    }
}

