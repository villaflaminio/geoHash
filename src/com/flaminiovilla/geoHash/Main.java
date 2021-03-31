package com.flaminiovilla.geoHash;

import com.flaminiovilla.geoHash.model.GeoPoint;
import com.flaminiovilla.geoHash.utils.GeoHashCircle;

public class Main {
    public static void main(String[] args) {

        GeoPoint center = new GeoPoint(39.86391280373075, 116.37356590048701);
        GeoHashCircle circle = new GeoHashCircle(center, 589);

        // the distance between center and test1 is about 430 meters
        GeoPoint test1 = new GeoPoint(39.8648866576058, 116.378465869303);
        // the distance between center and test2 is about 510 meters
        GeoPoint test2 = new GeoPoint(39.8664787092599, 116.378552856158);
        // the distance between center and test2 is about 600 meters
        GeoPoint test3 = new GeoPoint(39.8786787092599, 116.378552856158);

        System.out.println("circle" + circle.contains(test1)+ " contains ");
        System.out.println("circle" + circle.contains(test2)+ " contains ");
        System.out.println("circle" + circle.contains(test3)+ " contains ");


    }

}
