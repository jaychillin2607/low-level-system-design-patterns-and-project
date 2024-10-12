# **Title**: Proxy Design Pattern Report

## **Introduction**

The Proxy Design Pattern is a structural pattern used to provide a surrogate or placeholder for another object to control access to it. It allows the real object to be accessed indirectly through the proxy, which can handle additional functionality such as controlling access, managing resource-intensive operations, or adding security.

## **Source Definition (Exact)**

"The Proxy pattern provides a surrogate or placeholder for another object to control access to it" - _Design Patterns: Elements of Reusable Object-Oriented Software (GoF)_.

## **Easy Definition**

The Proxy Design Pattern acts as a middleman that controls and manages access to another object. Instead of directly interacting with the real object, you go through the proxy, which can perform extra operations such as validation, logging, or lazy initialization before calling the real object.

## **Why is the Proxy Design Pattern used?**

The Proxy Design Pattern is used when:

- You want to control access to an object, especially when it’s resource-intensive to create or operate.
- Additional functionality like logging, security checks, or caching needs to be added to object access.
- It’s necessary to delay the creation or initialization of an object until it is needed, improving resource management.

This pattern provides flexibility by separating the client from the underlying object and reducing direct dependencies, making it easier to introduce new features.

## **When to use the Proxy Design Pattern**

- When you need to control access to an object that is expensive to create, like in virtual proxies for heavy resources (e.g., large images).
- When you need to add security, for example in protection proxies that restrict access based on user permissions.
- When you want to perform lazy loading of objects and delay their instantiation until absolutely necessary.
- When access to an object needs to be controlled remotely, such as in remote proxies.

## **When not to use the Proxy Design Pattern**

- In simple systems where direct object access does not introduce performance or security issues.
- In scenarios where the overhead of introducing a proxy would unnecessarily complicate the architecture.
- When the object does not require any access control, additional functionality, or lazy initialization.

## **Key Points of the Proxy Design Pattern**

- The proxy object serves as an intermediary, controlling access to the real object.
- It allows additional functionality (e.g., security, logging, caching) to be added without modifying the real object.
- The pattern provides flexibility and loose coupling between the client and the real object.
- It supports lazy initialization, remote access, and security checks.
- There are various types of proxies, including virtual proxies, protection proxies, and remote proxies.

## **Code Example Without Proxy Design Pattern**

```java
public class RealImage {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk.");
    }
}

public class Client {
    public static void main(String[] args) {
        RealImage image = new RealImage("image1.jpg");
        image.display();
        image.display();
    }
}
```

### **Issues in the Above Code**

- **Tight coupling**: The client is tightly coupled with the `RealImage` class.
- **Resource-intensive operations**: The image is loaded from disk every time it’s created, which is inefficient if the image is not always needed immediately.
- **Lack of flexibility**: It’s hard to add additional functionality like caching or security checks without modifying the `RealImage` class.

## **Improved Code Using the Proxy Design Pattern**

```java
interface Image {
    void display();
}

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage("image1.jpg");
        image.display();
        image.display();
    }
}
```

### **Improvements in the Above Code**

- **Lazy initialization**: The real image is only loaded from disk when it is first needed, reducing unnecessary resource usage.
- **Loose coupling**: The client interacts with the `Image` interface, not directly with the `RealImage` class, making the system more flexible.
- **Additional functionality**: The proxy can easily be extended to include security checks, caching, or other responsibilities without modifying the real object.

## **Conclusion**

The Proxy Design Pattern offers several advantages, including controlled access, resource management, and flexibility in adding extra functionality like caching or security. It decouples the client from the real object and allows lazy initialization. However, introducing proxies adds complexity and may not be necessary in simple systems where direct access is sufficient. It’s best used when there is a clear need to manage resources or control object access.
