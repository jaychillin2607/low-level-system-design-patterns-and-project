# **Title**: Composite Design Pattern Report

## **Introduction**

The Composite design pattern is a structural pattern that allows treating individual objects and compositions of objects uniformly. It composes objects into tree-like structures to represent part-whole hierarchies, enabling clients to treat individual objects and compositions of objects in the same way.

## **Source Definition (Exact)**

> "Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly."  
> — GoF (Gang of Four) Design Patterns Book

## **Easy Definition**

The Composite pattern allows building complex structures out of simpler objects while treating both single objects and groups of objects the same way. This pattern is often used for tree-like structures like directories, menus, or graphical elements.

## **Why is the Composite used?**

- **Uniformity**: It allows treating both individual objects and compositions of objects uniformly.
- **Hierarchical Structures**: It’s ideal for representing part-whole hierarchies, such as trees or nested structures.
- **Simplification**: Clients can interact with complex structures through a simple interface, without worrying about the underlying complexity.
- **Extensibility**: New types of components can be easily added to the structure without affecting client code.

## **When to use the Composite**

- When you want to represent part-whole hierarchies in your system, like a tree structure.
- When you want to treat individual objects and compositions of objects uniformly.
- When building complex user interfaces, graphical elements, or file systems that involve nested structures.
- When client code should not have to differentiate between leaf objects (individual) and composite objects (groups).

## **When not to use the Composite**

- When objects in the structure do not share common operations or interfaces.
- When the hierarchy is simple and doesn’t require complex compositions.
- When handling differences between leaf and composite nodes is crucial to the application’s logic.

## **Key Points of the Composite**

- **Part-Whole Hierarchies**: Represents objects in hierarchical structures, like trees.
- **Uniform Treatment**: Allows treating both leaf (single) objects and composite objects in the same way.
- **Simplifies Client Code**: Clients can treat all objects the same, without worrying about whether they’re dealing with a single object or a group.
- **Reusability and Extensibility**: Easily extendable by adding new component types or composites.

## **Code Example Without Composite**

```java
class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("File: " + name);
    }
}

class Directory {
    private String name;
    private List<File> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void display() {
        System.out.println("Directory: " + name);
        for (File file : files) {
            file.display();
        }
    }
}

class Application {
    public static void main(String[] args) {
        Directory directory = new Directory("My Documents");
        File file1 = new File("Resume.doc");
        File file2 = new File("Budget.xlsx");

        directory.addFile(file1);
        directory.addFile(file2);

        directory.display();
    }
}
```

### **Issues in the Above Code**

- **Separate Handling**: The `File` and `Directory` classes are handled separately. There’s no shared interface between `File` and `Directory`, making it difficult to handle both types uniformly.
- **Limited Extensibility**: If we want to add subdirectories or other components, we need to modify the `Directory` class significantly.
- **Complex Client Code**: The client has to treat files and directories differently, leading to more complex logic in cases with nested structures or more complex hierarchies.

## **Improved Code Using the Composite**

```java
import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemComponent {
    void display();
}

// Leaf - File
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}

// Composite - Directory
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}

// Client
class Application {
    public static void main(String[] args) {
        Directory rootDirectory = new Directory("My Documents");
        File file1 = new File("Resume.doc");
        File file2 = new File("Budget.xlsx");

        Directory subDirectory = new Directory("Projects");
        File file3 = new File("Project1.ppt");

        rootDirectory.addComponent(file1);
        rootDirectory.addComponent(file2);
        rootDirectory.addComponent(subDirectory);

        subDirectory.addComponent(file3);

        rootDirectory.display();
    }
}
```

### **Improvements in the Above Code**

- **Uniform Interface**: Both `File` and `Directory` implement the `FileSystemComponent` interface, allowing the client to treat them uniformly.
- **Simplified Client Code**: The client no longer needs to distinguish between individual files and directories. The `display()` method works the same way regardless of whether the component is a file or a directory.
- **Extensibility**: New components (like different types of files or directories) can be easily added without modifying existing classes, adhering to the Open/Closed principle.
- **Supports Complex Hierarchies**: The structure can now support arbitrary nesting of directories and files, making it ideal for complex, tree-like structures.

## **Conclusion**

The Composite design pattern is ideal for dealing with tree structures that represent part-whole hierarchies, such as file systems or UI components. By allowing individual objects and compositions of objects to be treated uniformly, it simplifies client code and makes the system more flexible and extensible. While the Composite pattern provides a powerful way to build complex structures, it is unnecessary in simple cases where the distinction between single objects and compositions isn’t important. Nevertheless, it provides a clear solution to managing complex hierarchies effectively.
