package mauler;

import exception.NoMaulException;

public interface StringMauler {

    String create() throws NoMaulException;
    String prepend(String str) throws NoMaulException;
    String reverse() throws NoMaulException;
    String append(String str) throws NoMaulException;

}
