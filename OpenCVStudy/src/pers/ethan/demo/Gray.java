package pers.ethan.demo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;


/**
 * desc:
 * Created by huangzhe on 2017/4/21.
 */
public class Gray {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat rgbMat = Highgui.imread(Const.IMAGE_FILE_PATH + "baca.jpg");
        Mat grayMat = new Mat();
        Imgproc.cvtColor(rgbMat, grayMat, Imgproc.COLOR_RGB2GRAY); //灰度化
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_gray.jpg", grayMat);

        Mat cannyMat = new Mat();
        Imgproc.Canny(rgbMat, cannyMat, 50, 200); //Canny边缘检测
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_canny.jpg", cannyMat);

        Mat grayCannyMat = new Mat();
        Imgproc.Canny(grayMat, grayCannyMat, 50, 200); //灰度化 + Canny边缘检测
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_gray_canny.jpg", grayCannyMat);

        Mat lineMat = new Mat();
        Imgproc.HoughLinesP(grayMat, lineMat, 5, 6, 9);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_line.jpg", lineMat);

    }
}
