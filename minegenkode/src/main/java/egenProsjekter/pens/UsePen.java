package egenProsjekter.pens;

public class UsePen {

    public static void main(String[] args) {
        Pen pen = new Pen();

        System.out.println(pen.type);
        System.out.println(pen.color);
        System.out.println(pen.point);
        pen.click();
        pen.write("Halloooo");
        pen.unclick();
        pen.write("Halloooo");

        System.out.println("__________");

        Pen superPen = new SuperPen();

        System.out.println(superPen.type);
        System.out.println(superPen.color);
        System.out.println(superPen.point);
        superPen.click();
        superPen.write("Halloooo");

        System.out.println("__________");

        SuperPen superPen2 = new SuperPen();

        System.out.println(superPen2.type);
        System.out.println(superPen2.color);
        System.out.println(superPen2.point);
        superPen2.click();
        superPen2.write("Halloooo");


    }
}
