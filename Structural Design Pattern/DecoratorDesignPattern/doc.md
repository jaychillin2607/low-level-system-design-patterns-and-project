### Decorator Design Pattern Report

**Title**: Decorator Design Pattern Report

**Introduction**  
The Decorator Design Pattern is a structural pattern used to dynamically add behaviour or responsibilities to individual objects without affecting the behaviour of other objects from the same class. This pattern is particularly useful when extending functionality in a flexible and reusable manner.

**Source Definition (Exact)**  
From the _GoF Design Patterns_ book:  
_"The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality."_

**Easy Definition**  
The Decorator Design Pattern allows you to add new features or behaviours to an object without modifying its structure. Instead of changing the object's class, you wrap it with decorator objects that introduce the new behaviour. Think of it like adding layers of decoration to an object, each layer introducing something new.

**Why is the Decorator Design Pattern used?**  
The Decorator Design Pattern is used to add additional responsibilities to an object dynamically. It provides flexibility to attach new behaviour to objects at runtime rather than compile time, avoiding the need to subclass or modify the original class. It is also beneficial in scenarios where multiple combinations of functionalities are needed.

**When to use the Decorator Design Pattern**

- When you want to add responsibilities or behaviours to objects dynamically without affecting other instances of the same class.
- When subclassing would result in an excessive number of sub-classes to cover all possible combinations of behaviours.
- In situations where you need to extend functionality but want to keep the flexibility of using composition rather than inheritance.
- In graphical user interfaces (GUIs), where widgets often use decorators to add scroll bars, borders, or shadows to existing components.

**When not to use the Decorator Design Pattern**

- If you only need to add behaviour to all instances of a class, it may be more efficient to modify the class itself rather than creating decorators.
- In cases where the added responsibilities do not vary, subclassing might be a simpler approach.
- If too many layers of decorators are added, it can make debugging and understanding the code difficult due to excessive complexity.

**Key Points of the Decorator Design Pattern**

- **Composition over inheritance**: The Decorator pattern promotes composition by allowing behaviour to be added without modifying the class itself.
- **Flexible extension**: You can dynamically add or remove behaviour from an object at runtime.
- **Transparency**: The decorator class implements the same interface as the object it decorates, so the decorated object can be used wherever the original object is expected.
- **Recursive Composition**: Multiple decorators can be applied to a single object, allowing for a rich combination of behaviours.

**Code Example Without Decorator Design Pattern**  
Here is an example of extending a class without using the Decorator pattern:

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
    public String getDescription() {
        return "Coffee with Milk";
    }

    public double cost() {
        return 2.50;
    }
}

class SugarMilkCoffee extends MilkCoffee {
    public String getDescription() {
        return "Coffee with Milk and Sugar";
    }

    public double cost() {
        return 3.00;
    }
}
```

**Issues in the Above Code**

- **Excessive subclassing**: Every new combination of coffee options results in a new subclass. This makes the code less flexible and more difficult to maintain.
- **Tight coupling**: The behaviour is locked into a specific class hierarchy, meaning changes require altering or extending the class, which leads to code duplication and limited scalability.

**Improved Code Using the Decorator Design Pattern**  
Below is the refactored version using the Decorator pattern to solve the problems:

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

// Decorator class
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

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    public double cost() {
        return decoratedCoffee.cost() + 0.50;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    public double cost() {
        return decoratedCoffee.cost() + 0.25;
    }
}
```

**Improvements in the Above Code**

- **No need for subclassing**: The Decorator pattern avoids subclassing by attaching new responsibilities at runtime.
- **Flexible combinations**: You can combine multiple decorators in various ways to achieve different behaviours. For example, you can apply both `MilkDecorator` and `SugarDecorator` to the same coffee object.
- **Increased modularity**: Each decorator is responsible for a single feature, making it easier to manage and extend the code.

**Conclusion**  
The Decorator Design Pattern is an excellent way to extend functionality dynamically without modifying the existing codebase or creating a large number of subclasses. It provides flexibility and adheres to the principle of composition over inheritance, making the code more scalable and maintainable. However, overuse of decorators can add complexity, so it is essential to strike a balance when applying this pattern.
