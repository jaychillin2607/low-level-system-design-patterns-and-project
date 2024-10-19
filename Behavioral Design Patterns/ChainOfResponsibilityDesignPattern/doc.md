# **Title**: Chain of Responsibility Design Pattern Report

## **Introduction**

The Chain of Responsibility design pattern is a behavioral pattern that allows multiple objects to handle a request, with each object having the opportunity to process the request or pass it along the chain to the next handler. This pattern promotes loose coupling between sender and receiver by giving more than one object a chance to handle a request.

## **Source Definition (Exact)**

"_Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it._"

\- _GoF (Gang of Four) Design Patterns Book_

## **Easy Definition**

The Chain of Responsibility pattern allows a request to pass through a series of handlers until one of the handlers processes it. Each handler decides whether to handle the request or forward it to the next handler in the chain.

## **Why is the Chain of Responsibility used?**

The Chain of Responsibility pattern is used for:

- **Decoupling** the sender from the receiver: The sender of a request doesn’t know which object will handle the request.
- **Flexibility**: New handlers can be added to the chain without modifying existing handlers or the client code.
- **Responsibility delegation**: Several handlers can process a request, and only one (or none) may choose to handle it.
- **Handling requests in stages**: Each handler can perform part of the processing, creating a modular solution.

## **When to use the Chain of Responsibility**

- When multiple objects might handle a request, and the handler isn’t known beforehand.
- When you want to decouple the sender of a request from its potential handlers.
- When you want to create a flexible mechanism to add or change handlers without affecting the client code.
- When the request needs to be processed in a staged or hierarchical manner.

## **When not to use the Chain of Responsibility**

- When all requests must be handled by a single, well-defined object.
- When it’s more efficient for the client to know exactly which object should handle the request, to avoid unnecessary request passing.
- When a more rigid or explicit delegation of responsibilities is needed.

## **Key Points of the Chain of Responsibility**

- **Decoupling** between sender and receiver.
- **Dynamic processing**: The client doesn't need to know which handler will process the request.
- **Modular handling**: Handlers can be easily added, removed, or reordered in the chain.
- **Delegation of responsibility**: Requests can be passed along the chain until a handler processes them or the chain ends.

## **Code Example Without Chain of Responsibility**

```java
class Logger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    private int logLevel;

    public Logger(int logLevel) {
        this.logLevel = logLevel;
    }

    public void logMessage(int level, String message) {
        if (level == INFO) {
            System.out.println("INFO: " + message);
        } else if (level == DEBUG) {
            System.out.println("DEBUG: " + message);
        } else if (level == ERROR) {
            System.out.println("ERROR: " + message);
        }
    }
}

class Application {
    public static void main(String[] args) {
        Logger logger = new Logger(Logger.DEBUG);
        logger.logMessage(Logger.INFO, "This is an info message.");
        logger.logMessage(Logger.DEBUG, "This is a debug message.");
        logger.logMessage(Logger.ERROR, "This is an error message.");
    }
}
```

### **Issues in the Above Code**

- **Tight Coupling**: The `Logger` class is tightly coupled to the logic that determines the log level and message handling. This violates the Open/Closed principle (OCP), as adding new log levels or message types requires modifying the `Logger` class.
- **Lack of Flexibility**: There is no easy way to modify the behavior for logging different types of messages without changing the `Logger` class.
- **Hardcoded Decision Logic**: The log level decision-making is hardcoded in the `Logger` class, making it difficult to extend or modify without directly altering the class.

## **Improved Code Using the Chain of Responsibility**

```java
abstract class Logger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int logLevel;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.logLevel <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

class InfoLogger extends Logger {
    public InfoLogger(int logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}

class DebugLogger extends Logger {
    public DebugLogger(int logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger(int logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}

class Application {
    private static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        Logger infoLogger = new InfoLogger(Logger.INFO);

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        return infoLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(Logger.INFO, "This is an info message.");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug message.");
        loggerChain.logMessage(Logger.ERROR, "This is an error message.");
    }
}
```

### **Improvements in the Above Code**

- **Decoupled Handlers**: Each logger (`InfoLogger`, `DebugLogger`, `ErrorLogger`) handles specific log levels independently and passes the request along the chain if it cannot process it.
- **Extensibility**: Adding new log levels or types of loggers is easy by simply creating new subclasses of `Logger` and linking them in the chain. The existing classes remain unchanged, adhering to the Open/Closed principle.
- **Separation of Concerns**: Each logger is responsible for handling only a specific type of log, promoting cleaner code and a modular structure.

## **Conclusion**

The Chain of Responsibility pattern offers a flexible and decoupled way to delegate responsibility for handling a request to multiple objects. This pattern is particularly useful when multiple objects can process a request, but the exact object that will handle it is unknown. By chaining the objects, the pattern allows each handler to either process the request or pass it to the next handler. While it offers flexibility, the pattern should be avoided in situations where a single, known object should handle the request directly, as the extra indirection can introduce unnecessary complexity.
