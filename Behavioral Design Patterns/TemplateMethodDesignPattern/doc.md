# **Title**: Template Method Design Pattern Report

## **Introduction**
The Template Method design pattern is a behavioral pattern that defines the skeleton of an algorithm within a base class, allowing subclasses to alter specific steps without modifying the overall structure. This pattern promotes code reuse by enabling common operations to be handled in a single location while still allowing subclasses to provide specific details. Template Method is ideal for scenarios where a sequence of operations follows a set structure, but individual steps may vary.

## **Source Definition (Exact)**
> "Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure."  
> — GoF (Gang of Four) Design Patterns Book

## **Easy Definition**
The Template Method pattern allows defining the core steps of an algorithm in a base class while letting subclasses implement specific parts, thus promoting code reuse and flexibility.

## **Why is the Template Method used?**
- **Promotes Code Reuse**: Common algorithm structure is defined in one place, while subclass-specific details are handled individually, reducing code duplication.
- **Provides Flexibility with Consistency**: Subclasses can implement specific steps differently without altering the overall process, making the code consistent and easily maintainable.
- **Reduces Code Complexity**: With a central template, the flow of an algorithm is clear, even when subclasses provide different implementations for specific steps.
- **Supports the DRY Principle**: By placing the common structure in the superclass, Template Method reduces redundancy and simplifies future modifications.

## **When to use the Template Method**
- When multiple classes share a similar process or structure, but specific steps in the process need to vary between implementations.
- When a sequence of actions follows a standard template, with only a few steps requiring customization.
- When you want to centralize control over an algorithm while giving subclasses the ability to define step-specific behavior.

## **When not to use the Template Method**
- When the algorithm's structure is highly variable, making a fixed sequence difficult to maintain.
- When there is minimal shared code among subclasses, as Template Method could lead to unnecessary inheritance.
- When you need to add steps dynamically to an algorithm’s sequence; Template Method works best with a fixed sequence of steps.

## **Key Points of the Template Method**
- **Algorithm Skeleton in Base Class**: The base class provides the common framework and sequence for the algorithm.
- **Deferred Implementation in Subclasses**: Steps marked as abstract or hook methods are implemented by subclasses to vary behavior.
- **Inversion of Control**: The pattern achieves a form of inversion of control, where the base class dictates the flow but allows subclasses to define specifics.
- **Promotes DRY and SRP**: The Template Method pattern centralizes shared behavior and clearly separates responsibilities, following both the DRY (Don’t Repeat Yourself) and SRP (Single Responsibility Principle).

---

## **Code Example Without Template Method Pattern**
```java
// Without Template Method, subclasses must individually implement the algorithm, leading to duplicated logic.

abstract class Document {
    abstract void load();
    abstract void format();
    abstract void save();

    // Different subclasses repeat similar structure, leading to code duplication
}

class WordDocument extends Document {
    void load() {
        System.out.println("Loading Word Document");
    }

    void format() {
        System.out.println("Formatting Word Document");
    }

    void save() {
        System.out.println("Saving Word Document");
    }
}

class PdfDocument extends Document {
    void load() {
        System.out.println("Loading PDF Document");
    }

    void format() {
        System.out.println("Formatting PDF Document");
    }

    void save() {
        System.out.println("Saving PDF Document");
    }
}

// Client code directly calls the methods, and each subclass must implement the entire algorithm independently
class Application {
    public static void main(String[] args) {
        Document wordDoc = new WordDocument();
        wordDoc.load();
        wordDoc.format();
        wordDoc.save();

        Document pdfDoc = new PdfDocument();
        pdfDoc.load();
        pdfDoc.format();
        pdfDoc.save();
    }
}
```

### **Issues in the Above Code**
- **Duplicated Logic**: Each subclass must define the full algorithm flow, causing code redundancy.
- **No Shared Structure**: The algorithm sequence must be duplicated across subclasses, increasing maintenance efforts.
- **Limited Extensibility**: If the process needs a change, each subclass must be updated, making the code harder to maintain.

---

## **Improved Code Using the Template Method Pattern**
```java
// Abstract class defines the template for the document processing algorithm.
abstract class Document {
    
    // Template method defining the steps for the document process
    public final void processDocument() {
        load();
        format();
        save();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void load();
    protected abstract void format();
    protected abstract void save();
}

// WordDocument subclass implementing the specific steps
class WordDocument extends Document {
    @Override
    protected void load() {
        System.out.println("Loading Word Document");
    }

    @Override
    protected void format() {
        System.out.println("Formatting Word Document");
    }

    @Override
    protected void save() {
        System.out.println("Saving Word Document");
    }
}

// PdfDocument subclass implementing the specific steps
class PdfDocument extends Document {
    @Override
    protected void load() {
        System.out.println("Loading PDF Document");
    }

    @Override
    protected void format() {
        System.out.println("Formatting PDF Document");
    }

    @Override
    protected void save() {
        System.out.println("Saving PDF Document");
    }
}

// Client code now uses the common template process to handle different documents
class Application {
    public static void main(String[] args) {
        Document wordDoc = new WordDocument();
        wordDoc.processDocument(); // Common process flow handled by template method

        Document pdfDoc = new PdfDocument();
        pdfDoc.processDocument(); // Common process flow handled by template method
    }
}
```

### **Improvements in the Above Code**
- **Centralized Control**: The `processDocument` method provides a single, reusable structure for the algorithm, with steps defined in the base class.
- **Reduced Duplication**: Shared structure is defined in the superclass, so subclasses only provide specific implementations for each step, following DRY principles.
- **Improved Extensibility**: The template method allows easy addition of new document types or changes to the process structure without modifying existing subclasses.

---

## **Considerations for Effective Use of the Template Method Pattern**
- **Fixed Algorithm Sequence**: Ensure the algorithm sequence is stable and unlikely to require dynamic changes, as Template Method is not suited for highly variable workflows.
- **Selective Abstraction**: Determine which steps need to vary across subclasses and mark them as abstract, ensuring unnecessary details are not exposed.
- **Encapsulate Hooks Carefully**: Use hooks (optional methods in the base class) when some steps are needed in specific scenarios, providing flexibility without subclass overrides.

---

## **Conclusion**
The Template Method pattern is an effective way to establish a clear, reusable structure for algorithms with consistent steps but varying implementations. By defining the algorithm’s skeleton in a base class and deferring specific steps to subclasses, Template Method centralizes control, promotes code reuse, and simplifies modifications. It is particularly well-suited for scenarios where multiple classes follow a similar process with distinct details. However, it works best when the algorithm's structure is fixed and stable, as dynamic adjustments to the sequence are more challenging to accommodate within this pattern. When used appropriately, Template Method enhances maintainability and readability by reducing duplication and enforcing consistent process structures across related classes.