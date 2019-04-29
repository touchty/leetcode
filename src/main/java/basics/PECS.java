package basics;
// https://www.cnblogs.com/drizzlewithwind/p/6100164.html
public class PECS {
    //Lev 1
    static class Food{}

    //Lev 2
    static class Fruit extends Food{}
    static class Meat extends Food{}

    //Lev 3
    static class Apple extends Fruit{}
    static class Banana extends Fruit{}
    static class Pork extends Meat{}
    static class Beef extends Meat{}

    //Lev 4
    static class RedApple extends Apple{}
    static class GreenApple extends Apple{}

    static class Plate<T>{
        private T item;
        public Plate(T t){item=t;}
        public void set(T t){item=t;}
        public T get(){return item;}
    }

    static void extendTest(){
        Plate<? extends Fruit> p=new Plate<Apple>(new Apple());

        //不能存入任何元素
        //p.set(new Fruit());    //Error
        //p.set(new Apple());    //Error

//读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1=p.get();
        Object newFruit2=p.get();
        //Apple newFruit3=p.get();    //Error
    }


    static void superTest(){
        Plate<? super Fruit> p=new Plate<Fruit>(new Fruit());

        //存入元素正常
        p.set(new Fruit());
        p.set(new Apple());
        p.set(new RedApple());

        //读取出来的东西只能存放在Object类里。
        //Apple newFruit3=p.get();    //Error
        //Fruit newFruit1=p.get();    //Error
        Object newFruit2=p.get();
    }

    public static void main(String[] args) {
        extendTest();
        superTest();
    }
}
