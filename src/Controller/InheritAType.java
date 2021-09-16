package Controller;

public class InheritAType {

    public static void main(String[] args) {
        System.out.println("Hello Everybody this is me");
        printVal(new C());
    }

    public static void printVal(B obj){
        obj.method();
    }
}

class A{
    public void method(){
        System.out.println("class A");
    }
}

class B extends A{
    @Override
    public void method() {
        System.out.println("class B");
    }
}

class C extends B{
    @Override
    public void method() {
        System.out.println("class C");
    }
}
