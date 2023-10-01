import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TextApplication textApplication = new TextApplication();
        StartApplication startApplication = new StartApplication();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствую вас в программе для добавления текста на изображение!");
        textApplication.basicCommands();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("/help")) {
                textApplication.printHelp();
                textApplication.basicCommands();
            } else if (command.equals("/close")) {
                System.out.println("До новых встречь!");
                break;
            } else if (command.equals("/start")) {
                startApplication.startApp();
                textApplication.basicCommands();
            } else {
                System.out.println("Такой команды нет");
                textApplication.basicCommands();
            }
        }
    }

}
