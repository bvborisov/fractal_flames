package FF.src;

//import java.awt.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class FractalFlames extends JFrame
{
	
	private JButton button1;
	private JTextField textfield;
	private JTextField textfield2;
	private JTextField textfield3;
	private JComboBox ComboBox1;
	private String str = null;
	private JLabel label;
	private JLabel label1;
	private JLabel label2;
	private String[] a = new String[1];
	//ImageIcon image = new ImageIcon();
	
	public FractalFlames() {
		setLayout(new FlowLayout());
		
		label1 = new JLabel("Enter size of pictire in pixels");
		add(label1);
		
		textfield = new JTextField(15);
		add(textfield);
		
		label1 = new JLabel("Enter number of iterations");
		add(label1);
		
		textfield2 = new JTextField(15);
		add(textfield2);
		
		ComboBox1 = new JComboBox();
		add(ComboBox1);
		ComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "linear", "sinusoidal", "spherical", "handkerchief", "swirl", "horseshoe", "polar", "spiral", "diamond", "julia", "waves", "power", "eyefish", "cylender", "cross", "heart", "disk", "hyperbolic", "ex", "bent", "exponential", "cosine", "bubble", "perspective" }));
		
		button1 = new JButton("Draw");
		add(button1);
		
		event1 e1 = new event1();
		button1.addActionListener(e1);
		
		label = new JLabel();
		add(label);
		
		label2 = new JLabel();
		add(label2);

		textfield3 = new JTextField(15);
		//add(textfield3);
		//event2 e2 = new event2();
		//ComboBox1.addActionListener(e2);
	}
	
	public class event1 implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			a[0] = "\"" + ComboBox1.getSelectedItem() + "\"";
			str = (String) ComboBox1.getSelectedItem();
			textfield3.setText(str);
			Settings s = new Settings(Integer.parseInt(textfield.getText()),Integer.parseInt(textfield2.getText()),textfield3.getText());
			drawFlame(s);
			//label.setText(str);
			//label2.setText(textfield3.getText());
		}
	}
	
	public static Picture blur(Picture p) { // true blur
		int w=p.width();
		int h=p.height();
		for (int i=1;i<(w-1);i++){
			for (int j=1;j<(h-1);j++){
				if (p.get(i,j).getRed()<15 && p.get(i, j).getGreen()<15 && p.get(i, j).getBlue()<15) {
					int newRed = ((p.get(i-1, j-1).getRed() + p.get(i-1,j).getRed() + p.get(i-1,j+1).getRed() + p.get(i,j-1).getRed() + p.get(i,j+1).getRed() + p.get(i+1,j-1).getRed() + p.get(i+1,j).getRed() + p.get(i+1,j+1).getRed())/8);
					int newGreen =((p.get(i-1, j-1).getGreen() + p.get(i-1,j).getGreen() + p.get(i-1,j+1).getGreen() + p.get(i,j-1).getGreen() + p.get(i,j+1).getGreen() + p.get(i+1,j-1).getGreen() + p.get(i+1,j).getGreen() + p.get(i+1,j+1).getGreen())/8);
					int newBlue = ((p.get(i-1, j-1).getBlue() + p.get(i-1,j).getBlue() + p.get(i-1,j+1).getBlue() + p.get(i,j-1).getBlue() + p.get(i,j+1).getBlue() + p.get(i+1,j-1).getBlue() + p.get(i+1,j).getBlue() + p.get(i+1,j+1).getBlue())/8);
					Color newColor = new Color(newRed,newGreen,newBlue);
					p.set(i, j, newColor); }
			}
		}
		return p;
	}
	public static Picture blurAll(Picture p) { //clears noise
		int w=p.width();
		int h=p.height();
		for (int i=1;i<(w-1);i++){
			for (int j=1;j<(h-1);j++){
				
					int newRed = ((p.get(i-1, j-1).getRed() + p.get(i-1,j).getRed() + p.get(i-1,j+1).getRed() + p.get(i,j-1).getRed() + p.get(i,j+1).getRed() + p.get(i+1,j-1).getRed() + p.get(i+1,j).getRed() + p.get(i+1,j+1).getRed())/8);
					int newGreen =((p.get(i-1, j-1).getGreen() + p.get(i-1,j).getGreen() + p.get(i-1,j+1).getGreen() + p.get(i,j-1).getGreen() + p.get(i,j+1).getGreen() + p.get(i+1,j-1).getGreen() + p.get(i+1,j).getGreen() + p.get(i+1,j+1).getGreen())/8);
					int newBlue = ((p.get(i-1, j-1).getBlue() + p.get(i-1,j).getBlue() + p.get(i-1,j+1).getBlue() + p.get(i,j-1).getBlue() + p.get(i,j+1).getBlue() + p.get(i+1,j-1).getBlue() + p.get(i+1,j).getBlue() + p.get(i+1,j+1).getBlue())/8);
					Color newColor = new Color(newRed,newGreen,newBlue);
					p.set(i, j, newColor); 
			}
		}
		return p;
	}
	public static int maxx (int[][] a)
	{
		int N = a.length;
		int maximum = Integer.MIN_VALUE;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			if( a[i][j] > maximum) maximum = a[i][j];
		return maximum;	
	}
    
    public static Point applyFunction(double[][] cx, double[][] cy, int i, Point p, double[] varWeights) //applies function
    {
        p.setX(cx[i][0]*p.getX()+cx[i][1]*p.getY()+cx[i][2]);
        p.setY(cy[i][0]*p.getX()+cy[i][1]*p.getY()+cy[i][2]);
        Point sumP = applyVariation(p,varWeights);
     
        return sumP;
    }
    
    public static Point applyVariation(Point p, double[] varWeights)
    {
    	Point sumP = new Point();
        for(int k=0;k<24;k++)  //loop for variations
        {
    		
        	if (k==0) {
        		Point p0 = Variations.linear(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==1) {
        		Point p0 = Variations.sinusoidal(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==2) {
        		Point p0 = Variations.spherical(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==3) {
        		Point p0 = Variations.handkerchief(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==4) {
        		Point p0 = Variations.swirl(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==5) {
        		Point p0 = Variations.horseshoe(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==6) {
        		Point p0 = Variations.polar(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==7) {
        		Point p0 = Variations.spiral(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==8) {
        		Point p0 = Variations.diamond(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==9) {
        		Point p0 = Variations.julia(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==10) {
        		Point p0 = Variations.waves(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==11) {
        		Point p0 = Variations.power(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==12) {
        		Point p0 = Variations.eyefish(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==13) {
        		Point p0 = Variations.cylinder(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==14) {
        		Point p0 = Variations.cross(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	//HEART,DISK,HYPERBOLIC,EX,BENT,EXPONENTIAL,COSINE,BUBBLE,PERSPECTIVE
        	if (k==15) {
        		Point p0 = Variations.heart(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==16) {
        		Point p0 = Variations.disk(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==17) {
        		Point p0 = Variations.hyperbolic(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==18) {
        		Point p0 = Variations.ex(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==19) {
        		Point p0 = Variations.bent(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==20) {
        		Point p0 = Variations.exponential(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==21) {
        		Point p0 = Variations.cosine(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==22) {
        		Point p0 = Variations.bubble(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        	if (k==23) {
        		Point p0 = Variations.perspective(p);
        		p0 = p0.multiply(varWeights[k]);
        		sumP = sumP.add(p0);
        	}
        }
        return sumP;
    	
    }
    
    public static Color setColor (Settings settings, Color color,int k)
    {
    	int blue,green,red;
        if (((color.getBlue() + settings.getColors()[k]) / 2) < 256)
        {
        	blue = ((color.getBlue() + settings.getColors()[k]) / 2);
        }
        else blue = 255;
        if (((color.getGreen() + settings.getColors()[k+1]) / 2) < 256)
        {
        	green = ((color.getGreen() + settings.getColors()[k+1]) / 2);
        }
        else green = 255;
        	
        if (((color.getRed() + settings.getColors()[k+2]) / 2) < 256) 
        {
        	red = ((color.getRed() + settings.getColors()[k+2]) / 2);
        }
        else red = 255;
       return new Color(blue, green, red);
        	
    }
                
    public static void drawFlame(Settings sTest)
    {
    	int size = sTest.getSize(); //size of picture
        int[][] arrayHit = new int [size] [size];//array for storing how many times a pixel was hit.
        Point p0 = new Point(); //we start to initialise the things we need for the chaos game algorithm
        Point.randomPoint(p0); //we randomise our point
        int iteration = 0; //initialise the iteration counter
        Picture pic = new Picture(size,size); //new blank image
        
        size = size-1; // so that no pixel is out of bounds
        Color c = new Color (StdRandom.uniform(256),StdRandom.uniform(256),StdRandom.uniform(256));//random starting colour for the drawing of the flame
            while (iteration < sTest.getMaxIterations()) //THE CHAOS GAME ALGORITHM
        {
        	
            int index = StdRandom.uniform(sTest.getNumFunctions());
            p0 = applyFunction(sTest.getCx(),sTest.getCy(),index,p0,sTest.getVarWeights());
            c = setColor (sTest,c,index);
            if(iteration > 20 ) pic.set(Point.translateX(p0, size),Point.translateY(p0,size),(c));
            iteration++;
            arrayHit[Point.translateX(p0, size)][Point.translateY(p0,size)] ++; //hit pixel is recored
         
        } 
        int max_of_array = maxx(arrayHit);  //max of array
        
        for(int i=0;i<size;i++) //applying log density correction
        	for(int j=0;j<size;j++)
        	{
        		double intensity = Math.log1p(arrayHit[i][j])/Math.log1p(max_of_array);
        	    double gamma = Math.pow(intensity,0.25);  
        	    int correctedRed = (int) (pic.get(i, j).getRed()*gamma);
        	    int correctedGreen = (int) (pic.get(i, j).getGreen()*gamma);
        	    int correctedBlue = (int) (pic.get(i, j).getBlue()*gamma);
        	    Color corrected = new Color(correctedRed,correctedGreen,correctedBlue);
        	    
        	    pic.set(i,j,(corrected));
        	}
        	
        pic = (blurAll(pic));
        pic.show();
    }
    public static void main(String[] args)
    {
    	
    	
    	FractalFlames gui = new FractalFlames();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(220, 190);
		gui.setVisible(true);
		gui.setTitle("Fractal Flames");
		gui.setResizable(false);
    }
    
    private static Color modColor(Color c) { //this is some pretty advanced RGB stuff we won't get to until 
    										//probably a couple of weeks
    	int r = c.getRed(), g = c.getGreen(), b = c.getBlue();
    	double alpha = 1/2 * (2 * r - b - g);
    	double beta =  0.78736382838123 * (g - b);
    	
    	double chr = Math.sqrt(alpha * alpha + beta * beta); 
    	double hue = (Math.toDegrees(Math.atan2(beta, alpha)) + 360) % 360;
    	
    	double M = Math.max(Math.max(r, g), b);
    	double m = Math.min(Math.min(r, g), b);
    	
    	double lig = 1/2 * (M + m);
    	hue = hue / 360;
    	
    	double t = lig - 1/2 * chr; 
    	double x = chr * (1 - Math.abs(hue - 1));
    	Color result = new Color((int)(chr + t), (int)(x + t), (int)t);
    	return result;
    }
}

