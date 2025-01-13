import java.util.Random;

public class ShapeArray 
{
    public static void main(String[] args)
    {
        Random random = new Random();

        //Instantiate object parameters as random numbers
        double sphereRadius = random.nextInt(10) + Math.random();
        double cylinderRadius = random.nextInt(10) + Math.random();
        double cylinderHeight = random.nextInt(10) + Math.random();
        double coneRadius = random.nextInt(10) + Math.random();
        double coneHeight = random.nextInt(10) + Math.random();

        //Instantiate shape objects
        Sphere sphere = new Sphere(sphereRadius);
        Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
        Cone cone = new Cone(coneRadius, coneHeight);

        Shape[] shapeArray = {sphere, cylinder, cone};

        //Loop through each shape to call toString() method
        for (Shape shape : shapeArray)
        {
            System.out.println(shape);
        }
    }    
}
