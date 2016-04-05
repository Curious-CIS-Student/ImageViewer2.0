import java.awt.Color;

/**
 * Write a description of class SmoothFilter here.
 * 
 * @author Isaac Blasiman 
 * @version 3.31.16
 */

public class SmoothFilter extends Filter
{
    private final int maxPixels = 9;
    
    /**
     * Constructor for objects of class InvertFilter.
     * @param name The name of the filter.
     */
    public SmoothFilter(String name)
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
        int XMask_left, XMask_right, YMask_top, YMask_bottom;
        OFImage newImage = new OFImage(image);
        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x) {
                int pixelNum = maxPixels;
                // Figure out how many surrounding pixels we want to iterate over. If we're on an edge or a corner,
                // only some of the usuall 8 surrounding pixels exist, so we don't want to access them.
                if (x == 0) {
                    XMask_left = 0;
                    pixelNum = pixelNum * 2/3;
                } else {
                    XMask_left = -1;
                }
                if (x == width-1) {
                    XMask_right = 0;
                    pixelNum = pixelNum * 2/3;
                } else {
                    XMask_right = 1;
                }
                if (y == 0) {
                    YMask_top = 0;
                    pixelNum = pixelNum * 2/3;
                } else {
                    YMask_top = -1;
                }
                if (y == height-1) {
                    pixelNum = pixelNum * 2/3;
                    YMask_bottom = 0;
                } else{
                    YMask_bottom = 1;
                }
                // Sum up the color values of the pixel and up to 8 surrounding pixels.
                int redSum = 0, greenSum = 0, blueSum = 0;
                for(int y_offset = YMask_top; y_offset <= YMask_bottom; ++y_offset) {
                    for(int x_offset = XMask_left; x_offset <= XMask_right; ++x_offset) {
                        Color pixel = newImage.getPixel(x + x_offset, y + y_offset);
                        redSum += pixel.getRed();
                        greenSum += pixel.getGreen();
                        blueSum += pixel.getBlue();
                    }
                }
                //Get color averages for red, green, and blue.
                int redAverage = redSum/pixelNum, greenAverage = greenSum/pixelNum, blueAverage = blueSum/pixelNum;
                image.setPixel(x, y, new Color(redAverage, greenAverage, blueAverage));
            }
        }
    }
}
