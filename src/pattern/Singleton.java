package pattern;

class Singleton {
    // static class
    private static Singleton instance;
    private Singleton() {
    }

    public static synchronized Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
    public static void doSomething()
    {
        System.out.println("Somethong is Done.");
    }
}