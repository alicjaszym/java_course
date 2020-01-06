package daily;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class PointTest {


  @Test
  public void Point() {
    Point p1 = new Point(1, 3);
    Point p2 = new Point(4,3);

    Assert.assertTrue(p1.distance(p2)==3.0);
  }
}