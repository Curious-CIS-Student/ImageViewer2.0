import java.awt.Color;
import java.lang.Number;

/**
 * Write a description of class SepiaFilter here.
 * 
 * @author Isaac Blasiman
 * @version 4.4.2016
 */
public class SepiaFilter extends Filter
{
    /**
     * Constructor for objects of class SepiaFilter.
     * @param name The name of the filter.
     */
    public SepiaFilter(String name)
    {
        super(name);
    }
    
    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int averageColorVal, redValue, greenValue, blueValue;
        int height = image.getHeight();
        int width = image.getWidth();
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                Color pixel = image.getPixel(x, y);
                averageColorVal = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                redValue = averageColorVal * 58/100;
                greenValue = averageColorVal * 30/100;
                blueValue = averageColorVal * 12/100;
                image.setPixel(x, y, new Color(redValue, greenValue, blueValue));
            }
        }
    }
}
