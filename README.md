# My-Pantry-Management---402306735---Inteligent Kekana---Mobile-App-Development-700
*Student: Portfolio of Evidence*

## 1. App Concept
Smart Pantry Manager helps users cut food waste by tracking leftover ingredients at home and suggesting recipes they can cook using STRICTLY what they already have. No shopping required.

The core value is the *Strict-Matching Rule*: A recipe is ONLY shown if EVERY required ingredient is in the pantry in sufficient quantity.

## 2. Features Implemented (Section 2.2)
- *Pantry Management*: Add, Edit, Delete (name, qty, unit, expiry) with validation
- *Pantry List Screen*: RecyclerView bound to Room database via LiveData
- *Recipe Collection*: 20 pre-seeded recipes on first run (RecipeSeeder)
- *Suggested Recipes Screen*: Runs StrictMatcher logic
- *Recipe Detail Screen*: Shows full ingredients + steps
- *Settings Screen*: Toggle expiring-soon alerts, metric units
- *Zero-match feedback*: "No recipes match your pantry yet - add more ingredients"

## 3. Strict-Matching Logic (Section 2.3 - MOST IMPORTANT)
Location: utils/StrictMatcher.java

```java
if a recipe needs 5 ingredients and pantry has 4

## 4. Technical Stack
- *Language: Java only (not Kotlin)
- *IDE: Android Studio
- *Database: Room (SQLite) - Chosen because: offline-first, taught in module, persists after app close, no internet needed, lightweight. Justified over SharedPrefs (too       simple) and Firebase (needs internet).
- *Architecture: 5 Fragments in Single Activity host
- *Navigation: Bottom NavigationView + Intents/Bundles
- *List: RecyclerView + Custom Adapter (PantryAdapter, RecipeAdapter)
- *Layouts: ConstraintLayout, LinearLayout, CardView

## 5. Database Schema
- *PantryItems (id, name, quantuty, unit, expiryDate)
- *Recipes (id, name, steps)
- *Recipelngredients (id, recipeld, ingredientName, quantity, unit)
