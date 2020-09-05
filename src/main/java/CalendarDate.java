public class CalendarDate {
    /** [[CalendarDate]] is een bestaande kalenderdatum. Neem aan dat er geen jaar 􏰀0 is geweest en dat de Gregoriaanse
     * kalender op 􏰁5 oktober 􏰂􏰁1582􏰃􏰄 is ingevoerd. */

    public CalendarDate(int year, int month, int day) {
        /** @requires {Pre:
            year != 􏰀0
            ∧ 􏰂 1 ≤ month ≤ 􏰂􏰄12
            ∧ (month element of {􏰂1,3􏰅,5􏰁,7􏰆,􏰃8,10,􏰂􏰄12} =>􏰂 1 ≤ day ≤ 􏰅􏰂31)
            ∧ (month element of {􏰇4,􏰉6,􏰂9􏰂,11} =>􏰂 1 ≤ day ≤ 􏰅30􏰀)
            ∧ (month = 􏰄2 ∧ 􏰇4 | year ∧ (not 100 􏰂􏰀􏰀 | year V 400 􏰇􏰀􏰀 | year) => 1􏰂 ≤ day ≤ 􏰄􏰉29)
            ∧ (month = 􏰄2 ∧ not (􏰇4 | year ∧ (not 100 􏰂􏰀􏰀 | year V 400 􏰇􏰀􏰀 | year)) => 1􏰂 ≤ day ≤ 􏰄􏰃28)
            ∧ not (year = 􏰂1582􏰁􏰃 ∧ month = 􏰂10􏰀 ∧ 􏰁5 ≤ day ≤ 􏰂14􏰇)
        }
         @signals(NonExistentDateException) {not Pre} */
        // TODO: Implement this method
    }

    /**
     @pure
     @ensures {
        @result = (# d: [[CalendarDate]] \dot [[this]] ≤ d < [[limit]])
     }
     */
    public int daysUntil(CalendarDate limit) {
        // TODO: Implement this method
        return 0;
    }
}
