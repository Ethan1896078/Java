package pers.ethan.demo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import java.util.Random;

/**
 * desc:
 * Created by huangzhe on 2017/4/21.
 */
public class Salt {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Highgui.imread(Const.IMAGE_FILE_PATH + "baca.jpg");
        Mat saltImage = addSalt(image);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_salt.jpg", saltImage);
    }

    /**
     * 加入椒盐噪点
     * @param image
     * @return
     */
    public static Mat addSalt(Mat image){
        int height = image.rows();
        int width  = image.cols();
        int saltNum = 40000;
        Random random = new Random();
        for (int k = 0; k < saltNum; k++) {
            int row = random.nextInt(height);
            int col = random.nextInt(width);
            System.out.println(col + " : " + row);
            image.put(row, col, new double[]{255, 255, 255});
        }
        return image;
    }
}
