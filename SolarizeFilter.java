import java.awt.Color;

/**
 * Write a description of class SolarizeFilter here.
 * 
 * @author Isaac Blasiman
 * @version 4.4.2016
 */
public class SolarizeFilter extends Filter
{
    /**
     * Constructor for objects of class SolarizeFilter.
     * @param name The name of the filter.
     */
    public SolarizeFilter(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x) {
                Color pixel = image.getPixel(x, y);
                int newRed, newGreen, newBlue;
                if (pixel.getRed() < 128){
                    newRed = 255 - pixel.getRed();
                } else {
                    newRed = pixel.getRed();
                }
                if (pixel.getGreen() < 128){
                    newGreen = 255 - pixel.getGreen();
                } else {
                    newGreen = pixel.getGreen();
                }
                if (pixel.getBlue() < 128){
                    newBlue = 255 - pixel.getBlue();
                } else {
                    newBlue = pixel.getBlue();
                }
                image.setPixel(x, y, new Color(newRed, newGreen, newBlue));
            }
        }
    }
}
