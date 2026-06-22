public interface MonInterfaceA {
    public int maths(int a, int b);

    public default int divide(int a, int b) {
        return 0;
    }
}
