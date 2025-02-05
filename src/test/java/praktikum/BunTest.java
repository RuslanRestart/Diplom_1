package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getBunNameTest(){
        Bun bun = new Bun("Краторная булка", 1255);
        assertEquals("Method getPrice() must returns a correct name!", "Краторная булка", bun.getName());
    }

    @Test
    public void getBunNameIsNotNullTest(){
        Bun bun = new Bun("Краторная булка", 1255);
        assertNotNull("Bun name can't be null!", bun.getName());
    }

    @Test
    public void getBunPriceTest(){
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        MatcherAssert.assertThat("Method getPrice() must returns a correct price!", bun.getPrice(), is(988f));
    }

    @Test
    public void getBunPriceIsMoreThan0Test(){
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 223);
        assertTrue("The price of a bun must exceed 0!", bun.getPrice() > 0);
    }
}
