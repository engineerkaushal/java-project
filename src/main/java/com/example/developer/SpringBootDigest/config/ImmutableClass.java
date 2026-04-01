package com.example.developer.SpringBootDigest.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ImmutableClass {
    public static void main (String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Date date = new Date ();
        ImmutableClassObject object = new ImmutableClassObject ("Kaushal", 29, date, new ArrayList<> ());

        System.out.println (object.getDate () );

        date.setDate (1);

        System.out.println (object.getDate () );

    }
}

final class ImmutableClassObject {
    private final String name;
    private final int age;
    private final Date date;
    private final List<Integer> value;

    public ImmutableClassObject (String name, int age, Date date, List<Integer> value) {
        this.name = name;
        this.age = age;
        this.date = new Date (date.getTime ());
        this.value = Collections.unmodifiableList (value);
    }

    public String getName () {
        return name;
    }

    public int getAge () {
        return age;
    }

    public Date getDate () {
        return new Date ( date.getTime ());
    }

    public
    List<Integer> getValue () {
        return new ArrayList<> ( value );
    }
}
