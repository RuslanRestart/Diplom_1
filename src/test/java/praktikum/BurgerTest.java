package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BurgerTest {

    @Test
    public void burgerBunCannotBeNullTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("Краторная булка", 1255));
        assertNotNull("Burger's bun can't be null!", burger.bun);
    }

    @Test
    public void ingredientAddedToIngredientsListTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        if (!burger.ingredients.isEmpty()) {
            Ingredient ingredient = burger.ingredients.get(0);
            assertEquals("Ingredients names must be equal", "Говяжий метеорит (отбивная)", ingredient.getName());
            MatcherAssert.assertThat("Expected ingredient price is not equals actual price", ingredient.getPrice(), is(3000f));
            assertEquals("Method getType() must returns a correct type!", IngredientType.FILLING, ingredient.getType());
        } else Assert.fail("Ingredients list is empty!");
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15));
        burger.removeIngredient(0);
        assertTrue("Burger has ingredient!", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142));
        Ingredient filling = burger.ingredients.get(2);
        burger.moveIngredient(2, 1);
        Ingredient sauce = burger.ingredients.get(2);
        assertNotEquals("The ingredients must be different!", filling, sauce);
        assertEquals("The ingredients must be equal!", filling, burger.ingredients.get(1));
    }

    @Test
    public void getBurgerPriceIsMoreThan0Test(){
        Burger burger = new Burger();
        burger.setBuns(new Bun("Краторная булка", 1255));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15));
        burger.setBuns(new Bun("Краторная булка", 1255));
        assertTrue("The price of a burger must exceed 0!", burger.getPrice() > 0);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();
        burger.setBuns(new Bun("Краторная булка", 1255));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142));
        String expectedReceipt = "(==== Краторная булка ====)\r\n" +
                "= sauce Соус традиционный галактический =\r\n" +
                "= filling Сыр с астероидной плесенью =\r\n" +
                "(==== Краторная булка ====)\r\n" +
                "\r\n" +
                "Price: 6667,000000\r\n";
        assertEquals("The receipts must be equal", expectedReceipt, burger.getReceipt());
    }





}
