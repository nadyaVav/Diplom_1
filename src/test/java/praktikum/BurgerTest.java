package praktikum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

  private Burger burger;
  @Mock
  private Bun bun;
  @Mock
  private Ingredient ingredient1;
  @Mock
  private Ingredient ingredient2;

  @Before
  public void setUp() {
    burger = new Burger();
  }

  @Test
  public void shouldBeCorrectBun() {
    burger.setBuns(bun);
    assertEquals(bun, burger.bun);
  }

  @Test
  public void shouldBeAddIngredient() {
    burger.addIngredient(ingredient1);
    assertEquals(1, burger.ingredients.size());
    assertEquals(ingredient1, burger.ingredients.get(0));
  }

  @Test
  public void shouldBeRemoveIngredient() {
    burger.addIngredient(ingredient1);
    burger.removeIngredient(0);
    assertEquals(0, burger.ingredients.size());
    assertTrue(burger.ingredients.isEmpty());

  }

  @Test
  public void moveIngredient() {
    burger.addIngredient(ingredient1);
    burger.addIngredient(ingredient2);
    burger.moveIngredient(0, 1);
    assertEquals(ingredient1, burger.ingredients.get(1));
    assertEquals(ingredient2, burger.ingredients.get(0));
    assertEquals(2, burger.ingredients.size());

  }

  @Test
  public void shouldReturnCorrectPriceForBurger() {
    Mockito.when(bun.getPrice()).thenReturn(100f);
    Mockito.when(ingredient1.getPrice()).thenReturn(50f);
    Mockito.when(ingredient2.getPrice()).thenReturn(50f);
    burger.setBuns(bun);
    burger.addIngredient(ingredient1);
    burger.addIngredient(ingredient2);
    assertEquals(300f, burger.getPrice(),0);
    Mockito.verify(bun, Mockito.times(1)).getPrice();
    Mockito.verify(ingredient1, Mockito.times(1)).getPrice();

  }

  @Test
  public void shouldReturnReceipt() {
    String expectedReceipt =
      String.format("%s%n", "(==== whole-wheat bun ====)")
        + String.format("%s%n", "= filling Beef cutlet =")
        + String.format("%s%n", "= sauce Ketchup =")
        + String.format("%s%n", "(==== whole-wheat bun ====)")
        + String.format("%n%s%n", "Price: 230,000000");

    Mockito.when(bun.getName()).thenReturn("whole-wheat bun");
    Mockito.when(bun.getPrice()).thenReturn(50f);

    Mockito.when(ingredient1.getName()).thenReturn("Beef cutlet");
    Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
    Mockito.when(ingredient1.getPrice()).thenReturn(100f);

    Mockito.when(ingredient2.getName()).thenReturn("Ketchup");
    Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
    Mockito.when(ingredient2.getPrice()).thenReturn(30f);

    burger.setBuns(bun);
    burger.addIngredient(ingredient1);
    burger.addIngredient(ingredient2);
    assertEquals(expectedReceipt, burger.getReceipt());



  }
}