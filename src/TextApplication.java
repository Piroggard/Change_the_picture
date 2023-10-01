import java.awt.*;

public class TextApplication {
    public void selectTextLocation (){
        System.out.println("Теперь вам необходимо выбрать код нужного расположение текса");
        System.out.println("1- Левый верхний угол");
        System.out.println("2- По центру верх");
        System.out.println("3- Правый верхний угол");
        System.out.println("4- Левый центр");
        System.out.println("5- Центр");
        System.out.println("6- Правый центр");
        System.out.println("7- Правый низ");
        System.out.println("8- центр низ");
        System.out.println("9- Правый низ");
    }


    public  void getColor (){
        System.out.println("Перед вами самые распространенные цвета, выдерите из спискаа нужный код или введите другой");
        System.out.println("Черный - #000000");
        System.out.println("Серый - #808080");
        System.out.println("Серебряный - #c0c0c0");
        System.out.println("Белый - #ffffff");
        System.out.println("Фуксия, Маджента - #ff00ff");
        System.out.println("Пурпурный - #800080");
        System.out.println("Красный - #ff0000");
        System.out.println("Коричнево-малиновый - #800000");
        System.out.println("Жёлтый - #ffff00");
        System.out.println("Оливковый - #808000");
        System.out.println("Лайм - #00ff00");
        System.out.println("Зелёный - #008000");
        System.out.println("Цвет морской волны - #00ffff");
        System.out.println("Окраски птицы чирок - #008080");
        System.out.println("Синий - #0000ff");
        System.out.println("Форма морских офицеров - #000080");
    }

    public  void getListTextStyles(){
        System.out.println("Выберите стиль текста");
        System.out.println("1 = Жирный текст ");
        System.out.println("2 = Курсив");
        System.out.println("3 = Жирный курсив");
        System.out.println("4 = Обыкновенный");
    }

    public void printHelp (){
        System.out.println("Для добавдение текста вам необходимо ввести команду /start");
        System.out.println("Далее нужно будет ввести путь к файлу или url картинки из интнрнета, " +
                "текст, шрифт, размер шрифта, стиль, цвет и расположение текста");
        System.out.println("Если вы решили выбрать картинку которая у вас на пк, тогда нужно ввести ее путь " +
                "Пример пути:" +"C:\\\\Users\\\\admin\\\\картинки\\\\c.png");
        System.out.println("Если файл не будет найден программа вам об этом сообщит");
        System.out.println("Все действия происходят поэтапно");
        System.out.println("В конце программа покажет место куда сохранила файл");
        System.out.println("Приятной работы!");
    }

    public  void getFont (){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();

        System.out.println("Доступные шрифты:");
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
    }

    public  void basicCommands (){
        System.out.println("Введите команду /help для получения информации по взаимодействию");
        System.out.println("Введите команду /close что бы выйти из программы");
        System.out.println("Введите команду /start для старта");
    }
}
