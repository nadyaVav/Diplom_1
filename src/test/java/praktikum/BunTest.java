package praktikum;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class BunTest {

  private Bun bun;
  private String name;
  private float price;

  @Parameterized.Parameters
  public static Object[][] data() {
    return new Object[][] {
      {randomAlphabetic(10), new Random().nextFloat()},
      {null, 0.0f},
      {"Bun, Bun, Bun", 1.0f},
      {"Whole-wheat bun", 100.5f},
      {"", 5.0f},
      {"$%bun&*'", -150.0f},
      {"Longer name of bun", Float.MIN_VALUE},
      {"Super bun", Float.MAX_VALUE}
    };
  }

  public BunTest(String name, float price) {
    this.name = name;
    this.price = price;
  }

  @Before
  public void setUp() {
    bun = new Bun(name, price);
  }

  @Test
  public void shouldBeCorrectNameOfBun() {
    assertEquals("Incorrect name of bun", name, bun.getName());
  }

  @Test
  public void shouldBeCorrectPriceOfBun() {
    assertEquals("Incorrect price of bun", price, bun.getPrice(), 0);
  }
}