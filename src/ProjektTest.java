import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProjektTest {

    @Test
    public void test() {
	Wand wand = new Wand(8, 6);
	assertEquals(48, wand.flaeche(), 0.002);
    }

}
