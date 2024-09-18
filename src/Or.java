import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Or {
    public static void main(String[] args) throws IOException {
        //BufferedImage img1 = ImageIO.read(new File("src/img/1.jpg"));
        //BufferedImage img2 = ImageIO.read(new File("src/img/2.jpg"));
        //BufferedImage img2 = ImageIO.read(new File("src/img/3.jpg"));
        //BufferedImage img2 = ImageIO.read(new File("src/img/4.jpg"));
        BufferedImage img1 = ImageIO.read(new File("src/img/5.jpg"));
        //BufferedImage img2 = ImageIO.read(new File("src/img/6.jpg"));
        BufferedImage img2 = ImageIO.read(new File("src/img/7.jpg"));
        //BufferedImage img2 = ImageIO.read(new File("src/img/8.jpg"));
        //BufferedImage img2 = ImageIO.read(new File("src/img/9.jpg"));
        //BufferedImage img2 = ImageIO.read(new File("src/img/10.jpg"));

        BufferedImage newImgAnd = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < img1.getWidth(); x++){
            for (int y = 0; y < img1.getHeight(); y++){

                int pixelImg1 = img1.getRGB(x, y);
                int pixelImg2 = img2.getRGB(x, y);

                int resultAnd = pixelImg1 | pixelImg2;

                newImgAnd.setRGB(x, y, resultAnd);

            }
        }

        ImageIO.write(newImgAnd, "jpg", new File("src/Img-Final/imgOr.jpg"));

    }
}