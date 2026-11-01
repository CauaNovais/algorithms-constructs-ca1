# Manual testing results

Test date: 27 October 2026
Environment: macOS, OpenJDK 25.0.4.1
Tests were performed manually during development.

| Test | Expected result | Observed result | Status |
|---|---|---|---|
| Add Burger with valid details | Details displayed correctly | Name, weight, date and timestamp displayed | Pass |
| Negative weight (-100 g) | Reject item | Validation message displayed | Pass |
| LIFO removal: add Burger, then Pizza | Remove Pizza first | Pizza removed; Burger became top | Pass |
| Pop and peek on empty stack | Return null | Both returned null | Pass |
| Display two items | Pizza before Burger | Correct top-to-bottom order | Pass |
| Search "burger" | Find Burger ignoring case | Burger found | Pass |
| Search for absent Fries | No match | Not found | Pass |
| Search preserves stack | Size 2, top Pizza | Size and top unchanged | Pass |
| Fill all 8 positions | Accept 8 items | All additions returned true | Pass |
| Add ninth item | Reject; size remains 8 | Returned false; size 8 | Pass |
| Add after removing from full stack | Accept new item | Pizza added; size returned to 8 | Pass |
| Best-before today (2026-10-27) | Accept | Item added | Pass |
| Best-before +14 days (2026-11-10) | Accept | Item added | Pass |
| Best-before +15 days (2026-11-11) | Reject | Date validation message displayed | Pass |
| Past date (2026-10-26) | Reject without changing storage | Validation message; size remained 1 | Pass |
| Invalid date input ("1") | Reject without crashing | Format message; menu continued | Pass |
| Exit using 0 | End application | Goodbye displayed | Pass |
| Text instead of weight ("abc") | Reject without crashing | Weight error displayed; menu continued; size 0 | Pass |
| Unknown food name ("Sushi") | Reject item | Allowed food names displayed; item not added | Pass |
| Invalid calendar date (2026-11-31) | Reject without crashing | Date format message displayed; menu continued | Pass |
| Invalid menu choice ("9") | Reject and continue | Valid menu options displayed; menu continued | Pass |
| Blank search input | Reject and continue | Search name is required; menu continued | Pass |
| NaN weight | Reject item | Weight validation message displayed; size 0 | Pass |
| Infinity weight | Reject item | Weight validation message displayed; size 0 | Pass |
| Blank food name | Reject item | Allowed food names displayed; size 0 | Pass |
## NetBeans verification on 28 October 2026

Environment: Apache NetBeans 15, JDK 17.0.11.

Added Burger (250 g, best-before 2026-11-04).
Peek displayed the item without removing it; size remained 1.
Exit displayed Goodbye and BUILD SUCCESSFUL.

## Verification after FoodStorage interface changes

Environment: Apache NetBeans 28, JDK 23.0.2
Test date: 29 October 2026

Added Burger, then Pizza; size displayed as 2/8.
Peek displayed Pizza without removing it.
Search for "burger" found Burger.
Remove deleted Pizza first, confirming LIFO order was preserved.
Display showed only Burger remaining.
Text input "remove" at the menu was rejected; menu continued.
Exit displayed Goodbye.

## Final verification on 31 October 2026

Environment: Apache NetBeans 28, JDK 23.0.2
Tests were repeated after the FoodStorage interface, the FoodProduct inheritance,
the capacity method and the storage time formatting were added.

| Test | Expected result | Observed result | Status |
|---|---|---|---|
| Remove, peek and display on empty storage | Report empty storage | "Storage is empty." displayed; menu continued | Pass |
| Search on empty storage | No match | "Food not found." displayed | Pass |
| Add Burger with valid details | Item added and displayed | Details shown with storage time as yyy-MM dd HH:mm | Pass |
| LIFO removal: add Burger, then Pizza | Remmove Pizza first | Pizza shown; size unchanged | Pass |
| Display two items | Pizza before Burger | Correct top-to-bottom order | Pass|
| Search "burger" | Find Burger ignoring case | Burger found | Pass|
| Negative, NaN and infinite weight | Reject item | Weight validation message displayed | Pass |
| Text instead of weight ("abc") | Reject without crashing | Weight error displayed; menu continued | Pass |
| Unknown food name ("Sushi") | Reject item | Allow food names displayed | Pass |
| Blank food name | Reject item | "Food name is required." displayed (validate by FoodProduct) | Pass |
| Best-before +15 days and past date | Reject item | Date validation message displayed | Pass |
| Best-before +14 days (2026-11-14) Accept | Item added | Pass |
| Invalid calendar date and text date | Reject without crashing | Date format message displayed | Pass |
| Invalid menu option | Reject and continue | Invalid option message displayed; menu continued | Pass |
| Blank search input | Reject and continue | "Search name is reqauired." displayed | Pass |
| Invalid inputs | Storage unchanged | Item count did not increase | Pass |
| Fill all 8 positions, then add again | Reject ninth item | "Storage is full." displayed before asking for details | Pass|
| Add after removing from full storage | Accept new item | Item added; size returned 8/8 | Pass |
| Exist using 0 |End application | "Goodbye!" displayed | Pass |