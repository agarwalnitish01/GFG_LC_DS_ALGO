package test;

interface A {
    void a();//bydefault, public and abstract

    void b();

    void c();

    void d();
}


abstract class B implements A {
    public void c() {
        System.out.println("I am C ABSTRACT");
    }
}

class M extends B {
    public void a() {
        System.out.println("I am a");
    }

    public void b() {
        System.out.println("I am b");
    }


    public void d() {
        System.out.println("I am d");
    }
}

//Creating a test class that calls the methods of A interface
class Test5 {
    public static void main(String args[]) {
        A a = new M();
        a.a();
        a.b();
        a.c();
        a.d();
    }
}