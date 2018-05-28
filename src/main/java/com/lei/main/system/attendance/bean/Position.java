package com.lei.main.system.attendance.bean;

import java.util.HashMap;
import java.util.Map;

public class Position {
    private final static double PI = Math.PI;
    private final static double R = 6371.01; // 地球的半径，千米

    private final static double MIN_LAT = Math.toRadians(-90d);  // -PI/2
    private final static double MAX_LAT = Math.toRadians(90d);   //  PI/2
    private final static double MIN_LON = Math.toRadians(-180d); // -PI
    private final static double MAX_LON = Math.toRadians(180d);

    private Double lng;//经度
    private Double lat;//纬度

    public Position(Double lng, Double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    private static double rad(Double d) {
        return d * Math.PI / 180.00; //角度转换成弧度
    }

    public Double getDistance(double longitude, double latitude) {
        double Lat1 = rad(lat); // 纬度
        double Lat2 = rad(latitude);
        double a = Lat1 - Lat2;//两点纬度之差
        double b = rad(lng) - rad(longitude); //经度之差
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(Lat1) * Math.cos(Lat2) * Math.pow(Math.sin(b / 2), 2)));//计算两点距离的公式
        s = s * R * 1000;//弧长乘地球半径（半径为米）
        s = Math.round(s * 10000d) / 10000d;//精确距离的数值
        return s;
    }

    /*public double getDistance(double longt1, double lat1, double longt2, double lat2){
        double x,y,distance;
        x=(longt2-longt1) * PI * R * Math.cos( ((lat1 + lat2) / 2) * PI / 180) / 180;
        y=(lat2-lat1) * PI * R / 180;
        distance=Math.hypot(x,y);
        return distance;
    }*/

    public Map<String, Double> getAround(double radius) {
        Map map = new HashMap<String, Double>();

        double radLat = lat * PI / 180;  // latitude in radians
        double radLon = lng * PI / 180;

        double distance = radius / 1000;
        if (distance < 0d)
            throw new IllegalArgumentException();

        // angular distance in radians on a great circle
        double radDist = distance / R;

        double minLat = radLat - radDist;
        double maxLat = radLat + radDist;

        double minLon, maxLon;
        if (minLat > MIN_LAT && maxLat < MAX_LAT) {
            double deltaLon = Math.asin(Math.sin(radDist) / Math.cos(radLat));
            minLon = radLon - deltaLon;
            if (minLon < MIN_LON) minLon += 2d * Math.PI;
            maxLon = radLon + deltaLon;
            if (maxLon > MAX_LON) maxLon -= 2d * Math.PI;
        } else {
            // a pole is within the distance
            minLat = Math.max(minLat, MIN_LAT);
            maxLat = Math.min(maxLat, MAX_LAT);
            minLon = MIN_LON;
            maxLon = MAX_LON;
        }
        //转换成角度
        minLat = minLat*180/PI;
        maxLat = maxLat*180/PI;
        maxLon = maxLon*180/PI;
        minLon = minLon*180/PI;

        map.put("minLat", minLat);
        map.put("maxLat", maxLat);
        map.put("minLng", minLon);
        map.put("maxLng", maxLon);

        return map;
    }
    /*public static Map getAround(String lngStr, String latStr, String raidus) {
        Map map = new HashMap();

        Double latitude = Double.parseDouble(latStr);// 传值给纬度
        Double longitude = Double.parseDouble(lngStr);// 传值给经度

        Double degree = (24901 * 1609) / 360.0; // 获取每度
        double radiusMile = Double.parseDouble(raidus);

        Double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180))+"").replace("-", ""));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * radiusMile;
        //获取最小经度
        Double minLng = longitude - radiusLng;
        // 获取最大经度
        Double maxLng = longitude + radiusLng;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * radiusMile;
        // 获取最小纬度
        Double minLat = latitude - radiusLat;
        // 获取最大纬度
        Double maxLat = latitude + radiusLat;

        map.put("minLat", minLat+"");
        map.put("maxLat", maxLat+"");
        map.put("minLng", minLng+"");
        map.put("maxLng", maxLng+"");

        return map;
    }*/
}
