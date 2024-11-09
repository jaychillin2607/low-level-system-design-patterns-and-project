# **Title**: Mediator Design Pattern Report

## **Introduction**
The Mediator design pattern is a behavioral pattern that facilitates communication between different components (or objects) in a system by centralizing the interaction logic in a separate mediator object. Instead of having direct dependencies between components, they communicate indirectly via a mediator, reducing coupling and making components easier to reuse and maintain. This pattern is especially useful for complex systems with multiple interacting classes, as it simplifies the communication flow.

## **Source Definition (Exact)**
> "Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently."  
> — GoF (Gang of Four) Design Patterns Book

## **Easy Definition**
The Mediator pattern creates a central place (the mediator) that manages communication between objects, so they don’t need to know about each other directly, making the code cleaner and more modular.

## **Why is the Mediator used?**
- **Reduces Direct Dependencies**: By having a central mediator, classes don’t need direct references to each other, decreasing coupling.
- **Simplifies Communication Logic**: It organizes complex communication logic in one place, making the system more maintainable.
- **Encourages Component Reusability**: As objects are no longer interdependent, they can be reused in different contexts more easily.
- **Improves Code Modularity**: Communication responsibilities are separated from components, improving modularity and reducing the need to modify each class when communication logic changes.

## **When to use the Mediator**
- When multiple objects communicate in complex ways, creating tightly coupled code.
- When frequent communication changes between objects would require repeated modifications to the system.
- When you want to promote reusability by separating the interaction logic from the objects themselves.
- In GUI applications where UI components interact frequently and need a centralized controller.

## **When not to use the Mediator**
- When the system has few objects that interact in a simple way, as a mediator could add unnecessary complexity.
- When a simpler design pattern, like Observer, would be sufficient for loose coupling.
- When the mediator becomes too complex, effectively becoming a monolithic class that handles excessive responsibilities, which could make the system harder to maintain.

## **Key Points of the Mediator**
- **Centralized Communication**: All communication is routed through the mediator, preventing direct dependencies between objects.
- **Reduced Coupling**: Objects depend only on the mediator, not on each other, creating a loosely coupled system.
- **Modular Communication Management**: Communication behavior can be modified without changing the involved classes, making the system more adaptable.
- **Improved Object Reusability**: Classes are easier to reuse, as they no longer contain communication logic tied to other specific classes.

---

## **Code Example Without Mediator Pattern**
```java
// Without Mediator, each component directly references and interacts with others, creating tightly coupled code.

class ComponentA {
    private ComponentB componentB;
    private ComponentC componentC;

    public ComponentA(ComponentB b, ComponentC c) {
        this.componentB = b;
        this.componentC = c;
    }

    public void action() {
        System.out.println("ComponentA action triggered");
        componentB.performTask();
        componentC.performTask();
    }
}

class ComponentB {
    public void performTask() {
        System.out.println("ComponentB task performed");
    }
}

class ComponentC {
    public void performTask() {
        System.out.println("ComponentC task performed");
    }
}

class Application {
    public static void main(String[] args) {
        ComponentB componentB = new ComponentB();
        ComponentC componentC = new ComponentC();
        ComponentA componentA = new ComponentA(componentB, componentC);

        componentA.action();
    }
}
```

### **Issues in the Above Code**
- **Tight Coupling**: Components `A`, `B`, and `C` are tightly coupled, with direct dependencies between each other.
- **Difficult to Maintain**: Modifying communication logic between components requires changes across all affected classes.
- **Limited Reusability**: Components `B` and `C` are specific to `A`, reducing flexibility and reusability of each component.

---

## **Improved Code Using the Mediator Pattern**
```java
// Mediator Interface
interface Mediator {
    void notify(Component component, String event);
}

// Concrete Mediator class to manage communication between components
class ConcreteMediator implements Mediator {
    private ComponentA componentA;
    private ComponentB componentB;
    private ComponentC componentC;

    public void setComponentA(ComponentA componentA) {
        this.componentA = componentA;
    }

    public void setComponentB(ComponentB componentB) {
        this.componentB = componentB;
    }

    public void setComponentC(ComponentC componentC) {
        this.componentC = componentC;
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == componentA) {
            System.out.println("Mediator handling event from ComponentA");
            componentB.performTask();
            componentC.performTask();
        } else if (sender == componentB) {
            System.out.println("Mediator handling event from ComponentB");
            componentA.action();
        }
    }
}

// Abstract Component class
abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
}

// Concrete components with references to the mediator
class ComponentA extends Component {
    public ComponentA(Mediator mediator) {
        super(mediator);
    }

    public void action() {
        System.out.println("ComponentA action triggered");
        mediator.notify(this, "action");
    }
}

class ComponentB extends Component {
    public ComponentB(Mediator mediator) {
        super(mediator);
    }

    public void performTask() {
        System.out.println("ComponentB task performed");
        mediator.notify(this, "task");
    }
}

class ComponentC extends Component {
    public ComponentC(Mediator mediator) {
        super(mediator);
    }

    public void performTask() {
        System.out.println("ComponentC task performed");
    }
}

// Client code
class Application {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ComponentA componentA = new ComponentA(mediator);
        ComponentB componentB = new ComponentB(mediator);
        ComponentC componentC = new ComponentC(mediator);

        mediator.setComponentA(componentA);
        mediator.setComponentB(componentB);
        mediator.setComponentC(componentC);

        componentA.action();
    }
}
```

### **Improvements in the Above Code**
- **Reduced Coupling**: Components no longer directly reference each other, relying on the mediator for communication.
- **Enhanced Maintainability**: Modifying the interaction logic now only requires changes in the `ConcreteMediator`, making the system easier to maintain.
- **Improved Reusability**: Components are more reusable, as they are not bound to specific instances of other components.

---

## **Considerations for Effective Use of the Mediator Pattern**
- **Avoid Overloading the Mediator**: Ensure the mediator only handles communication logic without overloading it with additional functionality.
- **Define a Clear Interface**: A well-defined mediator interface is crucial for effective communication, especially in complex systems with multiple interaction scenarios.
- **Balance Between Flexibility and Complexity**: While the mediator can improve flexibility, overuse can lead to a complex monolithic mediator, making the system harder to understand and maintain.

---

## **Conclusion**
The Mediator pattern is ideal for scenarios where complex communication between objects can lead to high coupling. By centralizing communication in a mediator, it decouples objects, making them easier to reuse and manage. This pattern is particularly useful in GUI systems and complex business logic scenarios. While it simplifies the interaction among components, it's essential to use the mediator judiciously, as excessive communication responsibilities in the mediator can create a bottleneck, potentially increasing the system's complexity rather than simplifying it.