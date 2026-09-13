# Museum Exhibition Builder

## Description

This project demonstrates the **Builder** creational design pattern using a museum exhibition system as the example domain. A museum can host different types of exhibitions (historical, art, science), and each exhibition has many possible parameters (name, theme, period, hall style, audio guide, interactive zone, VR zone, etc.). The Builder pattern is used to construct these exhibition objects step by step, in a readable and safe way.

## Problem

`MuseumExhibition` has many fields, and not all of them are required. If we used a normal constructor, it would quickly become hard to read and easy to misuse:

```java
// Bad: unclear which value means what, easy to pass arguments in the wrong order
MuseumExhibition exhibition = new MuseumExhibition(
    "Ancient Egypt", "History", "3000 BC - 30 BC", 20,
    "Classic", true, false, false, "John Smith"
);
```

Adding more parameters later (or overloading the constructor for optional fields) would make this even worse.

## Solution

The **Builder** pattern separates the construction of `MuseumExhibition` from its representation. Instead of one large constructor, the object is built step by step through named, chainable methods, and only assembled at the very end when `build()` is called. This makes the code self-explanatory and lets `build()` validate the data before the object is created.

```java
MuseumExhibition exhibition = new MuseumExhibition.Builder()
        .setName("Ancient Egypt")
        .setTheme("History")
        .setHistoricalPeriod("3000 BC - 30 BC")
        .setExhibitCount(20)
        .setHallStyle("Classic")
        .setAudioGuide(true)
        .build();
```

## Design Pattern Structure

| Role      | Class                          |
|-----------|---------------------------------|
| Product   | `MuseumExhibition`               |
| Builder   | `MuseumExhibition.Builder`       |
| Director  | `ExhibitionDirector`             |
| Client    | `Main`                           |

- **Product** – the complex object being built (`MuseumExhibition`).
- **Builder** – builds the Product step by step and validates it (`MuseumExhibition.Builder`, a static nested class).
- **Director** – knows fixed "recipes" for common exhibitions and uses the Builder to create them (`ExhibitionDirector`).
- **Client** – uses both the Director (for ready-made exhibitions) and the Builder directly (for a custom exhibition) (`Main`).

## Project Structure

```
museum-exhibition-builder/
├── README.md
└── src/
    └── main/
        └── java/
            └── museum/
                ├── MuseumExhibition.java
                ├── ExhibitionDirector.java
                └── Main.java
```

## How Product Works

`MuseumExhibition` has only private, final fields and no public setters, so once it is created it cannot be changed. It has a **private constructor** that only accepts a `Builder`, so the only way to create an instance is through `MuseumExhibition.Builder`. Public getters expose the data, and `toString()` prints it in a readable format.

## How Builder Works

1. The client creates `new MuseumExhibition.Builder()`.
2. The client calls the `set...()` methods it needs. Each one returns `this`, so calls can be chained (fluent API).
3. The client calls `build()`.
4. `build()` validates the required fields (`name`, `theme`, `historicalPeriod`, `hallStyle`, `exhibitCount`).
5. If validation passes, `build()` creates and returns a new `MuseumExhibition`. If not, it throws `IllegalStateException` with a clear message.

`curator` was chosen as an **optional** field: not every exhibition necessarily has a named curator assigned yet when it is first created, while the other five fields describe the exhibition itself and don't make sense to leave empty.

## How Director Works

`ExhibitionDirector` contains three methods, each building one predefined exhibition using the Builder:

- `createHistoricalExhibition()`
- `createArtExhibition()`
- `createScienceExhibition()`

Each method is small and does exactly one thing — it configures one exhibition type and nothing else. The Director never constructs `MuseumExhibition` directly; it always goes through the Builder.

## How Client Works

`Main` demonstrates both ways of creating exhibitions:

1. **Through the Director** — for ready-made, predefined exhibitions (historical, art, science).
2. **Directly through the Builder** — for a one-off, custom exhibition ("Space Exploration") that doesn't match any predefined configuration.

It also demonstrates validation by attempting to build an exhibition with an invalid `exhibitCount` and catching the resulting exception.

## Example

