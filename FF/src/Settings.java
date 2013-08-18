package FF.src;
public class Settings {
	private int maxIterations;  //max iterations from console
	private int numFunctions; //number of F functions
	private double[] varWeights; //variation weights
	private double[][] cx; //update matrix for xs
	private double[][] cy; //update matrix for ys
	private int[] colors; //colours for each function F
	private int size;
	//set and get method for all class variables
	//nothing special
	public int getMaxIterations() {
		return maxIterations;
	}
	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}
	public int getNumFunctions() {
		return numFunctions;
	}
	public void setNumFunctions(int numFunctions) {
		this.numFunctions = numFunctions;
	}
	public double[] getVarWeights() {
		return varWeights;
	}
	public void setVarWeights(double[] varWeights) {
		this.varWeights = varWeights;
	}
	public double[][] getCx() {
		return cx;
	}
	public void setCx(double[][] cx) {
		this.cx = cx;
	}
	public double[][] getCy() {
		return cy;
	}
	public void setCy(double[][] cy) {
		this.cy = cy;
	}
	public int[] getColors() {
		return colors;
	}
	public void setColors(int[] colors) {
		this.colors = colors;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double[] makeRandomWeights (int length)
	{
		double[] a = new double[length]; // this takes a lengths and returns a 
		int sumB = 0;
		for(int i=0;i<length;i++)
			{
			a[i] = StdRandom.uniform(108);
			sumB += a[i];
			}
		for(int i=0;i<length;i++)
			a[i] /= sumB;
		
		return a;
		
	}
	public double[][] makeRandomAffines (int rowLength)
	{
		double[][] a = new double [rowLength] [3];
		for(int i=0;i<rowLength;i++)
			for(int j=0;j<3;j++)
			{
				if(StdRandom.random()<0.5) 	a[i][j] = StdRandom.random();
				else 						a[i][j] =-StdRandom.random();
			}
		return a;
	}
	public int[] makeRandomColors (int length)
	{
		int[] a = new int [3*length];
		for(int i=0;i<a.length;i++)
			a[i] = StdRandom.uniform(256);
		return a;
	}
	//predefined one variation only Flames:
	public static String LINEAR 		= "linear";
	public static String SINUSOIDAL 	= "sinusoidal";
	public static String SPHERICAL  	= "spherical";
	public static String HANDKERCHIEF   = "handkerchief";
	public static String SWIRL  		= "swirl";
	public static String HORSESHOE  	= "horseshoe";
	public static String POLAR 			= "polar";
	public static String SPIRAL			= "spiral";
	public static String DIAMOND		= "diamond";
	public static String JULIA			= "julia";
	public static String WAVES			= "waves";
	public static String POWER			= "power";
	public static String EYEFISH		= "eyefish";
	public static String CYLINDER		= "cylinder";
	public static String CROSS			= "cross";
	public static String HEART 			= "heart";
	public static String DISK			= "disk";
	public static String HYPERBOLIC		= "hyperbolic";
	public static String EX				= "ex";
	public static String BENT			= "bent";
	public static String EXPONENTIAL	= "exponential";
	public static String COSINE			= "cosine";
	public static String BUBBLE			= "bubble";
	public static String PERSPECTIVE	= "perspective";
			
	public static String[] Variations 	= {LINEAR,SINUSOIDAL,SPHERICAL,HANDKERCHIEF,SWIRL,HORSESHOE,POLAR,SPIRAL,DIAMOND,JULIA,WAVES,POWER,EYEFISH,CYLINDER,CROSS,HEART,DISK,HYPERBOLIC,EX,BENT,EXPONENTIAL,COSINE,BUBBLE,PERSPECTIVE};
	
	//more need to be added
	


	public double[] parseWeights (String Commands, int length)
	{
		double[] a = new double [length];
		if (Commands.equals(LINEAR)) 
		{
			a[0] = 1.0;
			return a;
		}
		if (Commands.equals(SINUSOIDAL)) 
		{
			a[1] = 1.0;
			return a;
		}
		if (Commands.equals(SPHERICAL)) 
		{
			a[2] = 1.0;
			return a;
		}
		if (Commands.equals(HANDKERCHIEF)) 
		{
			a[3] = 1.0;
			return a;
		}
		if (Commands.equals(SWIRL)) 
		{
			a[4] = 1.0;
			return a;
		}
		if (Commands.equals(HORSESHOE)) 
		{
			a[5] = 1.0;
			return a;
		}
		if (Commands.equals(POLAR)) 
		{
			a[6] = 1.0;
			return a;
		}
		if (Commands.equals(SPIRAL)) 
		{
			a[7] = 1.0;
			return a;
		}
		if (Commands.equals(DIAMOND)) 
		{
			a[8] = 1.0;
			return a;
		}
		if (Commands.equals(JULIA)) 
		{
			a[9] = 1.0;
			return a;
		}
		if (Commands.equals(WAVES)) 
		{
			a[10] = 1.0;
			return a;
		}
		if (Commands.equals(POWER)) 
		{
			a[11] = 1.0;
			return a;
		}
		if (Commands.equals(EYEFISH)) 
		{
			a[12] = 1.0;
			return a;
		}
		if (Commands.equals(CYLINDER)) 
		{
			a[13] = 1.0;
			return a;
		}
		if (Commands.equals(CROSS)) 
		{
			a[14] = 1.0;
			return a;
		}
		//HEART,DISK,HYPERBOLIC,EX,BENT,EXPONENTIAL,COSINE,BUBBLE,PERSPECTIVE
		if (Commands.equals(HEART)) 
		{
			a[15] = 1.0;
			return a;
		}
		if (Commands.equals(DISK)) 
		{
			a[16] = 1.0;
			return a;
		}
		if (Commands.equals(HYPERBOLIC)) 
		{
			a[17] = 1.0;
			return a;
		}
		if (Commands.equals(EX)) 
		{
			a[18] = 1.0;
			return a;
		}
		if (Commands.equals(BENT)) 
		{
			a[19] = 1.0;
			return a;
		}
		if (Commands.equals(EXPONENTIAL)) 
		{
			a[20] = 1.0;
			return a;
		}
		if (Commands.equals(COSINE)) 
		{
			a[21] = 1.0;
			return a;
		}
		if (Commands.equals(BUBBLE)) 
		{
			a[22] = 1.0;
			return a;
		}
		if (Commands.equals(PERSPECTIVE)) 
		{
			a[23] = 1.0;
			return a;
		}
		return makeRandomWeights(length);
	}
	public Settings(int imageSize, int maxiters) //default constructor - its going to fill everything with random values;
					  // image has size imageSize
	//for now we set the number of variations to 7
	{
		maxIterations 	= maxiters;
		numFunctions 	= StdRandom.uniform(80,100);
		varWeights 		= new double [24]; //this number is chosen for now - we will change it later
		varWeights 		= makeRandomWeights(varWeights.length);
		cx = new double [numFunctions] [3];
		cy = new double [numFunctions] [3];
		cx = makeRandomAffines(numFunctions);
		cy = makeRandomAffines(numFunctions);
		colors = new int[3*numFunctions];
		colors = makeRandomColors(colors.length);
		size = imageSize;
		
		
	}
	public Settings (int imageSize, int maxiters, String Commands) //only for single variation constructor
																  //affines are still random
	{
		maxIterations 	= maxiters;
		numFunctions 	= StdRandom.uniform(25,35);
		varWeights 		= new double [24]; //this number is chosen for now - we will change it later
		varWeights 		= parseWeights (Commands,varWeights.length);
		cx = new double [numFunctions] [3];
		cy = new double [numFunctions] [3];
		cx = makeRandomAffines(numFunctions);
		cy = makeRandomAffines(numFunctions);
		colors = new int[3*numFunctions];
		colors = makeRandomColors(colors.length);
		size = imageSize;
	}
	public Settings (int imageSize,int maxiters,int numfuncs,double[] vars)
	//this is constructor in which we set the number of affines and the 
	//variation weights but not the colors of the affines
	{
		maxIterations 	= maxiters;
		numFunctions 	= numfuncs;
		varWeights 		= new double [24]; //this number is chosen for now - we will change it later
		varWeights 		= vars;
		cx = new double [numFunctions] [3];
		cy = new double [numFunctions] [3];
		cx = makeRandomAffines(numFunctions);
		cy = makeRandomAffines(numFunctions);
		colors = new int[3*numFunctions];
		colors = makeRandomColors(colors.length);
		size = imageSize;
	}
	public static void main(String[] args)
	{
		Settings s1 = new Settings(512,1000000,"linear");
		System.out.println(s1.getMaxIterations());
		System.out.println(s1.getNumFunctions());
		for(int i=0;i<s1.getVarWeights().length;i++)
			System.out.print(s1.getVarWeights()[i] + " ");
		System.out.println();
		
		for(int i=0;i<s1.getNumFunctions();i++)
			{
			for(int j=0;j<3;j++)
				System.out.print(s1.getCx()[i][j] + " ");
			System.out.println();
			}
		for(int i=0;i<s1.getNumFunctions();i++)
		{
		for(int j=0;j<3;j++)
			System.out.print(s1.getCy()[i][j] + " ");
		System.out.println();
		}
		for(int i=0;i<s1.getColors().length;i++)
			System.out.print(s1.getColors()[i] + " ");
		System.out.println();
		System.out.println(s1.getSize());
		

}
}