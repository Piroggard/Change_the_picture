import ValidationData.ValidationNumber;

import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exception.ValueOutOfRangeException;

public class StartApplication {
    public static void startApp() throws IOException {
        TextApplication textApplication = new TextApplication();
        ValidationNumber validationNumber = new ValidationNumber();
        Scanner scanner = new Scanner(System.in);
        AddText addText = new AddText();
        try {
            System.out.println("Введите путть картинки или url");
            String path = scanner.nextLine();
            System.out.println("Введите такст который вы хотиде добавить на картинку");
            String text = scanner.nextLine();
            System.out.println("Ведите нужный шрифт");
            System.out.println("Свмый популярный шрифт это Times New Roman, Если хотел оставить его нажмите 1, " +
                    "если хотите выбрать из списка нажмите 2 и введите назввание шрифта," +
                    "если вы знаете нужный шрифт начинайте ввод ");
            String fontName;
            int selectedCode = scanner.nextInt();
            validationNumber.selectedCodeValidation(selectedCode);
            if (selectedCode == 1) {
                fontName = "Times New Roman";
            } else if (selectedCode == 2) {
                textApplication.getFont();
                fontName = scanner.next();
            } else {
                fontName = scanner.next();
            }
            System.out.println("Выберите стиль шрифта");
            textApplication.getListTextStyles();
            int fontStyles = scanner.nextInt();
            validationNumber.validationListTextStyles(fontStyles);

            System.out.println("Выберите размер шрифта ");
            int fontSize = scanner.nextInt();
            validationNumber.textSizeValidation(fontSize);
            textApplication.getColor();
            String color = scanner.next();
            textApplication.selectTextLocation();
            int textPosition = scanner.nextInt();
            validationNumber.validationSelectTextLocation(textPosition);

            addText.changePictureURl(path, text, fontName, fontStyles, fontSize, Color.decode(color), textPosition);
        } catch (NumberFormatException e) {
            System.out.println("Неверно введенн код цвета : " + e.getMessage());
        } catch (ValueOutOfRangeException exception) {
            System.out.println(exception.getMessage());
        } catch (InputMismatchException exception) {
            System.out.println("Неправельное выбранный шрифт, посмоторите список шрифтов и выберите которй есть на вашем устройстве");
        }

    }
}
