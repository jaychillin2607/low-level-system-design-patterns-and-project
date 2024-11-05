# **Title**: Flyweight Design Pattern Report

## **Introduction**
The Flyweight design pattern is a structural pattern focused on minimizing memory usage by sharing as much data as possible with similar objects. It achieves efficiency by reusing existing instances of objects with common intrinsic data, avoiding the cost of creating many small objects for similar entities. This pattern is particularly effective when dealing with large numbers of fine-grained objects.

## **Source Definition (Exact)**
> "Use sharing to support large numbers of fine-grained objects efficiently."  
> — GoF (Gang of Four) Design Patterns Book

## **Easy Definition**
The Flyweight pattern saves memory by sharing common data among objects, so multiple instances can use the same data instead of each having its own copy.

## **Why is the Flyweight used?**
- **Memory Optimization**: By reusing shared objects, it significantly reduces memory usage, especially when dealing with large numbers of similar objects.
- **Performance Improvement**: Reusing instances of objects prevents costly instantiation, leading to better performance.
- **Encourages Object Sharing**: The Flyweight pattern promotes the sharing of intrinsic states (data that is common across instances), allowing only unique extrinsic states to differ among objects.

## **When to use the Flyweight**
- When an application has a large number of objects with mostly shared state and only a few unique properties.
- When memory usage is a concern, and there is an opportunity to share objects instead of creating multiple similar ones.
- When fine-grained objects are needed but should not lead to high memory usage.

## **When not to use the Flyweight**
- When the objects do not share common states, as there would be little benefit from using this pattern.
- When the unique extrinsic state of each object outweighs the intrinsic shared state, reducing the effectiveness of memory saving.
- When the application doesn’t involve a high number of similar objects, as there would be no memory or performance gain.

## **Key Points of the Flyweight**
- **Intrinsic vs. Extrinsic State**: Intrinsic state is shared across objects, while extrinsic state is passed from the outside.
- **Object Pooling**: Flyweight often uses an object pool to manage shared instances, ensuring objects are reused efficiently.
- **Enhanced Memory Management**: By avoiding redundant data storage, Flyweight reduces the memory footprint of an application.

---

## **Code Example Without Flyweight Pattern**
```java
// Without Flyweight, we create multiple instances for similar data, leading to high memory usage.

class Tree {
    private String type;
    private String color;
    private int height;
    private int x;
    private int y;

    public Tree(String type, String color, int height, int x, int y) {
        this.type = type;
        this.color = color;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("Drawing " + type + " tree of color " + color + " at (" + x + ", " + y + ")");
    }
}

class Application {
    public static void main(String[] args) {
        Tree oak1 = new Tree("Oak", "Green", 15, 10, 20);
        Tree oak2 = new Tree("Oak", "Green", 15, 30, 40);
        Tree oak3 = new Tree("Oak", "Green", 15, 50, 60);

        oak1.draw();
        oak2.draw();
        oak3.draw();
    }
}
```

### **Issues in the Above Code**
- **High Memory Usage**: Each `Tree` instance stores the same `type`, `color`, and `height` information, leading to unnecessary memory use for repeated data.
- **Redundant Data**: Shared data among trees (like type and color) is duplicated, which is inefficient.
- **Limited Scalability**: As more trees are added, memory usage will increase linearly, potentially causing performance issues.

---

## **Improved Code Using the Flyweight Pattern**
```java
// Flyweight interface
interface TreeType {
    void draw(int x, int y);
}

// Concrete Flyweight class for shared TreeType
class SharedTreeType implements TreeType {
    private String type;
    private String color;
    private int height;

    public SharedTreeType(String type, String color, int height) {
        this.type = type;
        this.color = color;
        this.height = height;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing " + type + " tree of color " + color + " at (" + x + ", " + y + ")");
    }
}

// Flyweight Factory for managing TreeType instances
class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String type, String color, int height) {
        String key = type + "-" + color + "-" + height;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new SharedTreeType(type, color, height));
            System.out.println("Creating new TreeType: " + key);
        }
        return treeTypes.get(key);
    }
}

// Context class to represent tree locations
class Tree {
    private int x;
    private int y;
    private TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw() {
        treeType.draw(x, y);
    }
}

// Client code
class Application {
    public static void main(String[] args) {
        TreeType oakType = TreeFactory.getTreeType("Oak", "Green", 15);
        Tree oak1 = new Tree(10, 20, oakType);
        Tree oak2 = new Tree(30, 40, oakType);
        Tree oak3 = new Tree(50, 60, oakType);

        oak1.draw();
        oak2.draw();
        oak3.draw();
    }
}
```

### **Improvements in the Above Code**
- **Reduced Memory Usage**: The `TreeFactory` reuses instances of `SharedTreeType`, minimizing memory usage for large numbers of trees with shared properties.
- **Optimized Data Storage**: Common properties are stored once per `TreeType`, eliminating redundancy.
- **Improved Scalability**: New `Tree` instances can be created without duplicating shared data, allowing for efficient memory usage as the application scales.

---

## **Considerations for Effective Use of the Flyweight Pattern**
- **Balance Intrinsic and Extrinsic State**: For Flyweight to be effective, the majority of data should be intrinsic and sharable, with only minimal extrinsic data.
- **Use with Object Pools**: The Flyweight pattern is commonly used with object pools to manage instances and control memory usage.
- **Effective Key Management in Factory**: For efficient reuse, the Flyweight Factory should use meaningful keys to identify unique instances and avoid creating duplicates.

---

## **Conclusion**
The Flyweight pattern is ideal for applications that need to handle large numbers of similar, fine-grained objects efficiently. By separating shared intrinsic state from unique extrinsic state, it minimizes memory consumption and improves performance. This pattern is particularly effective in resource-constrained environments, such as games or graphics-intensive applications where object reuse is critical. However, Flyweight should be applied thoughtfully, as it may add complexity, especially when managing intrinsic and extrinsic state is challenging.