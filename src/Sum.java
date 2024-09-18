import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Sum {
    public static void main(String[] args) throws IOException {

        BufferedImage img1 = ImageIO.read(new File("src/img/4.jpg"));
        BufferedImage img2 = ImageIO.read(new File("src/img/8.jpg"));

        ArrayList<Integer> matrizCores = new ArrayList<>();

        BufferedImage newImgSum = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < img1.getWidth(); x++){
            for(int y = 0; y < img1.getHeight(); y++){

                int pixel = img1.getRGB(x, y);
                int pixel2 = img2.getRGB(x, y);

                Color cor = new Color(pixel);
                Color cor2 = new Color(pixel2);

                int r = cor.getRed() + cor2.getRed();

                matrizCores.add(r);
            }
        }

        int fmax = 0;
        int fmin = 255;

        for (int c = 0; c < matrizCores.size(); c++){
            if (matrizCores.get(c) > fmax){
                fmax = matrizCores.get(c);
            }
            if (matrizCores.get(c) < fmin){
                fmin = matrizCores.get(c);
            }
        }

        System.out.println("aqui " + fmax);
        System.out.println("aqui " + fmin);

        int aux = 0;

        for(int x = 0; x < img1.getWidth(); x++){
            for(int y = 0; y < img1.getHeight(); y++){

                int f = matrizCores.get(aux);

                double rs = 255.0 / (fmax - fmin);
                int g = (int) (rs * (f - fmin));

                aux++;

                newImgSum.setRGB(x, y, new Color(g, g, g).getRGB());
            }
        }

        ImageIO.write(newImgSum, "jpg", new File("src/imgSUM.jpg"));
    }
}