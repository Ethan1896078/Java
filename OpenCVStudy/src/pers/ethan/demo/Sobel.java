package pers.ethan.demo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

/**
 * desc:
 * Created by huangzhe on 2017/4/21.
 */
public class Sobel {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Highgui.imread(Const.IMAGE_FILE_PATH + "baca.jpg");
        Mat sobelImage3 = new Mat();
        Imgproc.Sobel(image, sobelImage3, 3, 1, 1);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_sobel_3.jpg", sobelImage3);

        Mat sobelImage5 = new Mat();
        Imgproc.Sobel(image, sobelImage5, 5, 1, 1);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_sobel_5.jpg", sobelImage5);

        Mat sobelImage6 = new Mat();
        Imgproc.Sobel(image, sobelImage6, 6, 0, 1);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_sobel_6.jpg", sobelImage6);

    }
}
