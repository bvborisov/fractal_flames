package FF.src;
public class Point
{
private  double x;
private  double y;

public Point(double X, double Y) {
x = X;
y = Y;
}
public Point() //creates a (0,0) point
{
x=0;
y=0;
}
public double getX() { return x; }
public double getY() { return y; }

public Point setX(double X) { 
    Point p1 = this;
    p1.x = X;
    return p1;
}

public Point setY(double Y) { 
    Point p1 = this;
    p1.y = Y;
    return p1;
}
    
public static void randomPoint(Point p) //random point betwenn (-1,1) on both x and y
{
    if (Math.random() <0.5) p.x = Math.random();
    else p.x = -Math.random();
    if (Math.random() <0.5) p.y = Math.random();
    else p.y = -Math.random();
}

public Point add (Point p2)
{
Point p1 = this;
double x = p1.getX() + p2.getX();
double y = p1.getY() + p2.getY();
return new Point(x,y);
}

public Point multiply ( double d)
{
Point p1 = this;
double d1 = p1.getX() * d;
double d2 = p1.getY() * d;
return new Point( d1,  d2);
}

public static int translateX ( Point p , int size )
{
	double x = Math.abs((p.getX()+1)*size/2.0);
	if (x > size) return size;
	else return (int) Math.round(x); //round
}
public static int translateY (Point p, int size)
{
	double y = Math.abs((p.getY()+1)*size/2.0);
	if(y>size) return size;
	else return (int) Math.round(y); //round
}


public static void main(String[] args)
{
Point p = new Point(3.0,4.0);
System.out.println(p.getX());
System.out.println(p.getY());

p = p.multiply(1/3.0);

System.out.println(p.getX());
System.out.println(p.getY());

Point p1 = new Point();
System.out.println(p1.getX());
System.out.println(p1.getY());

randomPoint(p1);
System.out.println(p1.getX());
System.out.println(p1.getY());

Point p2 = new Point();
p2.setX(2);
System.out.println(p2.getX());
System.out.println(p2.getY());

}
}

