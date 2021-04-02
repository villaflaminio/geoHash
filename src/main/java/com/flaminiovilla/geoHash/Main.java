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
        Long startTime = System.currentTimeMillis();

        org.openjdk.jmh.Main.main(args);
        List<GeoPoint> db = new ArrayList<>();

        for (int i = 0; i < 50000; i++) {
            db.add(RandomGeoHashes.randomGeoPoint());
        }

        List<GeoPoint> structuresInRange = StructureDistance.isStructureInRange(39.8648866576058, 116.378465869303, 50,db);
        Long endtime = System.currentTimeMillis();
        System.out.println("Tempo impiegato :" + (endtime - startTime));

    }

}
