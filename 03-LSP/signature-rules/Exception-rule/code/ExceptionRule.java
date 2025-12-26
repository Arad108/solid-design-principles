class Parent {
    public void getValue() throws RuntimeException {
        throw new RuntimeException("Parent error");
    }
}

// Subclass overrides getValue and throws the narrower ChildException
class Child extends Parent {
    @Override
    public void getValue() throws ArithmeticException {
        throw new ArithmeticException("Child error");
        //throw new Exception("Child error"); // This is wrong & not allowed
    }
}

// Client that invokes getValue and catches the parent exception type
class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void takeValue() {
        try {
            p.getValue();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred: " + e.getMessage());
        }
    }
}

public class ExceptionRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child   = new Child();

        Client client = new Client(parent);
        //Client client = new Client(child);
        
        client.takeValue();  
    }
}