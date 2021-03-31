package com.flaminiovilla.geoHash;

import com.flaminiovilla.geoHash.model.GeoHash;
import com.flaminiovilla.geoHash.model.GeoPoint;
import com.flaminiovilla.geoHash.utils.GeoHashCircle;
import com.flaminiovilla.geoHash.utils.RandomGeoHashes;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
       // org.openjdk.jmh.Main.main(args);

        List<GeoHash> db = new ArrayList<>();
       // GeoPoint center = new GeoPoint(39.86391280373075, 116.37356590048701);
        GeoPoint center =  RandomGeoHashes.randomGeoPoint();

        GeoHashCircle circle = new GeoHashCircle(center, 10000);

        for(int i=0 ;  i<500 ; i++){
            db.add(RandomGeoHashes.create());
        }

        for (GeoHash point : db){
            if (circle.contains(point))
                System.out.println("circle " + circle.contains(point)+ " contains ");

        }

    /*
        GeoHash testHash1 = GeoHash.withBitPrecision(39.8648866576058, 116.378465869303, 32);
        // the distance between center and test1 is about 430 meters
        GeoPoint test1 = new GeoPoint(39.8648866576058, 116.378465869303);
        // the distance between center and test2 is about 510 meters
        GeoPoint test2 = new GeoPoint(39.8664787092599, 116.378552856158);
        // the distance between center and test2 is about 600 meters
        GeoPoint test3 = new GeoPoint(39.8786787092599, 116.378552856158);

        System.out.println("circle " + circle.contains(test1)+ " contains ");
        System.out.println("circle " + circle.contains(test2)+ " contains ");
        System.out.println("circle " + circle.contains(test3)+ " contains ");
        System.out.println(testHash1);

        System.out.println("circle " + circle.contains(testHash1)+ " contains ");
    */

    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void init() {
        // Do nothing
    }
}
