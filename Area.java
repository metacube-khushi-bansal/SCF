import java.util.Scanner;

public class Area {

    /**
     * To calculate the area of the triangle
     * 
     * @param width  - represents the width of the triangle
     * @param height - represents the height of the triangle
     * @return double - The area of triangle calculated by (width * height) / 2
     * @throws ArithmeticException - If the width or height of triangle is less than or equal to Zero
     */
    public double calculateAreaOfTriangle(double width, double height) {
        if(width <=0 || height <= 0)
        throw new ArithmeticException("Width and height must be greater than Zero!");
        double area = (width * height) / 2;
        return area;
    }

    /**
     * To calculate the area of Rectangle
     * 
     * @param width  - represents the width of the Rectangle
     * @param height - represents the height of the Rectangle
     * @return double - Area of Rectangle calculated by width * height
     * @throws ArithmeticException - If the width or height of Rectangle is less than or equal to Zero

     */
    public double calculateAreaOfRectangle(double width, double height) {
        if(width <=0 || height <= 0)
        throw new ArithmeticException("Width and height must be greater than Zero!");
        double area = width * height;
        return area;
    }

    /**
     * To calculate the area of Square
     * 
     * @param width - The width of the square
     * @return double - Area of Square calculated by width * width
     * @throws ArithmeticException - If the width  of Square is less than or equal to Zero

     */
    public double calculateAreaOfSquare(double width) {
        if(width <=0)
        throw new ArithmeticException("Width must be greater than Zero!");
        double area = width * width;
        return area;
    }

    /**
     * To calculate the area of the circle
     * 
     * @param radius- The radius of the circle
     * @return double - Area of circle calculated by PI * radius * radius
     * @throws ArithmeticException - If the radius of circle is less than or equal to Zero

     */
    public double calculateAreaOfCircle(double radius) {
        if(radius <=0)
        throw new ArithmeticException("Radius must be greater than Zero!");
        final double PI = 3.14;
        double area = PI * radius * radius;
        return area;
    }

    public static void main(String[] args) {
        Area area = new Area();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Select from the following: ");
            System.out.println("To calculate area of Triangle: 1");
            System.out.println("To calculate area of Rectangle: 2");
            System.out.println("To calculate area of Square: 3");
            System.out.println("To calculate area of Circle: 4");
            System.out.println("Exit: 5");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the width and height of Triangle: ");
                    System.out.println("Enter the width: ");
                    double widthOfTriangle = scanner.nextInt();

                    System.out.println("Enter the height: ");
                    double heightOfTriangle = scanner.nextInt();
                    try {
                        System.out.println(
                            "Area of Triangle is: " + area.calculateAreaOfTriangle(widthOfTriangle, heightOfTriangle));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Enter the width and height of Rectangle: ");
                    System.out.println("Enter the width: ");
                    double widthOfRectangle = scanner.nextInt();
                    System.out.println("Enter the height");
                    double heightOfRectangle = scanner.nextInt();
                    try {
                        System.out.println("Area of Triangle is: "
                            + area.calculateAreaOfRectangle(widthOfRectangle, heightOfRectangle));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;

                case 3:
                    System.out.println("Enter the width of Square: ");
                    double widthOfSquare = scanner.nextInt();
                    try {
                        System.out.println("Area of Square is: "
                            + area.calculateAreaOfSquare(widthOfSquare));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;

                case 4:
                    System.out.println("Enter the radius of circle: ");
                    double radiusOfCircle = scanner.nextInt();
                    try {
                        System.out.println("Area of Triangle is: "
                            + area.calculateAreaOfCircle(radiusOfCircle));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                default:
                    System.out.println("Exited!");
                    break;
            }

        } while (choice != 5);
        scanner.close();
    }
}
