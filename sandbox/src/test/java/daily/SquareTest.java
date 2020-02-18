package daily;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_course.sandbox.Square;

public class SquareTest {

    @Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area(),2.50,3);


    }
}
