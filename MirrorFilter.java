import java.awt.Color;

/**
 * Write a description of class MirrorFilter here.
 * 
 * @author Isaac Blasiman 
 * @version 3.31.16
 */

public class MirrorFilter extends Filter
{
    /**
     * Constructor for objects of class MirrorFilter.
     * @param name The name of the filter.
     */
    public MirrorFilter(String name)
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
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < (width/2); ++x) {
                // get the left and right pixels that we want to switch.
                Color leftPixel = image.getPixel(x, y);
                int rightXPos = width - 1 - x;
                Color rightPixel = image.getPixel(rightXPos, y);
                // switch the pixels.
                image.setPixel(x, y, rightPixel);
                image.setPixel(rightXPos, y, leftPixel);
            }
        }
    }
}
