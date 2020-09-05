import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalendarDateTest {

    /*
     * CONSTRUCTOR TESTS
     * These tests only test for constructions of valid dates
    */
    // NDo: 36 testcases for the constructor.

    //  year != 􏰀0
    @Test
    public void yearZeroTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(0, 1, 1));
    }

    //  year != 􏰀0
    @Test
    public void yearOneTest() {
        Assertions.assertDoesNotThrow(() -> new CalendarDate(1, 1, 1));
    }

    //  year != 􏰀0
    @Test
    public void yearMinusOneTest() {
        Assertions.assertDoesNotThrow(() -> new CalendarDate(-1, 1, 1));
    }

    // 1 ≤ month ≤ 􏰂􏰄12
    @Test
    public void monthZeroTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 0, 1));
    }

    // 1 ≤ month ≤ 􏰂􏰄12
    @Test
    public void monthOneTest() {
        Assertions.assertDoesNotThrow(() -> new CalendarDate(1, 1, 1));
    }

    // 1 ≤ month ≤ 􏰂􏰄12
    @Test
    public void monthTwelveTest() {
        Assertions.assertDoesNotThrow(() -> new CalendarDate(1, 12, 1));
    }

    // 1 ≤ month ≤ 􏰂􏰄12
    @Test
    public void monthThirteenTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 13, 1));
    }

    // (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
    @Test
    public void dayZeroTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 1, 0));
    }

    // (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
    @Test
    public void dayThirtyTwoTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 1, 32));
    }

    // (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
    @Test
    public void thirtyOneDaysTest() {
        Assertions.assertDoesNotThrow(() -> {
            new CalendarDate(1, 1, 31);
            new CalendarDate(1, 3, 31);
            new CalendarDate(1, 5, 31);
            new CalendarDate(1, 7, 31);
            new CalendarDate(1, 8, 31);
            new CalendarDate(1, 10, 31);
            new CalendarDate(1, 12, 31);
        });
    }

    // (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
    @Test
    public void februaryTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 2, 31));
    }

    // (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
    @Test
    public void aprilTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 4, 31));
    }

    // (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
    @Test
    public void juneTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 6, 31));
    }

    // (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
    @Test
    public void septemberTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 9, 31));
    }

    // (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
    @Test
    public void novemberTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1, 11, 31));
    }

    // (month element of {􏰇4,􏰉6,􏰂9􏰂,11} =>􏰂 1 ≤ day ≤ 􏰅30􏰀)
    @Test
    public void ThirtyDaysTest() {
        Assertions.assertDoesNotThrow(() -> {
            new CalendarDate(1, 1, 31);
            new CalendarDate(1, 4, 30);
            new CalendarDate(1, 6, 30);
            new CalendarDate(1, 9, 30);
            new CalendarDate(1, 11, 30);
        });
    }

    // (month = 􏰄2 ∧ 􏰇4 | year ∧ (not 100 􏰂􏰀􏰀 | year V 400 􏰇􏰀􏰀 | year) => 1􏰂 ≤ day ≤ 􏰄􏰉29)
    @Test
    public void leapYearsTest() {
        Assertions.assertDoesNotThrow(() -> {
            new CalendarDate(4, 2, 29);
            new CalendarDate(2000, 2, 29);
        });
    }

    // (month = 􏰄2 ∧ 􏰇4 | year ∧ (not 100 􏰂􏰀􏰀 | year V 400 􏰇􏰀􏰀 | year) => 1􏰂 ≤ day ≤ 􏰄􏰉29)
    @Test
    public void notLeapYearsTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(2019, 2, 29));
    }

    // (month = 􏰄2 ∧ 􏰇4 | year ∧ (not 100 􏰂􏰀􏰀 | year V 400 􏰇􏰀􏰀 | year) => 1􏰂 ≤ day ≤ 􏰄􏰉29)
    @Test
    public void quadCenturyLeapYearsTest() {
        Assertions.assertDoesNotThrow(() -> new CalendarDate(2000, 2, 29));
    }

    // (month = 􏰄2 ∧ 􏰇4 | year ∧ (not 100 􏰂􏰀􏰀 | year V 400 􏰇􏰀􏰀 | year) => 1􏰂 ≤ day ≤ 􏰄􏰉29)
    @Test
    public void centuryNotLeapYearsTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(100, 2, 29));
    }

    // (month = 􏰄2 ∧ not (􏰇4 | year ∧ (not 100 􏰂􏰀􏰀 | year V 400 􏰇􏰀􏰀 | year)) => 1􏰂 ≤ day ≤ 􏰄􏰃28)
    @Test
    public void nonLeapYearsTest() {
        Assertions.assertDoesNotThrow(() -> new CalendarDate(1999, 2, 28));
    }

    // not (year = 􏰂1582􏰁􏰃 ∧ month = 􏰂10􏰀 ∧ 􏰁5 ≤ day ≤ 􏰂14􏰇)
    @Test
    public void existingDateFourthOfOctoberTest() {
        Assertions.assertDoesNotThrow(() -> new CalendarDate(1528, 10, 4));
    }

    // not (year = 􏰂1582􏰁􏰃 ∧ month = 􏰂10􏰀 ∧ 􏰁5 ≤ day ≤ 􏰂14􏰇)
    @Test
    public void nonExistingDateFifthOfOctoberTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1528, 10, 5));
    }

    // not (year = 􏰂1582􏰁􏰃 ∧ month = 􏰂10􏰀 ∧ 􏰁5 ≤ day ≤ 􏰂14􏰇)
    @Test
    public void nonExistingDateFourteenthOfOctoberTest() {
        Assertions.assertThrows(NonExistentDateException.class, () -> new CalendarDate(1528, 10, 14));
    }

    // not (year = 􏰂1582􏰁􏰃 ∧ month = 􏰂10􏰀 ∧ 􏰁5 ≤ day ≤ 􏰂14􏰇)
    @Test
    public void existingDateFifteenthOfOctoberTest() {
        Assertions.assertDoesNotThrow(() -> new CalendarDate(1528, 10, 15));
    }

    /*
     * DAYS UNTIL TESTS
     *
     * Dit is een hele andere aanpak dan de constructor. Bij de constructor is de specificatie heel goed
     * te gebruiken als basis voor de testgevallen, bij de daysUntil moet je echt zelf een strategie bedenken
     * die gebruik maakt van de kennis van de specificatie van de constructor om goede testgevallen te bedenken
     * Ook moet je hier veel meer algoritmisch denken. Hoeveel dagen tot 10 mei vanaf 24 feb 2020.
     * Of hoeveel dagen van 31 december -1 tot 1 januari 1. Bij de constructor is het veel duidelijker, dit
     * mag wel, dat mag niet.
     */

    @Test
    public void tomorrowTest() {
        CalendarDate date = new CalendarDate(2020, 10, 14);
        CalendarDate limit = new CalendarDate(2020, 10, 15);
        Assertions.assertEquals(1, date.daysUntil(limit), "Tomorrow test failed");
    }

    @Test
    public void yesterdayTest() {
        CalendarDate date = new CalendarDate(2020, 10, 14);
        CalendarDate limit = new CalendarDate(2020, 10, 13);
        Assertions.assertEquals(0, date.daysUntil(limit), "Yesterday test failed");
    }

    @Test
    public void todayTest() {
        CalendarDate date = new CalendarDate(2020, 10, 14);
        CalendarDate limit = new CalendarDate(2020, 10, 14);
        Assertions.assertEquals(0, date.daysUntil(limit), "Today test failed");
    }

    @Test
    public void thirtyOneDaysMonthTest() {
        CalendarDate date = new CalendarDate(2020, 1, 29);
        CalendarDate limit = new CalendarDate(2020, 2, 1);
        Assertions.assertEquals(3, date.daysUntil(limit), "Month with 31 days test failed");
    }

    @Test
    public void thirtyDaysMonthTest() {
        CalendarDate date = new CalendarDate(2020, 11, 29);
        CalendarDate limit = new CalendarDate(2020, 12, 1);
        Assertions.assertEquals(2, date.daysUntil(limit), "Month with 30 days test failed");
    }

    @Test
    public void leapYearTest() {
        CalendarDate date = new CalendarDate(2020, 2, 28);
        CalendarDate limit = new CalendarDate(2020, 3, 1);
        Assertions.assertEquals(2, date.daysUntil(limit), "Leap year test failed");
    }

    @Test
    public void nonLeapYearTest() {
        CalendarDate date = new CalendarDate(2019, 2, 28);
        CalendarDate limit = new CalendarDate(2019, 3, 1);
        Assertions.assertEquals(1, date.daysUntil(limit), "Non leap year test failed");
    }

    @Test
    public void nonLeapYearCenturyTest() {
        CalendarDate date = new CalendarDate(1900, 2, 28);
        CalendarDate limit = new CalendarDate(1900, 3, 1);
        Assertions.assertEquals(1, date.daysUntil(limit), "Non leap year test failed");
    }

    @Test
    public void leapYearQuadCenturyTest() {
        CalendarDate date = new CalendarDate(2000, 2, 28);
        CalendarDate limit = new CalendarDate(2000, 3, 1);
        Assertions.assertEquals(2, date.daysUntil(limit), "Non leap year test failed");
    }

    // TODO NDo: 1582 tests

    // TODO NDo: extra tests zoals over de jaargrens? Over twee jaar?

    // TODO NDo: maxint overflow test?
}
