import com.supermap.data.CoordSysTranslator;
import com.supermap.data.Point2D;
import com.supermap.data.Point2Ds;
import com.supermap.data.PrjCoordSys;

import java.io.Console;

public class ProjectToGeo {
    public double[] projectToGeo(double a, double b, boolean flag, int m) {
        double[] result = new double[2];
        Point2D[] pts = {new Point2D(a, b)};
        Point2Ds te2DS = new Point2Ds(pts);
        //把点击坐标转换成为同一个地理坐标系下的地理坐标
        //CoordSysTranslator.inverse(te2DS, PrjCoordSys.fromEPSG(2383));
        if (flag) {
            CoordSysTranslator.inverse(te2DS, PrjCoordSys.fromEPSG(m));
        } else {
            CoordSysTranslator.forward(te2DS, PrjCoordSys.fromEPSG(m));
        }
        for (int i = 0; i < te2DS.getCount(); i++) {
            result[0] = te2DS.getItem(i).x;
            result[1] = te2DS.getItem(i).y;
        }
        return result;
    }

    public static void main(String[] args) {
        // ProjectToGeo projectToGeo = new ProjectToGeo();
        // double[] point2Ds = projectToGeo.projectToGeo(509294.479, 2522963.686, true, 2383);
        // double[] point2Ds1 = projectToGeo.projectToGeo(114.0905284269002, 22.805152635365822, false, 2383);
        //
        // System.out.println(point2Ds[0]);
        // System.out.println(point2Ds[1]);
        // System.out.println(point2Ds);
        // System.out.println(point2Ds1[0]);
        // System.out.println(point2Ds1[1]);
    }

}
