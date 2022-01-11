package pens;

public class UsePen {

    public static void main(String[] args) {
        Pen pen = new Pen();

        pen.click();
        pen.write("Halloooo");
        pen.unclick();
        pen.write("Halloooo");

        
        Pen superPen = (Pen)new SuperPen();

        System.out.println(superPen.color);
        superPen.click();
        superPen.write("Halloooo");


    }
}
