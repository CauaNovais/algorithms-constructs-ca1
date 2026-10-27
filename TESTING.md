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

## Remaining checks

- Zero weight, NaN and infinity.
- Text instead of numeric weight.
- Unknown or blank food name.
- Invalid calendar date, such as 2026-11-31.
- Invalid menu choice.
- Blank search input.
- Repeat checks after the final team changes.
- Verify the final project in NetBeans.