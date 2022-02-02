public class App {

    public static void main(String[] args) {

        Task taskObj = new Task();
        taskObj.fileRead("EUcsatlakozas.txt");

        // 3.feladat
        System.out.println("3. feladat: EU tagállamainak száma: " + taskObj.states2018());

        // 4.feladat
        System.out.println("4. feladat: 2007-ben " + taskObj.statesJoin2007() + " ország csatlakozott.");

        // 5.feladat
        taskObj.hungaryJoin();

        // 6. feladat
        taskObj.joinMay();

        // 7. feladat
        taskObj.lastStateJoin();

        // 8. feladat
        taskObj.joinStatistics();

    }
}
