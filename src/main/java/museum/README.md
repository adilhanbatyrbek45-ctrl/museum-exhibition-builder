# Museum Exhibition Builder

This is my Java project for the Builder Pattern assignment.

I chose a museum exhibition as the topic. An exhibition can have different information like name, theme, historical period, number of exhibits, hall style and some extra features.

## Builder Pattern

The project has:

* MuseumExhibition - Product
* MuseumExhibition.Builder - Builder
* ExhibitionDirector - Director
* Main - Client

The Builder is used to create an exhibition step by step.

For example:

```java
MuseumExhibition exhibition = new MuseumExhibition.Builder()
        .setName("Ancient Egypt")
        .setTheme("History")
        .setHistoricalPeriod("3000 BC - 30 BC")
        .setExhibitCount(20)
        .setHallStyle("Classic")
        .setAudioGuide(true)
        .setInteractiveZone(false)
        .setVirtualReality(false)
        .setCurator("History Department")
        .build();
```

The methods return `this`, so I can use them one after another.

## Director

`ExhibitionDirector` has three ready exhibition types:

* Historical Exhibition
* Art Exhibition
* Science Exhibition

This is useful because I don't have to write all the builder methods every time for these exhibitions.

I can also create my own exhibition directly in `Main`.

## Validation

The `build()` method checks the main required fields.

For example:

```java
if (exhibitCount <= 0) {
    throw new IllegalStateException("Exhibit count must be greater than 0");
}
```

It also checks that the name, theme, historical period and hall style are not empty.

## Project Structure

```text
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

## Clean Code

### 1. Meaningful names

I use names that show what the variable is for.

Bad:

```java
String n;
String t;
int c;
```

Better:

```java
String name;
String theme;
int exhibitCount;
```

### 2. Small methods

Instead of putting all exhibitions in one method, I have separate methods:

```java
createHistoricalExhibition()
createArtExhibition()
createScienceExhibition()
```

Each method is responsible for one exhibition.

### 3. Validation

The data is checked before the object is created.

```java
if (exhibitCount <= 0) {
    throw new IllegalStateException("Exhibit count must be greater than 0");
}
```

This prevents creating an exhibition with an invalid number of exhibits.

### 4. Single Responsibility

I separated the project into different classes.

`MuseumExhibition` stores the exhibition data.

`Builder` creates the object.

`ExhibitionDirector` creates the ready configurations.

`Main` runs the program.

### 5. Consistent code style

I use the same formatting and naming style in all classes. Methods and variables use clear names and the code has the same indentation.

## How to Run

Open the project in IntelliJ IDEA.

Open:

```text
src/main/java/museum/Main.java
```

Run the `main()` method.

The exhibitions will be printed in the console.

No additional libraries are needed.

## Git Commits

1. `Create museum exhibition product`
2. `Implement exhibition builder`
3. `Add director and client examples`
4. `Add README and clean code documentation`
