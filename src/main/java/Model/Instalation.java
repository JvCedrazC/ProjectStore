package Model;

import java.util.ArrayList;
import java.util.List;
public class Instalation extends Services{
    private static ArrayList<String> programs = new ArrayList<String>();
    public Instalation(ArrayList<String> program, Double price, Double cost){
        addPrograms(program);
        setPrice(price);
        setCost(cost);
    }
    public List<String> getPrograms() {
        return programs;
    }
    public String getProgram(int index){
        return programs.get(index);
    }

    private void addPrograms(ArrayList<String> programsList){
        for (int i = 0; i < programsList.size();i++){
            this.programs.add(programsList.get(i));
        }
    }
}
