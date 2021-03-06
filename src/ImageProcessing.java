import java.io.*;
import javax.imageio.*;

import java.awt.Color;
import java.awt.image.*;

public class ImageProcessing {
	
	public static void main(String args[]) throws IOException{
		
		BufferedImage raw, processed;
		
		raw= ImageIO.read(new File("flower.png"));
		
		int width= raw.getWidth();
		int height= raw.getHeight();
		processed= new BufferedImage(width,height,raw.getType());
		float hue= 90/360.0f;//hard coded hue value
//		float hue2= 19/360.0f;
//		float hue3= 230/360.0f;
		
		for(int y=0; y<height;y++){
			
			for(int x=0;x<width;x++){
				
				//this is how we grab the RGBvalue of a pixel at x,y coordinates in the image
				int rgb = raw.getRGB(x,y);
				
				//extract the red value
				int r = (rgb >> 16) & 0xFF;
				
				//extract the green value
				int g = (rgb >> 8) & 0xFF;
				
				//extract the blue value
				int b  = rgb & 0xFF;
				
				float[] hsb = Color.RGBtoHSB(r, g, b, null);
				
				int newRGB = Color.HSBtoRGB(hue, hsb[1], hsb[2]);
				
				//user Color.RGBtoHSB() method to convert RGB values to HSB
				//then use Color.HSBtoRGB() method to convert the HSB value to a newRGB 
				//value
				//set the new RGBvalue to a pixel at x,y coordinates in the image 
				processed.setRGB(x,y,newRGB);
				}
			}
		ImageIO.write(processed,"PNG",new File("processed.png"));
	}
}
