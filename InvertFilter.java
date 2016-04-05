import java.awt.Color;

/**
 * Write a description of class Invert here.
 * 
 * @author Isaac Blasiman 
 * @version 3.31.16
 */
public class InvertFilter extends Filter
{
    /**
     * Constructor for objects of class InvertFilter.
     * @param name The name of the filter.
     */
    public InvertFilter(String name)
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
                int newRed = 255 - pixel.getRed();
                int newGreen = 255 - pixel.getGreen();
                int newBlue = 255 - pixel.getBlue();
                image.setPixel(x, y, new Color(newRed, newGreen, newBlue));
            }
        }
    }
}
