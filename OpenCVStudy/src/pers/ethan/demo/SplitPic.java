package pers.ethan.demo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.highgui.Highgui;

/**
 * desc:
 * Created by huangzhe on 2017/4/21.
 */
public class SplitPic {
    public static void main(String[] args ){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Highgui.imread("/Users/huangzhe/Pictures/baca.jpg");
        //System.out.println( "mat = " + image.dump() );

        int m = 2;
        int n = 2;

        int height = image.rows();
        int width  = image.cols();
        System.out.println("height:"+height+" width:"+width);
        int ceil_height = height/m;
        int ceil_width  = width/n;
        System.out.println("ceil_height:"+ceil_height+" ceil_width:"+ceil_width);

        String filename = "/Users/huangzhe/Pictures/baca_split";

        for(int i = 0; i<m; i++ ) {
            for(int j = 0; j<n; j++){
                int a = j*ceil_width;
                int b = i*ceil_height;
                System.out.println(a+","+b+","+ceil_width+","+ceil_height);
                Rect rect = new Rect(j*ceil_width,i*ceil_height,ceil_width,ceil_height);
                Mat roi_img = new Mat(image,rect);
                Mat tmp_img = new Mat();

                roi_img.copyTo(tmp_img);

                Highgui.imwrite(filename+i+"_"+j+".jpg", tmp_img);
            }
        }
    }
}
