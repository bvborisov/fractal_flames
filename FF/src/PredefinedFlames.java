package FF.src;
public class PredefinedFlames {
public static double[] setFlame(int length, double v1,double v2,double v3,double v4,double v5,double v6,double v7,double v8,double v9,double v10,double v11,double v12,double v13,double v14,double v15,double v16,double v17,double v18,double v19,double v20,double v21,double v22,double v23,double v24)
{ //length must be the number of variations - in our case just 7
	double[] a = new double[length];
	a[0] = v1;
	a[1] = v2;
	a[2] = v3;
	a[3] = v4;
	a[4] = v5;
	a[5] = v6;
	a[6] = v7;
	a[7] = v8;
	a[8] = v9;
	a[9] = v10;
	a[10] = v11;
	a[11] = v12;
	a[12] = v13;
	a[13] = v14;
	a[14] = v15;
	a[15] = v16;
	a[16] = v17;
	a[17] = v18;
	a[18] = v19;
	a[19] = v20;
	a[20] = v21;
	a[21] = v22;
	a[22] = v23;
	a[23] = v24;
	return a;
}
/*
 	public static String LINEAR 		= "linear";
	public static String SINUSOIDAL 	= "sinusoidal";
	public static String SPHERICAL  	= "spherical";
	public static String HANDKERCHIEF  = "handkerchief";
	public static String SWIRL  		= "swirl";
	public static String HORSESHOE  	= "horseshoe";
	public static String POLAR 		= "polar";
 */
static double[] sphericalLinear1 = setFlame(24,0.1,0,0.9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
static double[] polarHorseshoe1  = setFlame(24,0,0,0,0,0.5,0,0.5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
static double[] sinusoidalSpherical1 = setFlame(24,0,0.5,0.5,0.0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
static double[] sinusoidalSpherical2 = setFlame(24,0,0.1,0.9,0.0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

}
