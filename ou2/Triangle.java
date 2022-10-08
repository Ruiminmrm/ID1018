public class Triangle{
    public static double compPerim(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }
    public static double compArea(double base, double height) {
        return (base * height) / 2;
    }
    public static double heron(double side1, double side2, double side3) {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
    public static double[] bisector(double a, double b, double c, double alpha, double beta, double gamma) {
        double[] sides = {a,b,c,a};
        double[] angles= {gamma,alpha,beta};
        double[] bis = new double[3];
        for (int i = 0; i < 3; i++) {
            double p = 2 * sides[i] * sides[i+1] * Math.cos(angles[i] / 2);
            bis[i] = p / (sides[i] + sides[i+1]);
        }
        return bis;
    }
    public static double rInc(double side1, double side2, double side3) {
        double area = heron(side1, side2, side3);
        double perim = compPerim(side1, side2, side3);
        return (2 * area) / perim;
    }
    public static double rCir(double side1, double side2, double side3) {
        double area = heron(side1, side2, side3);
        return (side1*side2*side3)/(4 * area);
    }
}

