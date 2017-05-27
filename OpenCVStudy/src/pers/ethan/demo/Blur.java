package pers.ethan.demo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

/**
 * desc:
 * Created by huangzhe on 2017/4/21.
 */
public class Blur {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat rgbMat = Highgui.imread(Const.IMAGE_FILE_PATH + "baca.jpg");

        Salt.addSalt(rgbMat);

        //均值滤波
        Mat borderDefaultMat1 = new Mat();
        Imgproc.blur(rgbMat, borderDefaultMat1, new Size(1.0, 1.0));
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_default_blur1.jpg", borderDefaultMat1);
        Mat borderDefaultMat2 = new Mat();
        Imgproc.blur(rgbMat, borderDefaultMat2, new Size(10.0, 10.0));
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_default_blur2.jpg", borderDefaultMat2);
        Mat borderDefaultMat3 = new Mat();
        Imgproc.blur(rgbMat, borderDefaultMat3, new Size(101.0, 101.0));
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_default_blur3.jpg", borderDefaultMat3);

        //高斯滤波
        Mat gaussianBlurMat1 = new Mat();
        Imgproc.GaussianBlur(rgbMat, gaussianBlurMat1, new Size(0, 0), 1.5);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_gaussian_blur1.jpg", gaussianBlurMat1);
        Mat gaussianBlurMat2 = new Mat();
        Imgproc.GaussianBlur(rgbMat, gaussianBlurMat2, new Size(9, 9), 0);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_gaussian_blur2.jpg", gaussianBlurMat2);
        Mat gaussianBlurMat3 = new Mat();
        Imgproc.GaussianBlur(rgbMat, gaussianBlurMat3, new Size(9, 9), 10);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_gaussian_blur3.jpg", gaussianBlurMat3);

        //中值滤波
        Mat mediaBlur1 = new Mat();
        Imgproc.medianBlur(rgbMat, mediaBlur1, 1);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_media_blur1.jpg", mediaBlur1);
        Mat mediaBlur2 = new Mat();
        Imgproc.medianBlur(rgbMat, mediaBlur2, 11);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_media_blur2.jpg", mediaBlur2);
        Mat mediaBlur3 = new Mat();
        Imgproc.medianBlur(rgbMat, mediaBlur3, 101);
        Highgui.imwrite(Const.IMAGE_FILE_PATH + "baca_media_blur3.jpg", mediaBlur3);
    }
}
