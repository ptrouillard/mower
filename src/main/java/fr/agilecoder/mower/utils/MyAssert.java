package fr.agilecoder.mower.utils;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:54
 */
public class MyAssert<T> {

    public T notNull(T object, String message) {
        if (object == null)
            throw new IllegalArgumentException(message);
        return object;
    }
}
