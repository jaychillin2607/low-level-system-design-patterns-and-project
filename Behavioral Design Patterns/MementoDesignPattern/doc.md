# **Title**: Memento Design Pattern Report

## **Introduction**
The Memento design pattern is a behavioral pattern that enables saving and restoring an object's internal state without violating its encapsulation. By capturing the state of an object and allowing it to be restored later, Memento is especially useful for applications that require undo/redo functionality or state rollback. This pattern preserves encapsulation by hiding the state-saving details from other classes, thereby separating state storage from business logic.

## **Source Definition (Exact)**
> "Without violating encapsulation, capture and externalize an object’s internal state so that the object can be restored to this state later."  
> — GoF (Gang of Four) Design Patterns Book

## **Easy Definition**
The Memento pattern allows saving an object's state at a specific point and restoring it later, which is useful for implementing undo/redo functionality without compromising encapsulation.

## **Why is the Memento used?**
- **Enables Undo/Redo Functionality**: Memento provides an effective way to implement undo and redo functions by saving snapshots of an object's state.
- **Supports State Rollback**: It allows reverting to a previous state if necessary, which is beneficial in applications where actions may need to be rolled back.
- **Preserves Encapsulation**: The Memento pattern keeps the state-saving and state-restoring logic hidden from other objects, maintaining the integrity of the object's encapsulation.
- **Decouples State Management**: The pattern enables separation of state storage and management from the core logic, making code more modular and maintainable.

## **When to use the Memento**
- When your application needs to support undo and redo functionality.
- When you want to preserve encapsulation by managing an object’s state history without exposing internal details.
- When there is a need to restore an object to a previous state (e.g., in transactional or gaming applications).
- When you need to save snapshots of an object’s state at various points in time for later retrieval.

## **When not to use the Memento**
- When the object state is large and saving every change can consume excessive memory or processing power.
- When frequent state changes occur, and maintaining multiple states would introduce performance or storage issues.
- When a simpler alternative, like a versioning system or an event log, would suffice for tracking changes.

## **Key Points of the Memento**
- **State Capture and Restoration**: Memento captures an object’s internal state without exposing it to other classes.
- **Encapsulation Preservation**: State management is handled within the originator class, protecting the integrity of the object's state.
- **Supports Time-Travel Operations**: The pattern allows easy backtracking or restoration to previous states, making it ideal for undo/redo features.
- **Careful Memory Management**: Since mementos may store large amounts of data, proper memory management and selective state-saving are critical to avoid bloating.

---

## **Code Example Without Memento Pattern**
```java
// Without Memento, the editor class handles its own state history, which can lead to bloated and complex code.

class Editor {
    private String content;
    private List<String> history = new ArrayList<>();

    public void setContent(String content) {
        history.add(this.content); // Manually saving previous state
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void undo() {
        if (!history.isEmpty()) {
            this.content = history.remove(history.size() - 1); // Restore last saved state
        }
    }
}

// Client code
class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setContent("State 1");
        editor.setContent("State 2");

        System.out.println("Current Content: " + editor.getContent()); // Output: State 2
        editor.undo();
        System.out.println("After Undo: " + editor.getContent()); // Output: State 1
    }
}
```

### **Issues in the Above Code**
- **Bloated Logic**: The `Editor` class contains both core logic and state history management, violating the Single Responsibility Principle.
- **Lack of Encapsulation**: The history is stored within the `Editor`, tightly coupling state management with business logic.
- **Limited Extensibility**: Adding more undo-related features or additional state-saving details would complicate the `Editor` class further.

---

## **Improved Code Using the Memento Pattern**
```java
// Memento class to encapsulate and store Editor state
class Memento {
    private final String content;

    public Memento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Originator class that creates and restores mementos
class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Memento save() {
        return new Memento(content); // Save current state to memento
    }

    public void restore(Memento memento) {
        this.content = memento.getContent(); // Restore state from memento
    }
}

// Caretaker class that manages the memento stack
class History {
    private final Stack<Memento> historyStack = new Stack<>();

    public void push(Memento memento) {
        historyStack.push(memento); // Add memento to history
    }

    public Memento pop() {
        return historyStack.isEmpty() ? null : historyStack.pop(); // Get last saved memento
    }
}

// Client code to use the Editor and manage undo functionality
class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("State 1");
        history.push(editor.save()); // Save state

        editor.setContent("State 2");
        history.push(editor.save()); // Save state

        editor.setContent("State 3");
        System.out.println("Current Content: " + editor.getContent()); // Output: State 3

        editor.restore(history.pop()); // Undo
        System.out.println("After Undo: " + editor.getContent()); // Output: State 2

        editor.restore(history.pop()); // Undo
        System.out.println("After Undo: " + editor.getContent()); // Output: State 1
    }
}
```

### **Improvements in the Above Code**
- **Separated Responsibilities**: The `Editor` focuses solely on managing content, while the `History` class handles state management, following the Single Responsibility Principle.
- **Encapsulated State Management**: The `Memento` class encapsulates the state, and the `Editor` and `History` classes interact without exposing the internal content.
- **Enhanced Extensibility**: Adding more complex state management features becomes easier by modifying only the `Memento` or `History` class, without impacting the `Editor` logic.

---

## **Considerations for Effective Use of the Memento Pattern**
- **Memory and Performance**: Carefully manage memory usage, especially when storing large or frequent snapshots, to avoid excessive memory consumption.
- **Selective State Saving**: Use Memento sparingly to save only essential state changes, minimizing unnecessary storage overhead.
- **Consistency with Restoration**: Ensure the state captured by the memento represents the complete internal state needed for restoration to avoid incomplete recovery.

---

## **Conclusion**
The Memento pattern is highly beneficial in scenarios requiring undo/redo functionality or state rollback while preserving encapsulation. By encapsulating the state within mementos and managing them externally, this pattern decouples state management from business logic, leading to cleaner and more maintainable code. However, when implementing Memento, it is crucial to consider memory usage and frequency of state saves to avoid performance bottlenecks. When used thoughtfully, the Memento pattern is an excellent solution for applications that depend on historical state tracking and revert functionality.