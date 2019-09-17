package mauler.impl;

import exception.NoMaulException;
import mauler.StringMauler;

public class StringMaulerImpl implements StringMauler {

    private StringBuilder stringBuilder;

    @Override
    public String prepend(String str) throws NoMaulException {
        if(stringBuilder == null) {
            throw new NoMaulException("Please create a new string to maul.");
        }
        return stringBuilder.insert(0, str)
                .toString();
    }

    @Override
    public String reverse() throws NoMaulException {
        if(stringBuilder == null) {
            throw new NoMaulException("Please create a new string to maul.");
        }
        return stringBuilder.reverse().toString();
    }

    @Override
    public String create(){
       return  (stringBuilder = new StringBuilder()).toString();
    }

    @Override
    public String append(String str) throws NoMaulException {
        if(stringBuilder == null) {
            throw new NoMaulException("Please create a new string to maul.");
        }
        return stringBuilder.append(str).toString();
    }

    public StringBuilder getMauler() {
        return stringBuilder;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(stringBuilder == null ? "" : "\"" + stringBuilder.toString() +"\"");
        return sb.toString();
    }
}
