package ModelTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Instalation {
    @Test
    void setPrograms(){
        ArrayList<String> listPrograms = new ArrayList<String>();
        String program1 = "Word";
        String program2 = "Firefox";
        String program3 = "Chrome";

        listPrograms.add(program1);
        listPrograms.add(program2);
        listPrograms.add(program3);

        Model.Instalation instalation = new Model.Instalation(listPrograms, 10.0, 0.0);

        assertEquals("Firefox", instalation.getProgram(1));
    }
}
