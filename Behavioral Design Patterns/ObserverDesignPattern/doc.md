# Observer Design Pattern Report

## **Source Definition (Exact)**

The **Observer Design Pattern** is defined in the "Gang of Four" (GoF) Design Patterns book as:

_"Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically."_

## **Easy Definition**

The Observer Design Pattern allows an object (the **subject**) to notify multiple other objects (the **observers**) when its state changes. The observers can react to the state changes without the subject needing to know the details of each observer.

## **Why is the Observer Design Pattern used?**

The Observer Design Pattern is used to maintain consistency between objects. When one object’s state changes, it automatically informs other dependent objects, ensuring that they remain in sync. It decouples the subject and its observers, improving flexibility and maintainability. The pattern is typically used in scenarios where data needs to be broadcast to multiple listeners, such as GUI systems, real-time data feeds, or event-driven systems.

### **When to use the Observer Design Pattern**

- **Multiple Objects Depend on One:** Use the Observer pattern when one object’s state must automatically update several other dependent objects.
- **Decoupling:** When you want to decouple the object that sends notifications from the objects that receive notifications, allowing for better separation of concerns and modularity.
- **Event-driven Programming:** When you need a mechanism for broadcasting events to multiple listeners in a dynamic system.
- **Real-time Updates:** Suitable for applications like stock market data, notifications systems, or GUI components where data changes dynamically and multiple components need to respond to these changes in real-time.

## **When not to use the Observer Design Pattern**

- **Too Many Observers:** When the number of observers is very large, it might impact performance due to the time required to update all observers.
- **Tight Coupling Required:** If a system requires tight coupling between objects, this pattern might introduce unnecessary complexity since it aims to decouple subjects from observers.
- **Simple Dependency Management:** If only a simple relationship between objects exists, the Observer pattern might be overkill, and simpler solutions like direct method calls or callbacks may suffice.
- **Complex Update Logic:** If the updates between objects are complex and not just state-based, the Observer pattern might not be the best choice, and a more centralized solution might work better.

## The key points in the **Observer Design Pattern** are:

1. **Subject-Observer Relationship**: The pattern establishes a one-to-many relationship where one **subject** (also called the **observable**) notifies many **observers** when its state changes.

2. **Loose Coupling**: Observers are loosely coupled with the subject. The subject doesn’t need to know any specifics about the observers, only that they implement a standard interface. This makes the system flexible and extendable.

3. **Notification Mechanism**: When the subject changes its state, it triggers an update method in all registered observers. This ensures that all observers receive the same notification.

4. **Observer Registration and Deregistration**: Observers can dynamically subscribe (attach) or unsubscribe (detach) from the subject at runtime, allowing flexibility in managing which objects respond to state changes.

5. **Interface/Contract for Observers**: Observers implement a common interface (often with a method like `update()`). This standardisation allows the subject to notify all observers in a consistent manner.

6. **Separation of Concerns**: The subject manages its internal state, while observers handle how they respond to the changes. This helps in keeping the responsibilities clear and modular.

7. **Broadcast Communication**: The subject can notify multiple observers simultaneously, which is useful for event-driven programming or real-time systems.

8. **Scalability**: The pattern allows easy scaling as new observers can be added without modifying the subject’s code.

9. **Avoiding Tight Coupling and Duplicated Code**: By decoupling the subject from the observers, the pattern prevents tight dependencies and repeated notification logic within the subject.

10. **Potential Performance Concerns**: With a large number of observers, the time taken to notify all of them may lead to performance overhead.

## **Code Example**

### **Without Observer Design Pattern**

```java
class NewsAgency {
    private String news;

    public void setNews(String news) {
        this.news = news;
        // Notify individual channels manually
        updateChannels(news);
    }

    private void updateChannels(String news) {
        System.out.println("Updating CNN with news: " + news);
        System.out.println("Updating BBC with news: " + news);
        // More channels can be added here
    }
}

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.setNews("New government policies announced.");
    }
}
```

#### **Issues in the Above Code**

1. **Tight Coupling:** The `NewsAgency` class is tightly coupled with each news channel. Adding or removing a channel would require changes in the `NewsAgency` class.
2. **No Flexibility:** New channels can't be added dynamically without modifying the class.
3. **Code Duplication:** Each channel update logic must be manually written.
4. **No Separation of Concerns:** The class responsible for setting the news is also responsible for notifying every observer.

### **Improved Code Using the Observer Design Pattern**

```java
import java.util.ArrayList;
import java.util.List;

// Subject (News Agency)
class NewsAgency {
    private List<NewsChannel> channels = new ArrayList<>();
    private String news;

    public void addObserver(NewsChannel channel) {
        channels.add(channel);
    }

    public void removeObserver(NewsChannel channel) {
        channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    private void notifyObservers() {
        for (NewsChannel channel : channels) {
            channel.update(news);
        }
    }
}

// Observer (News Channel)
interface NewsChannel {
    void update(String news);
}

// Concrete Observer (CNN)
class CNN implements NewsChannel {
    @Override
    public void update(String news) {
        System.out.println("CNN reporting: " + news);
    }
}

// Concrete Observer (BBC)
class BBC implements NewsChannel {
    @Override
    public void update(String news) {
        System.out.println("BBC reporting: " + news);
    }
}

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        CNN cnn = new CNN();
        BBC bbc = new BBC();

        agency.addObserver(cnn);
        agency.addObserver(bbc);

        // Set news and notify observers
        agency.setNews("New government policies announced.");
    }
}
```

#### **Improvements in the Above Code**

1. **Decoupling:** The `NewsAgency` class doesn't need to know the specific channels that will receive the news. Channels can be dynamically added or removed without modifying the `NewsAgency` class.
2. **Scalability:** New channels (observers) can be added by simply implementing the `NewsChannel` interface.
3. **Separation of Concerns:** The `NewsAgency` class is only responsible for managing the news, while the `NewsChannel` instances handle how they update their content.
4. **Flexibility:** Channels can be added or removed at runtime without requiring changes to the core code structure.

## **Conclusion**

The Observer Design Pattern offers a flexible and decoupled way to manage the relationships between subjects and observers. It is particularly useful when one object needs to notify multiple other objects of changes. While powerful, it should be used judiciously, as the pattern can lead to increased complexity if there are many observers or if updates are complicated. It is ideal in event-driven systems, real-time notifications, and GUIs, but may not be necessary in simpler scenarios where tight coupling or direct method calls suffice.
