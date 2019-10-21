import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static final double PRECISION = 0.000001;

    private ArrayList<Triangle> triangles;

    public App() {
        triangles = new ArrayList<>();
    }

    public void showTriangleList() {
        System.out.println("============= Triangles list: ===============");
        int i = 1;
        for (Triangle item : triangles) {
            System.out.println(i + ". " + item.toString());
            i++;
        }
    }

    public void sortTriangleList() {
        triangles.sort((o1, o2) -> {
            double delta = o1.getArea() - o2.getArea();
            if (delta > PRECISION) {
                return -1;
            } else {
                return delta < -PRECISION ? 1 : 0;
            }
        });
    }

    public void addTriangle(Triangle tr) {

        triangles.add(tr);
    }

    public static void main(String[] args) throws NumberFormatException {
        App app = new App();
        boolean mainMenuIsRun = true;
        boolean createMenuIsRun = true;
        Scanner scanner = new Scanner(System.in);
        String key;
        int choice;
        while (mainMenuIsRun) {
            System.out.println("Enter - <1> to create triangle");
            System.out.println("Enter - <2> to show all triangles");
            System.out.println("Enter - <3> exit");
            key = scanner.nextLine();
            choice = Integer.valueOf(key);
            if (choice == 1) {
                while (createMenuIsRun) {
                    System.out.println("Format - <name>, <side1>, <side2>, <side3>");
                    try {
                        app.addTriangle(Triangle.valueOf(scanner.nextLine()));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("More(y/n)?");
                    switch (scanner.nextLine().toLowerCase()) {
                        case "y": {

                        }
                        case "yes": {
                            break;
                        }
                        default: {
                            app.sortTriangleList();
                            createMenuIsRun = false;
                            break;
                        }
                    }
                }
            } else if (choice == 2) {
                app.showTriangleList();
            } else if (choice == 3) {
                mainMenuIsRun = false;
            } else {
                System.out.println("srsly? pls enter 1 or 2");
            }
        }
        scanner.close();

    }
}
