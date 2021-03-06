/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalLeftToRight()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalLeftToRight();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontalTopToBottom()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalTopToBottom();
    caterpillar.explore();
  }
  public static void testMirrorHorizontalBottomToTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBottomToTop();
    caterpillar.explore();
  }
  public static void testMirrorDiagonal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorDiagonal();
    caterpillar.explore();
  }
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.mirrorArms();
    snowman.explore();
  }
  
  public static void testMirrorSeagull()
  {
    Picture seagull = new Picture("seagull.jpg");
    seagull.mirrorSeagull();
    seagull.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.negate();
    beach.explore();
  }
  
  public static void testGrayscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.grayscale();
    beach.explore();
  }
  
  public static void testSepia()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.sepia();
    beach.explore();
  }
  
  public static void testPosterize()
  {     
      Picture john = new Picture("beach.jpg");
      john.explore();
      john.posterize();
      john.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVerticalRightToLeft();
    //testMirrorVerticalLeftToRight();
    //testMirrorHorizontalTopToBottom();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}