package daily;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {


@Test
public void Point(){
  int x1=1;
  int x2=2;
  int y1=3;
  int y2=4;
  double dis;
  dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
  System.out.println("distancebetween"+"("+x1+","+y1+"),"+"("+x2+","+y2+")===>"+dis);
  Assert.assertFalse(dis==5);
  }

  @Test
  public void Points() {
    int x=3;
    int y=4;
    double dis;
    dis=Math.sqrt((x-y)*(x-y));
    System.out.println("distancebetween"+"("+x+","+y+")===>"+dis);
    Assert.assertTrue(dis==1);
  }
}

