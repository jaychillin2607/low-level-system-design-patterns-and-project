# Decorator Design Pattern Report

## **Title**

Decorator Design Pattern Report

## **Introduction**

The **Decorator Design Pattern** is a structural design pattern that allows behaviour to be added to individual objects, dynamically and transparently, without affecting the behaviour of other objects from the same class. This pattern provides a flexible alternative to subclassing, enabling the addition of responsibilities to objects without altering their structure.

## **Formal Definition (Source)**

According to the _Gang of Four (GoF)_:

_"The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality."_

## **Simplified Definition**

The Decorator Design Pattern is used to add extra features or behaviour to objects without modifying their structure. Instead of creating new subclasses for each variation, this pattern wraps the object with a decorator class that introduces new behaviour, allowing flexible enhancements.

## **Why is the Decorator Design Pattern Used?**

The Decorator Pattern is used to solve several design issues:

1. **Avoid Subclass Explosion**: It eliminates the need for multiple subclasses to represent every possible combination of behaviours.
2. **Flexibility**: It allows for adding or removing behaviours at runtime without affecting other instances.
3. **Single Responsibility Principle**: Each decorator class focuses on a specific feature, promoting code clarity.
4. **Composition Over Inheritance**: Instead of extending classes, behaviours are composed through object wrapping, leading to better modularity.

## **Use Cases (When to Use the Decorator Design Pattern)**

- **Adding Behaviour Dynamically**: When objects require dynamic changes in behaviour or functionality at runtime.
- **Complex Combinations of Features**: When there are multiple ways to combine features (e.g., adding borders, scrollbars, and shadows to a UI component).
- **Extension Without Modification**: When you want to extend the functionality of existing classes without modifying the base code or impacting other instances.

## **When Not to Use the Decorator Design Pattern**

- **Simple Cases**: When extending behaviour is straightforward, and subclassing would be simpler and easier to understand.
- **Excessive Complexity**: If many layers of decorators are used, the resulting code can become harder to read, debug, and maintain.
- **No Need for Dynamic Flexibility**: If the system does not require dynamically adding or removing behaviour at runtime, the pattern may introduce unnecessary complexity.

## **Key Characteristics (Points)**

1. **Transparent Composition**: The decorator class implements the same interface as the object it decorates, allowing the decorated object to be used in the same way as the original.
2. **Recursive Composition**: Multiple decorators can be applied to an object, providing a flexible way to mix and match behaviours.
3. **Loose Coupling**: The client code does not need to know about the decorated object's internal details, promoting loose coupling between objects.
4. **Runtime Flexibility**: New behaviours can be added or removed at runtime, allowing for dynamic modification.

## **Code Example Without Decorator Design Pattern**

```java
class Coffee {
    public String getDescription() {
        return "Plain Coffee";
    }

    public double cost() {
        return 2.00;
    }
}

class MilkCoffee extends Coffee {
    @Override
    public String getDescription() {
        return "Coffee with Milk";
    }

    @Override
    public double cost() {
        return 2.50;
    }
}

class SugarMilkCoffee extends MilkCoffee {
    @Override
    public String getDescription() {
        return "Coffee with Milk and Sugar";
    }

    @Override
    public double cost() {
        return 3.00;
    }
}
```

## **Explanation of Issues in the Above Code**

1. **Subclass Explosion**: Every new feature or combination of features requires a new subclass (e.g., `MilkCoffee`, `SugarMilkCoffee`), which leads to an excessive number of subclasses.
2. **Tight Coupling**: Behaviour is hard-coded into subclasses, making it difficult to modify or extend without changing the class structure.
3. **Limited Flexibility**: Adding or removing features at runtime is not possible, as the behaviour is locked into the class structure.

## **Improved Code Example Using the Decorator Design Pattern**

```java
// Component interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component
class PlainCoffee implements Coffee {
    public String getDescription() {
        return "Plain Coffee";
    }

    public double cost() {
        return 2.00;
    }
}

// Decorator base class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.50;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.25;
    }
}
```

## **Explanation of Improvements in the Refactored Code**

1. **No Need for Subclass Explosion**: By using decorators, we eliminate the need for multiple subclasses like `MilkCoffee` or `SugarMilkCoffee`. Instead, we dynamically add behaviours to objects using decorator classes.
2. **Flexible Combination of Features**: Multiple decorators can be applied in various combinations at runtime, allowing for flexible and dynamic feature addition.
3. **Better Adherence to the Open-Closed Principle**: New features can be added by creating new decorators, without modifying existing classes.

## **Conclusion**

The **Decorator Design Pattern** provides a flexible, modular way to extend the behaviour of individual objects without modifying the original class or creating many subclasses. It enables runtime flexibility and promotes loose coupling, adhering to key design principles like **Single Responsibility** and **Open-Closed**. However, caution must be exercised to avoid excessive complexity through the overuse of decorators.
