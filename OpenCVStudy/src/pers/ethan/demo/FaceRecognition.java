package pers.ethan.demo;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

/**
 * desc:
 * Created by huangzhe on 2017/6/1.
 */
public class FaceRecognition {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new FaceRecognition().run("Champion");
        new FaceRecognition().run("Appearance");
        new FaceRecognition().run("MSN");
    }

    public void run(String fileName){
        CascadeClassifier faceDetector =
                new CascadeClassifier(Const.RESOURCE_FILE_PATH + "lbpcascade_frontalface.xml");
        Mat image = Highgui.imread(Const.IMAGE_FILE_PATH + fileName + ".jpg");
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("file name : %s, detected %s faces", fileName + ".jpg", faceDetections.toArray().length));
        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }

        Highgui.imwrite(Const.IMAGE_FILE_PATH + fileName + "_face.jpg", image);
    }
}
