package com.example.developer.SpringBootDigest.config;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {
    public static void main (String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, FileNotFoundException {

        SingletonClass singletonClass1 = SingletonClass.singletonMethod ();
        SingletonClass singletonClass2 = SingletonClass.singletonMethod ();
        singletonClass1.showMsg ();
        singletonClass2.showMsg ();

        //1. Trying to forcefully break using Reflection API
//        Constructor<?>[] declaredConstructors = SingletonClass.class.getDeclaredConstructors ( );
//        for (Constructor constructor : declaredConstructors) {
//            constructor.setAccessible (true);
//            SingletonClass cns = (SingletonClass) constructor.newInstance ();
//            cns.showMsg ();
//        }

        //2. Serialization & Deserialization
        //Serialize the instance
        try(ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("SingletonClass.ser"))) {
            oos.writeObject (singletonClass1);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        //DeSerialize the instance
        SingletonClass pattern4;
        try(ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("SingletonClass.ser"))) {
            pattern4 = (SingletonClass) ois.readObject ();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException (e);
        }

        pattern4.showMsg ();


        //3. Check Enum is thread safe or not
        Runnable rb = () -> {
            SingletonClass esp = SingletonClass.singletonMethod ();
            esp.showMsg ();
        };

        Thread t1 = new Thread ( rb, "Thread 1" );
        Thread t2 = new Thread ( rb, "Thread 2" );
        Thread t3 = new Thread ( rb, "Thread 3" );
        t1.start ();
        t2.start ();
        t3.start ();

    }
}

class SingletonClass implements Serializable, Cloneable {

    // step 1. create a private static instance
    private static SingletonClass instance;

    // step 2. make a constructor private to avoid to create object of this class
    private SingletonClass () {

        // To protect against reflection attacks
        if ( instance != null )
            throw new IllegalStateException ( "Singleton instance already created!" );
    }

    // step 3. provide public method to get the instance
    public static SingletonClass singletonMethod() {
        if ( instance == null ) {
            synchronized (SingletonClass.class) {
                if ( instance == null ) {
                    instance = new SingletonClass ();
                }
            }
        }
        return instance;
    }


    // Step 4.  Protect against serialization

    /*When an object is deserialized, the Java serialization mechanism creates a new instance.
    The readResolve() method is a special hook that allows you to substitute another object
    for the one created by the deserialization process before it is returned to the caller. *

     * This method is called by the serialization mechanism to ensure a single instance is returned.
     */
    private Object readResolve() {
        return instance;
    }

    // step 5. Protect against cloning
    @Override
    protected Object clone () throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cloning is not allowed");
    }

    public void showMsg() {
        System.out.println("Singleton Design pattern Initiated: "+ this.hashCode ());
    }
}
