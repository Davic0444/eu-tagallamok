import java.time.LocalDate;
import java.util.*;

public class Task {

    List<Entity> states = new ArrayList<Entity>();
    FileManager fmObj = new FileManager();

    public void fileRead(String fileName) {
        states = fmObj.fileReader(fileName);
    }

    public int states2018() {
        return states.size();
    }

    public int statesJoin2007() {
        int join = 0;
        for (Entity state : states) {
            if (state.getEuJoin().getYear() == 2007) {
                join++;
            }
        }
        return join;
    }

    public void hungaryJoin() {
        for (Entity state : states) {
            if (state.getCountry().equalsIgnoreCase("Magyarország")) {
                System.out.println("5. feladat: Magyarország csatlakozásanak dátuma " + state.getEuJoin());
            }
        }
    }

    public boolean joinMay() {
        boolean joinMay = false;
        for (Entity state : states) {
            if (state.getEuJoin().getMonthValue() == 5) {
                joinMay = true;
            } else {
                joinMay = false;
            }
        }
        if (joinMay = true) {
            System.out.println("6. feladat: Májusban volt csatlakozás!");
        } else {
            System.out.println("6. feladat: Majusban nem volt csatlakozás!");
        }
        return joinMay;
    }

    public void lastStateJoin() {
        Collections.sort(states, new Comparator<Entity>() {
            public int compare(Entity o1, Entity o2) {
                return o1.getEuJoin().compareTo(o2.getEuJoin());
            }
        });

        int lastIndex = 0;
        for (int i = 0; i < states.size(); i++) {
            if (states.get(i).getEuJoin().getYear() > lastIndex) {
                lastIndex = i;
            }
        }
        System.out.println("Legutoljára csatlakozott ország: " + states.get(lastIndex).getCountry());
    }

    public void joinStatistics() {

        List<LocalDate> yearList = new ArrayList<>();

        for (int i = 0; i < states.size(); i++) {
            boolean isIn = false;
            for (int j = 0; j < yearList.size(); j++) {
                if (states.get(i).getEuJoin() == yearList.get(j)) {
                    isIn = true;
                }
            }
            if (isIn == false) {
                yearList.add(states.get(i).getEuJoin());
            }
        }
        int[] numberOfStates = new int[yearList.size()];
        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < yearList.size(); j++) {
                if (states.get(i).getEuJoin() == yearList.get(j)) {
                    numberOfStates[j]++;
                }
            }
        }

        for (int i = 0; i < numberOfStates.length; i++) {
            System.out.println("\t" + yearList.get(i) + ": " + numberOfStates[i] + " ország");
        }

    }

}

