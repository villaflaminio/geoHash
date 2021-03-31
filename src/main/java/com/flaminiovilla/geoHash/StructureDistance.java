package com.flaminiovilla.geoHash;

import com.flaminiovilla.geoHash.model.GeoHash;
import com.flaminiovilla.geoHash.model.GeoPoint;
import com.flaminiovilla.geoHash.utils.GeoHashCircle;
import com.flaminiovilla.geoHash.utils.RandomGeoHashes;
import com.flaminiovilla.geoHash.utils.VincentyGeodesy;

import java.util.ArrayList;
import java.util.List;

public class StructureDistance {

    public static String getHash(double latitude , double longitude){
        GeoHash point = GeoHash.withBitPrecision(latitude, longitude, 64);
        return point.toBinaryString();
    }
    public static double getDistance(GeoPoint a, GeoPoint b){
        return VincentyGeodesy.distanceInMeters(a,b);
    }
    public static List<GeoHash> isStructureInRange(double latitude , double longitude , int distance , List<String> structuresString){
        List<GeoHash> structures = new ArrayList<>();
        List<GeoHash> structuresInRange = new ArrayList<>();

       for (String s : structuresString){
           structures.add(GeoHash.fromBinaryString(s));

       }

        GeoPoint center = new GeoPoint(latitude,longitude);
        GeoHashCircle circle = new GeoHashCircle(center, distance);
        System.out.println("circle" + circle);

        for(GeoHash struct : structures){
            if(circle.contains(struct)) {
                structuresInRange.add(struct);
                System.out.println( "distanza di " + getDistance(struct.getOriginatingPoint(),center) / 1000 + "km" + " contiene" + struct );
            }
        }

        return  structuresInRange;
    }

}