```java
ExhibitionDirector director = new ExhibitionDirector();
MuseumExhibition historical = director.createHistoricalExhibition();
System.out.println(historical);
```

Output:

```
MuseumExhibition{name='Ancient Egypt', theme='History', historicalPeriod='3000 BC - 30 BC', exhibitCount=20, hallStyle='Classic', audioGuide=true, interactiveZone=false, virtualReality=false, curator='History Department'}
```

## Clean Code Principles

### 1. Meaningful names

**Before:**
```java
String n;
String t;
int c;
```

**After:**
```java
String name;
String theme;
int exhibitCount;
```

The second version tells you what the variable holds without needing extra comments or context.

### 2. Small methods / Single Responsibility

**Before (bad):**
```java
public void createAllExhibitions() {
    // builds historical, art AND science exhibitions in one huge method
}
```

**After (used in this project):**
```java
public MuseumExhibition createHistoricalExhibition() { ... }
public MuseumExhibition createArtExhibition() { ... }
public MuseumExhibition createScienceExhibition() { ... }
```

Each Director method builds exactly one exhibition type, so it's easy to read, test, and change independently.

### 3. Validated construction

**Before (bad — invalid object can exist):**
```java
MuseumExhibition exhibition = new MuseumExhibition();
exhibition.exhibitCount = -10; // no one stops this
```

**After (used in this project):**
```java
if (exhibitCount < MIN_EXHIBIT_COUNT) {
    throw new IllegalStateException("Exhibit count must be greater than 0");
}
```

Checking the data inside `build()` means an invalid `MuseumExhibition` can never exist in the first place, instead of being created and failing somewhere later.

### 4. No magic numbers / strings

**Before:**
```java
if (exhibitCount < 1) { ... }
```

**After:**
```java
private static final int MIN_EXHIBIT_COUNT = 1;
...
if (exhibitCount < MIN_EXHIBIT_COUNT) { ... }
```

`MIN_EXHIBIT_COUNT` explains *why* the number 1 matters, instead of leaving a bare literal in the validation logic.

### 5. Focused classes / Single Responsibility

- `MuseumExhibition` — represents a finished exhibition (the Product).
- `MuseumExhibition.Builder` — knows how to assemble a `MuseumExhibition` step by step and validate it.
- `ExhibitionDirector` — knows the predefined exhibition "recipes".
- `Main` — demonstrates and runs the example.

Each class has exactly one reason to change: the Product's data, the way it is built, the predefined configurations, or the demonstration, are all kept separate.

## How to Run

1. Open **IntelliJ IDEA**.
2. Choose **Open** and select the `museum-exhibition-builder` folder.
3. IntelliJ will detect `src/main/java` as the sources root automatically (if not, right-click the `java` folder → **Mark Directory as** → **Sources Root**).
4. Open `src/main/java/museum/Main.java`.
5. Click the green **Run** arrow next to `public static void main`.
6. The console will print the Director-built exhibitions, the custom Builder-built exhibition, and the validation demo.

No external libraries, build tools, or frameworks are required — this is plain Java (JDK 17+).

## Git Commit History

Suggested incremental commits:

1. `Create museum exhibition product` — add `MuseumExhibition` with fields, private constructor, getters, and `toString()`.
2. `Implement exhibition builder` — add the nested `Builder` class with fluent setters and validated `build()`.
3. `Add director and client examples` — add `ExhibitionDirector` and `Main`.
4. `Add README and clean code documentation` — add `README.md` with pattern explanation and Clean Code examples.

Example commands:

```bash
git init
git add src/main/java/museum/MuseumExhibition.java
git commit -m "Create museum exhibition product"

git add src/main/java/museum/MuseumExhibition.java
git commit -m "Implement exhibition builder"

git add src/main/java/museum/ExhibitionDirector.java src/main/java/museum/Main.java
git commit -m "Add director and client examples"

git add README.md
git commit -m "Add README and clean code documentation"
```

(The first two commits both touch `MuseumExhibition.java` since the Product and its Builder live in the same file — commit the field/constructor/getters part first, then the Builder logic, using `git add -p` if you want to split the file itself into two commits.)
