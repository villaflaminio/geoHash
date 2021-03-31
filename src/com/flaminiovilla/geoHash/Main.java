package com.flaminiovilla.geoHash;

import com.flaminiovilla.geoHash.model.GeoPoint;

public class Main {
    public static void main(String[] args) {

            GeoPoint center = new GeoPoint(39.86391280373075, 116.37356590048701);
            GeoHashCircleQuery query = new GeoHashCircleQuery(center, 589);

            // the distance between center and test1 is about 430 meters
            WGS84Point test1 = new WGS84Point(39.8648866576058, 116.378465869303);
            // the distance between center and test2 is about 510 meters
            WGS84Point test2 = new WGS84Point(39.8664787092599, 116.378552856158);
            // the distance between center and test2 is about 600 meters
            WGS84Point test3 = new WGS84Point(39.8786787092599, 116.378552856158);

            assertTrue(query.contains(test1));
            assertTrue(query.contains(test2));
            assertFalse(query.contains(test3));

        }
    }
}
