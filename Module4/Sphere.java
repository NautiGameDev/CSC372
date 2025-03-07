public class Sphere extends Shape
{
    protected double radius;

    public Sphere(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double surface_area()
    {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double volume()
    {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString()
    {
        return "Sphere Volume: " + volume() +
                    "\nSphere Surface Area: " + surface_area();
    }

}
