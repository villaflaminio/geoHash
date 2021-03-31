/*
 * Copyright 2010, Silvio Heuberger @ IFS www.ifs.hsr.ch
 *
 * This code is release under the Apache License 2.0.
 * You should have received a copy of the license
 * in the LICENSE file. If you have not, see
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package com.flaminiovilla.geoHash.utils;



import com.flaminiovilla.geoHash.model.BoundingBox;
import com.flaminiovilla.geoHash.model.GeoHash;
import com.flaminiovilla.geoHash.model.GeoPoint;

import java.io.Serializable;
import java.util.List;

/**
 * represents a radius search around a specific point via geohashes.
 * Approximates the circle with a square!
 */
public class GeoHashCircle implements Serializable {
	private static final long serialVersionUID = 1263295371663796291L;
	private double radius;
	private GeoHashBoundingBox query;

	private GeoPoint center;

	/**
	 * create a {@link GeoHashCircle} with the given center point and a radius in meters.
	 */
	public GeoHashCircle(GeoPoint center, double radius) {
		this.radius = radius;
		this.center = center;
		GeoPoint northEastCorner = VincentyGeodesy.moveInDirection(VincentyGeodesy.moveInDirection(center, 0, radius), 90, radius);
		GeoPoint southWestCorner = VincentyGeodesy.moveInDirection(VincentyGeodesy.moveInDirection(center, 180, radius), 270, radius);
		BoundingBox bbox = new BoundingBox(southWestCorner, northEastCorner);
		query = new GeoHashBoundingBox(bbox);
	}

	public boolean contains(GeoHash hash) {
		return query.contains(hash);
	}

	public String toString() {
		return "Cicle Query [center=" + center + ", radius=" + getRadiusString() + "]";
	}

	private String getRadiusString() {
		if (radius > 1000) {
			return radius / 1000 + "km";
		} else {
			return radius + "m";
		}
	}

}
