import java.awt.Color;

/**
 * Write a description of class EdgeDetectionFilter here.
 * 
 * @author Isaac Blasiman
 * @version 4.4.2016
 */
public class EdgeDetectionFilter extends Filter
{
  private final int maxPixels = 9;  
  
  /**
   * Constructor for objects of class EdgeDetectionFilter.
   * @param name The name of the filter.
   */
  public EdgeDetectionFilter(String name)
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
      for (int y = 0; y < height; ++y) {
          for (int x = 0; x < width; ++x) {
              int pixelNum = maxPixels;
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
              int maxRed = 0, minRed = 255, maxGreen = 0, minGreen = 255, maxBlue = 0, minBlue = 255;
              for(int y_offset = YMask_top; y_offset <= YMask_bottom; ++y_offset) {
                  for(int x_offset = XMask_left; x_offset <= XMask_right; ++x_offset) {
                      Color pixel = newImage.getPixel(x + x_offset, y + y_offset);
                      int redVal = pixel.getRed(), greenVal = pixel.getGreen(), blueVal = pixel.getBlue();
                      if (redVal > maxRed) {
                          maxRed = redVal;
                      }
                      if (redVal < minRed) {
                          minRed = redVal;
                      }
                      if (greenVal > maxGreen) {
                          maxGreen = greenVal;
                      }
                      if (greenVal < minGreen) {
                          minGreen = greenVal;
                      }
                      if (blueVal > maxBlue) {
                          maxBlue = blueVal;
                      }
                      if (blueVal < minBlue) {
                          minBlue = blueVal;
                      }
                  }
              }
              int redDif = (maxRed - minRed), greenDif = (maxGreen - minGreen), blueDif = (maxBlue - minBlue);
              image.setPixel(x, y, new Color(redDif, greenDif, blueDif));
            }
          }
      }
  }
  