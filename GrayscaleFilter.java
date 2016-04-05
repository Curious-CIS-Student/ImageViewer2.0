import java.awt.Color;

/**
 * Write a description of class GrayscaleFilter here.
 * 
 * @author Isaac Blasiman
 * @version 3.31.16
 */
public class GrayscaleFilter extends Filter
{
    /**
     * Constructor for objects of class GrayscaleFilter.
     * @param name The name of the filter.
     */
    public GrayscaleFilter(String name)
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
                int averageColorVal = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
                image.setPixel(x, y, new Color(averageColorVal, averageColorVal, averageColorVal));
            }
        }
    }
}
