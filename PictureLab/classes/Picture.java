import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
 public void zeroRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
      }
    }
  }
  
  public void zeroGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());
        pixelObj.setRed(255-pixelObj.getRed());
      }
    }
  }
  
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int gray = (pixelObj.getGreen()+pixelObj.getBlue()+pixelObj.getRed())/3;
        pixelObj.setGreen(gray);
        pixelObj.setBlue(gray);
        pixelObj.setRed(gray);
      }
    }
  }
  
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
         pixelObj.setRed((int)(pixelObj.getRed()*4));
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVerticalLeftToRight()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  } 
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorHorizontalTopToBottom()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height-1-row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorHorizontalBottomToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height-1-row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorDiagonal()
  {
    //WHATEVER THE BOTTOM LEFT PIXEL IS, THAT GOES TO THE INVERSE [ROW][COL] FOR TOP RIGHT PIXEL
    //SUB STRING LAB WITH INTERDEPENDENT FOR LOOPS TO ITTERATE CORRECTLY THROUGH BOTTOM LEFT PIXELS
    //[1,0]=>[0,1]   [2,0]=>[0,2]    [2,1]=>[1,2]
    int shortest = 0;
    Pixel[][] pixels = this.getPixels2D();
    Pixel bottomLeftPixel = null;
    Pixel topRightPixel = null;
    Pixel topLeftPixel = null;
    Pixel bottomRightPixel = null;
    int height = pixels.length;
    int width = pixels[0].length;
    if (height>width)
    {
        shortest = width;
    }
    else
    {
        shortest = height;
    }
    for (int row = 0; row < shortest; row++)
    {
      for (int col = 0; col < shortest; col++)
      {
        bottomLeftPixel = pixels[row][col];
        topRightPixel = pixels[col][row];
        topRightPixel.setColor(bottomLeftPixel.getColor());
      }
    } 
    
    
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  public void mirrorArms()
  {
    int mirrorPoint = 207;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 170; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 104; col < 170; col++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint+(mirrorPoint-row)][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
    for (int row = 170; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 239; col < 294; col++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint+(mirrorPoint-row)]                       
                         [col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }
  public void mirrorSeagull()
  {
    int mirrorPoint = 361;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 235; row < 319; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 235; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint-col+mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorJohnRight()
  {
      int mirrorPoint = 86;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel[][] pixels = this.getPixels2D();
      for (int row=3; row<60;row++)
      {
          for (int col=47; col<mirrorPoint; col++)
          {
              leftPixel = pixels[row][col];
              rightPixel = pixels[row][mirrorPoint-col+mirrorPoint];
              rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
  public void sepia()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if (pixelObj.getRed()<60)
        {
            pixelObj.setRed((int)(pixelObj.getRed()*.9));
            pixelObj.setGreen((int)(pixelObj.getGreen()*.9));
            pixelObj.setBlue((int)(pixelObj.getBlue()*.9));
        }
        else if(pixelObj.getRed()<190)
        {
            pixelObj.setBlue((int)(pixelObj.getBlue()*.8));
        }
        else
        {
            pixelObj.setBlue((int)(pixelObj.getBlue()*.9));
        }
      }
    }
  }
  
  public void posterize()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        //red
        if (pixelObj.getRed()<32)
        {
            pixelObj.setRed(16);
        }
        else if (pixelObj.getRed()<64)
        {
            pixelObj.setRed(48);
        }
        else if (pixelObj.getRed()<96)
        {
            pixelObj.setRed(70);
        }
        else if (pixelObj.getRed()<128)
        {
            pixelObj.setRed(102);
        }
        else if (pixelObj.getRed()<160)
        {
            pixelObj.setRed(134);
        }
        else if (pixelObj.getRed()<192)
        {
            pixelObj.setRed(166);
        }
        else if (pixelObj.getRed()<224)
        {
            pixelObj.setRed(198);
        }
        else 
        {
            pixelObj.setRed(230);
        }
        
        //green
        if (pixelObj.getGreen()<32)
        {
            pixelObj.setGreen(16);
        }
        else if (pixelObj.getGreen()<64)
        {
            pixelObj.setGreen(48);
        }
        else if (pixelObj.getGreen()<96)
        {
            pixelObj.setGreen(70);
        }
        else if (pixelObj.getGreen()<128)
        {
            pixelObj.setGreen(102);
        }
        else if (pixelObj.getGreen()<160)
        {
            pixelObj.setGreen(134);
        }
        else if (pixelObj.getGreen()<192)
        {
            pixelObj.setGreen(166);
        }
        else if (pixelObj.getGreen()<224)
        {
            pixelObj.setGreen(198);
        }
        else 
        {
            pixelObj.setGreen(230);
        }
        //blue
        if (pixelObj.getBlue()<32)
        {
            pixelObj.setBlue(16);
        }
        else if (pixelObj.getBlue()<64)
        {
            pixelObj.setBlue(48);
        }
        else if (pixelObj.getBlue()<96)
        {
            pixelObj.setBlue(70);
        }
        else if (pixelObj.getBlue()<128)
        {
            pixelObj.setBlue(102);
        }
        else if (pixelObj.getBlue()<160)
        {
            pixelObj.setBlue(134);
        }
        else if (pixelObj.getBlue()<192)
        {
            pixelObj.setBlue(166);
        }
        else if (pixelObj.getBlue()<224)
        {
            pixelObj.setBlue(198);
        }
        else 
        {
            pixelObj.setBlue(230);
        }
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void mirrorArchTop()
  {
      int mirrorPoint = 125;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 10; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 120; col < 280; col++)
      {
        
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint+(mirrorPoint-row)][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
    }
  public void mirrorArchRight()
  {
    int mirrorPoint = 280;
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 86; row <167; row++)
    {
      for (int col = 341; col >274; col--)
      {
        rightPixel = pixels[row][col];      
        leftPixel = pixels[row][mirrorPoint-(col-mirrorPoint)];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
    }
 
  

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVerticalLeftToRight();
    this.write("collage.jpg");
  }
  
  public void mirrorArch1()
  {
      int mirrorPoint = 100;
      Pixel topPixel = null;
      Pixel bottomPixel = null;
    
      Pixel[][] pixels = this.getPixels2D();
    
        for (int row = 0; row < mirrorPoint; row++)
        {
          for (int col = 87; col < 311; col++)
          {
            topPixel = pixels[row][col];      
            bottomPixel = pixels[mirrorPoint+(mirrorPoint-row)][col];
            bottomPixel.setColor(topPixel.getColor());
          }
        }
    }
  
  
  public void createMyCollage(Picture pic)
  {
<<<<<<< HEAD
      Picture arch = new Picture("arch.jpg");
      pic.copy(arch,0,0);
      pic.copy(arch,500,800);
      arch.negate();
      arch.mirrorVerticalRightToLeft();
      arch.mirrorArch1();
      pic.copy(arch,250,400);
=======
      Picture arch1 = new Picture("arch.jpg");
      Picture arch2 = new Picture("arch.jpg");
      Picture arch3 = new Picture("arch.jpg");
      Picture arch4 = new Picture("arch.jpg");
      Picture arch5 = new Picture("arch.jpg");
      Picture arch6 = new Picture("arch.jpg");
      Picture arch7 = new Picture("arch.jpg");
      
      pic.copy(arch1,0,0);
      
      arch2.zeroRed();
      pic.copy(arch2,500,800);
      
      arch3.zeroBlue();
      pic.copy(arch3,500,0);
      
      arch4.zeroGreen();
      pic.copy(arch4,0,800);
      
      arch1.mirrorArchTop();
      arch1.grayscale();
      arch1.mirrorVerticalRightToLeft();
      pic.copy(arch1,250,400);
      
      //Picture john = new Picture("john.jpg");
      //pic.copy(john,330,535);
      
      arch5.posterize();
      arch5.mirrorHorizontalTopToBottom();
      arch5.mirrorVerticalRightToLeft();
      pic.copy(arch5,250,0);
      pic.copy(arch5,250,800);
      
      arch6.mirrorDiagonal();
      arch7.mirrorDiagonal();
      arch6.posterize();
      arch7.posterize();
      arch6.mirrorVerticalLeftToRight();
      arch7.mirrorVerticalLeftToRight();
      arch6.mirrorHorizontalTopToBottom();
      arch7.mirrorHorizontalBottomToTop();
      pic.copy(arch6,0,400);
      pic.copy(arch7,500,400);
      
>>>>>>> origin/master
      pic.explore();
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture canvas = new Picture(750,1200);
    canvas.createMyCollage(canvas);
  }
  
} // this } is the end of class Picture, put all new methods before this
