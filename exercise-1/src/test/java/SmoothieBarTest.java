import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by surfkaru on 07/02/2017.
 */
public class SmoothieBarTest {

    final static int REQUIRED_ORANGES_TO_MAKE_A_ORANGE_AND_APPLE_SMOOTHIE = 2;
    final static int REQUIRED_APPLES_TO_MAKE_A_ORANGE_AND_APPLE_SMOOTHIE = 3;

    final static int REQUIRED_APPLES_TO_MAKE_A_BANANA_AND_APPLE_SMOOTHIE = 1;
    final static int REQUIRED_BANANAS_TO_MAKE_A_BANANA_AND_APPLE_SMOOTHIE = 2;

    final static int REQUIRED_ORANGES_TO_MAKE_A_ORANGE_AND_BANANA_SMOOTHIE = 3;
    final static int REQUIRED_BANANAS_TO_MAKE_A_ORANGE_AND_BANANA_SMOOTHIE = 1;




    SmoothieBar smoothieBar;

    // runs before each test, not before all tests.
    @Before
    public void initObjects() {
        smoothieBar = new SmoothieBar();
    }


//    @Test
//    public void helloNerdSchool() {
//        System.out.print("Hello NerdSchool");
//    }


    @Test
    public void canBlendOrangeAndAppleSmoothie() {
//        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(REQUIRED_APPLES_TO_MAKE_A_ORANGE_AND_APPLE_SMOOTHIE);
        smoothieBar.restockOranges(REQUIRED_ORANGES_TO_MAKE_A_ORANGE_AND_APPLE_SMOOTHIE);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        assertTrue(smoothie.getKind() == SmoothieKind.OrangeAndAppleSmoothie);

//        assertTrue(smoothie.getKind() == SmoothieKind.BananaAndAppleSmoothe); //laga en error i testen.
    }

    @Test
    public void blendingOrangesAndAppleSmoothieConsumesOrangesAndApples() {
//        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(REQUIRED_APPLES_TO_MAKE_A_ORANGE_AND_APPLE_SMOOTHIE);
        smoothieBar.restockOranges(REQUIRED_ORANGES_TO_MAKE_A_ORANGE_AND_APPLE_SMOOTHIE);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie); // bruka opp stocken, men bruka ikkje smoothie variablen.

        // testa deretter den faktiske stocken.
        assertTrue(smoothieBar.getApplesInStock() == 0);
        assertTrue(smoothieBar.getOrangesInStock() == 0);
    }

    /* Samme som over berre endra te exersice 3*/
    @Test
    public void blendingOrangesAndAppleSmoothieConsumesOrangesAndApples2() {
        smoothieBar.restockApples(REQUIRED_APPLES_TO_MAKE_A_ORANGE_AND_APPLE_SMOOTHIE);
        smoothieBar.restockOranges(REQUIRED_ORANGES_TO_MAKE_A_ORANGE_AND_APPLE_SMOOTHIE);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie); // bruka opp stocken, men bruka ikkje smoothie variablen.

        assertEquals("Fleire Eple igjen enn planlagt", 0, smoothieBar.getApplesInStock());
        assertEquals("Fleire Appelsine igjen enn planlagt!", 0, smoothieBar.getOrangesInStock());
    }



    @Test (expected = IllegalStateException.class) //expected sia vi forventa no at der e for lite banan sia vi ikkje har restocka.
    public void canBlendBananaAndAppleSmoothie() {
        smoothieBar.restockApples(REQUIRED_APPLES_TO_MAKE_A_BANANA_AND_APPLE_SMOOTHIE);
//        smoothieBar.restockBananas(0); // stocka kun 1 men trenge to sidan vi laga 2 smoothies, dårlig å gjere det sidan det blir å teste en ekstra ting unødvendig.

        Smoothie smoothie = smoothieBar.blend(SmoothieKind.BananaAndAppleSmoothe);

    }
    
}
