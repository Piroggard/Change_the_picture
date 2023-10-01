import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class AddText {

    public void changePictureURl(String path, String text, String fontName, int fontStyle, int fontSize, Color color,
                                 int textPosition) {
        File file;
        URL uri;
        BufferedImage image;
        String pathToImage = path.substring(0, 4);

        try {
            if (pathToImage.equals("http")) {
                uri = new URL(path);
                image = ImageIO.read(uri);
            } else {
                file = new File(path);
                image = ImageIO.read(file);
            }
            Graphics graphics = image.getGraphics();
            Font font = new Font(fontName, fontStyle, fontSize);
            graphics.setColor(color);
            graphics.setFont(font);
            FontMetrics metrics = graphics.getFontMetrics(font);
            int x = (getCoordinatesByTextLocation(image, metrics, text, textPosition)).get(0);
            int y = (getCoordinatesByTextLocation(image, metrics, text, textPosition)).get(1);
            graphics.drawString(text, x, y);
            graphics.dispose();
            File modifiedFile = new File("picture_with_text" + getLocalDateTime() + ".png");
            ImageIO.write(image, "PNG", modifiedFile);
            System.out.println("Картинка сохранена в " + modifiedFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла или URL-ресурса: " + e.getMessage());
            return;
        }
    }


    public String getLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");
        return now.format(formatter);
    }

    public ArrayList<Integer> getCoordinatesByTextLocation(BufferedImage image, FontMetrics metrics, String text, int textPosition) {

        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getHeight();
        ArrayList<Integer> coordinates = new ArrayList<>();

        switch (textPosition) {
            case 1: //Левый верхний угол
                coordinates.add(0); // X-координата
                coordinates.add(textHeight); // Y-координата
                break;
            case 2: //По центру верх
                coordinates.add((imageWidth - textWidth) / 2); // X-координата
                coordinates.add(textHeight); // Y-координата
                break;
            case 3: // Правый верхний угол
                coordinates.add(imageWidth - textWidth); // X-координата
                coordinates.add(textHeight); // Y-координата
                break;
            case 4: // Левый центр
                coordinates.add(0);// X-координата
                coordinates.add((imageHeight + textHeight) / 2);// Y-координата
                break;
            case 5: // Центр
                coordinates.add((imageWidth - textWidth) / 2);// X-координата
                coordinates.add((imageHeight + textHeight) / 2);// Y-координата
                break;
            case 6: // Правый центр
                coordinates.add(imageWidth - textWidth);// X-координата
                coordinates.add((imageHeight + textHeight) / 2);// Y-координата
                break;
            case 7: // Правый низ
                coordinates.add(imageWidth - textWidth); // X-координата
                coordinates.add(imageHeight); // Y-координата
                break;
            case 8: // Левый низ
                coordinates.add(0); // X-координата
                coordinates.add(imageHeight); // Y-координата
                break;
            case 9: // Правый низ
                coordinates.add(imageWidth / 2); // X-координата
                coordinates.add(imageHeight); // Y-координата
                break;
            default:
                System.out.println("Неправильное значение");
        }
        return coordinates;
    }
}
