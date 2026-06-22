public class Application {
    public static void main(String[] args) {
        MonInterfaceA ifacea = new MonImplA();

        MonInterfaceA ifacea2 = new MonInterfaceA() {
            @Override
            public int maths(int a, int b) {
                return a + b;
            }
        };

        MonInterfaceA ifacea3 = (int a, int b) -> {
            return a * b;
        };

        MonInterfaceA ifacea4 = (a, b) -> a / b;
        MonInterfaceA ifacea5 = Application::demoRefMethod;

        ifacea.maths(5, 10);
        ifacea2.maths(4, 7);
        ifacea3.maths(5, 6);
    }

    public static int demoRefMethod(int a, int b) {
        return a * a * b;
    }
}
