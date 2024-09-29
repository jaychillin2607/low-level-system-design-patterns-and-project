# Factory Method Design Pattern Report

## **Title**

Factory Method Design Pattern Report

## **Introduction**

The **Factory Method Design Pattern** is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. This pattern helps in achieving loose coupling by delegating the object creation logic to subclasses, which makes the system more flexible and scalable.

## **Formal Definition (Source)**

According to the Gang of Four (GoF), the **Factory Method Design Pattern** is defined as:

_"Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses."_

## **Simplified Definition**

The Factory Method Pattern is a way to create objects, but instead of directly calling a constructor, the creation is handled by a method in a superclass, which is overridden by subclasses to specify what kind of object should be created.

## **Why is the Factory Method Design Pattern Used?**

The Factory Method is used for several reasons:

1. **Decoupling the Client and Object Creation Logic**: The client code doesn’t need to know the exact class being instantiated. It relies on a method that delegates the decision to subclasses.
2. **Encapsulation of Object Creation**: The object creation logic is encapsulated within the factory method, making it easy to manage changes.
3. **Flexibility**: New object types can be added without modifying the client code, adhering to the **Open-Closed Principle**.
4. **Reusability**: By defining common interfaces, the factory method can be reused by multiple classes.

## **Use Cases (When to Use the Factory Method Design Pattern)**

- **Multiple Object Variants**: When a class can create different types of objects based on certain conditions, and the object creation logic can vary among subclasses.
- **When Object Creation Needs to Be Centralized**: If object creation involves complex steps, centralizing it within a factory method simplifies the client code.
- **Extending Object Creation**: When you anticipate that new types of objects may be added in the future without changing existing code.

## **When Not to Use the Factory Method Design Pattern**

- **Simple Object Creation**: If the object creation logic is straightforward and unlikely to change, using a Factory Method can add unnecessary complexity.
- **One-time Object Creation**: If the objects created will never change and are not part of a polymorphic system, then a factory method is not needed.
- **Performance Overhead**: Factory methods may introduce performance overhead by adding an extra layer of abstraction.

## **Key Characteristics (Points)**

1. **Delegation of Object Creation**: The client does not instantiate objects directly but relies on a method to delegate the instantiation to subclasses.
2. **Polymorphism**: Factory methods leverage polymorphism, allowing different types of objects to be created via the same interface.
3. **Loose Coupling**: The client code is decoupled from the specific types of objects it creates, making the system more flexible.
4. **Single Responsibility Principle**: The object creation responsibility is delegated to specific subclasses rather than the client class.
5. **Adheres to the Open-Closed Principle**: New object types can be added without modifying existing code, enhancing flexibility.

## **Code Example Without Factory Method Design Pattern**

```java
// Product Interface
interface Transport {
    void deliver();
}

// Concrete Products
class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by Truck");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by Ship");
    }
}

// Client class directly instantiates products
public class Logistics {
    public void planDelivery(String type) {
        if ("Truck".equalsIgnoreCase(type)) {
            Transport transport = new Truck();
            transport.deliver();
        } else if ("Ship".equalsIgnoreCase(type)) {
            Transport transport = new Ship();
            transport.deliver();
        } else {
            throw new IllegalArgumentException("Unknown transport type");
        }
    }

    public static void main(String[] args) {
        Logistics logistics = new Logistics();
        logistics.planDelivery("Truck");
        logistics.planDelivery("Ship");
    }
}
```

## **Explanation of Issues in the Above Code**

1. **Tight Coupling**: The `Logistics` class is tightly coupled with the specific transport types (`Truck`, `Ship`), which makes it difficult to introduce new transport types without modifying the client code.
2. **Lack of Flexibility**: Each time a new transport type is added, the `Logistics` class needs to be modified, violating the **Open-Closed Principle**.
3. **Code Duplication**: The instantiation logic for each transport type is repeated, leading to redundant code.

## **Improved Code Example Using the Factory Method Design Pattern**

```java
// Product Interface
interface Transport {
    void deliver();
}

// Concrete Products
class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by Truck");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by Ship");
    }
}

// Creator Class
abstract class Logistics {
    // Factory method
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

// Concrete Creators
class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

// Client code using the factory method
public class Main {
    public static void main(String[] args) {
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();

        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}
```

## **Explanation of Improvements in the Refactored Code**

1. **Decoupling**: The `Logistics` class no longer directly instantiates the specific transport types. It relies on subclasses (`RoadLogistics`, `SeaLogistics`) to handle object creation, following the **Factory Method** pattern.
2. **Open-Closed Principle**: New types of transport can be added by simply creating a new subclass of `Logistics`, without changing existing client code.
3. **Centralized Object Creation**: The `createTransport()` method is responsible for object creation, making it easier to manage and extend in one place.
4. **Polymorphism**: The `Logistics` class operates on the abstract `Transport` type, allowing the same client code to work with multiple transport types.

#### **Conclusion**

The **Factory Method Design Pattern** provides a flexible and decoupled approach to object creation. By delegating the instantiation process to subclasses, it promotes loose coupling and allows for easy extensibility. It is especially useful when the type of objects created may vary dynamically or when additional object types may be introduced in the future. However, if object creation is simple and fixed, using this pattern might introduce unnecessary complexity. The pattern adheres to key principles such as **Single Responsibility** and **Open-Closed**, making it a valuable tool in many scenarios.
