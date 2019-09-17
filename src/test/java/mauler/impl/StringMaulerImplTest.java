package mauler.impl;

import exception.NoMaulException;
import junit.framework.Assert;
import mauler.StringMauler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("StringMauler unit tests")
public class StringMaulerImplTest{

    private StringMauler mauler;

    @BeforeEach
    public void init() throws NoMaulException{
        mauler = new StringMaulerImpl();
        mauler.create();
    }

    @Test
    void appendShouldThrowAnExceptionWhenThereIsNoStringToMaule() {
        String expectedErrorMessage = "Please create a new string to maul.";

        try {
            mauler.append("This should throw an exception.");
        } catch(NoMaulException ex){
            System.out.println(ex.getMessage());

            Assert.assertEquals(expectedErrorMessage, ex.getMessage());
        }
    }

    @Test
    void prependShouldThrowAnExceptionWhenThereIsNoStringToMaule() {
        String expectedErrorMessage = "Please create a new string to maul.";

        try{
            mauler.prepend("This should throw an exception.");
        }catch(NoMaulException ex){
            System.out.println(ex.getMessage());

            Assert.assertEquals(expectedErrorMessage, ex.getMessage());
        }
    }


    @Test
    @DisplayName("Should append string to the mauler")
    public void testAppend() throws NoMaulException{

        mauler = new StringMaulerImpl();
        mauler.create();

        final String expected = "ziyanda";

        Assert.assertEquals(expected ,
                mauler.append("ziyanda"));
    }

    @Test
    @DisplayName("Should prepend string to the mauler")
    public void testPrepend() throws NoMaulException{

        mauler = new StringMaulerImpl();
        mauler.create();

        final String expected = "mnguniziyanda";


        mauler.append("ziyanda");

        Assert.assertEquals(expected ,
                mauler.prepend("mnguni"));
    }

}