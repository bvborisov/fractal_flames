package FF.src;
public class Variations {

	public static Point linear(Point p)
	{
		return p;
	}
	public static Point sinusoidal(Point p)
	{
		return new Point(Math.sin(p.getX()),Math.sin(p.getY()));
	}
	public static Point spherical(Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		return new Point(p.getX()/(r*r),p.getY()/(r*r));
	}
	public static Point handkerchief (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return  new Point ( r*Math.sin(f+r), r*Math.cos(f-r));
	}
	public static Point swirl(Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		return new Point (p.getX()*Math.sin(r*r)-p.getY()*Math.cos(r*r),p.getX()*Math.cos(r*r)+p.getY()*Math.sin(r*r));
	}
	public static Point horseshoe (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		return new Point ((p.getX()-p.getY())*(p.getX()+p.getY())/r,2*p.getX()*p.getY()/r);
	}
	public static Point polar(Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double t = Math.atan2(p.getX(),p.getY()); //theta
		return new Point(t/Math.PI,r-1);
	}
	
	public static Point spiral(Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return new Point (((Math.cos(f) + Math.sin(r))/r) , (Math.sin(f) - Math.cos(r))/r);
	}
	public static Point diamond (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return new Point (Math.sin(f)*Math.cos(r), Math.cos(f)*Math.sin(r));
	}
	public static Point julia (Point p) // needs more reworking
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return new Point (p.getX()*2/(r+1),p.getY()*2/(r+1));
	}
	public static Point waves (Point p)
	{
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return new Point (p.getX() + Math.E*Math.sin(p.getY()/2),p.getY() + Math.E*Math.sin(p.getX()/(f*f))); // not sure if this will work... might make the program crash :D
	}
	public static Point power (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return new Point (Math.pow(r,Math.sin(f))*Math.cos(f),Math.pow(r,Math.sin(f))*Math.sin(f));
	}
	public static Point eyefish (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		return new Point ((2/(r+1))*p.getX(),(2/(r+1))*p.getY());
	}
	public static Point cylinder (Point p)
	{
		return new Point (Math.sin(p.getX()),p.getY());
	}
	public static Point cross (Point p)
	 {
	  return new Point (Math.sqrt(1/Math.pow(Math.pow(p.getX(),2) + Math.pow(p.getY(),2), 2))*p.getX(),Math.sqrt(1/Math.pow(Math.pow(p.getX(),2) + Math.pow(p.getY(),2), 2))*p.getY());
	 }
	
	public static Point heart (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return new Point (r*Math.sin(f*r),-r*Math.cos(f*r));
	}
	public static Point disk (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return new Point ((f/Math.PI)*Math.sin(Math.PI*r),(f/Math.PI)*Math.cos(Math.PI*r));
	}
	public static Point hyperbolic (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		return new Point (Math.sin(f)/r,r*Math.cos(f));
	}
	public static Point ex (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		double f = Math.atan2(p.getY(),p.getX()); // phi
		double p0 = Math.sin(f+r);
		double p1 = Math.cos(f-r);
		return new Point (r*(Math.pow(p0,3) + Math.pow(p1,3)),r*(Math.pow(p0,3)-Math.pow(p1, 3)));
	}
	public static Point bent (Point p)
	{
		if (p.getX()>=0 && p.getY()>=0)				return new Point (p.getX(),p.getY());
		if (p.getX()<0 && p.getY()>=0)				return new Point (2*p.getX(),p.getY());
		if (p.getX()>=0 && p.getY()<0)				return new Point (p.getX(),p.getY()/2);
		else 										return new Point (2*p.getX(),p.getY()/2);
		
	}
	public static Point exponential (Point p) // neshto ne e nared i s towa
	{
		
		return new Point (Math.cos(p.getX()),Math.cos(p.getY()));
	}
	public static Point cosine (Point p) // trqbwa da se oprawi
	{
		return new Point (1/p.getY(),1/p.getX());
	}
	public static Point bubble (Point p)
	{
		double r = Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY()); // r
		return new Point ((4/(Math.pow(r, 2)+4))*p.getX(),(4/(Math.pow(r, 2)+4))*p.getY());
	}
	public static Point perspective (Point p) // fail
	{
		double p1 = 0.03;
		double p2 = 0.1;
		return new Point (p2/(p2-p.getY()*Math.sin(p1))*p.getX(),(p2/(p2-p.getY()*Math.sin(p1))*p.getY()*Math.sin(p1)));
	}
}
