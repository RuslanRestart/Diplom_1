package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Mock
    private Bun bunMock;

    @Test
    public void getBunNameTest(){
        Mockito.when(bunMock.getName()).thenReturn("Краторная булка");
        assertEquals("Method getPrice() must returns a correct name!", "Краторная булка", bunMock.getName());
    }

    @Test
    public void getBunNameIsNotNullTest(){
        Mockito.when(bunMock.getName()).thenReturn("Краторная булка");
        assertNotNull("Bun name can't be null!", bunMock.getName());
    }

    @Test
    public void getBunPriceTest(){
        Mockito.when(bunMock.getPrice()).thenReturn(988f);
        MatcherAssert.assertThat("Method getPrice() must returns a correct price!", bunMock.getPrice(), is(988f));
    }

    @Test
    public void getBunPriceIsMoreThan0Test(){
        Mockito.when(bunMock.getPrice()).thenReturn(988f);
        assertTrue("The price of a bun must exceed 0!", bunMock.getPrice() > 0);
    }
}
