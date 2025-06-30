package com.purplemesh.functionalprograms;

class Wind {
        
        public double calculateWindChill(double t, double v) 
		 {
		        return 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
		        
		 }
}
  
class WindChill
{
	
	public static void main(String[] args)
	{
		Wind w=new Wind();
		double t = Double.parseDouble(args[0]);
        double v = Double.parseDouble(args[1]);
        
        if (Math.abs(t) > 50 || v < 3 || v > 120) {
            System.out.println("Invalid input=> Temprature must be < 50 degrees windspeed 3 to 120 mph");
            return;
        }
		double result = w.calculateWindChill(t, v);

        System.out.printf("Temperature: %.2f degirs F, Wind Speed: %.2f mph%n", t, v);
        System.out.printf("Calculated Wind Chill: %.2f degris F%n", result);
		
	}
}
	

	
   

