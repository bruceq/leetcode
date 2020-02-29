package com.it.bruce.leetcode.nBody;

/**
 * NBodyBH.java
 * <p>
 * Reads in a universe of N bodies from stdin, and performs an
 * N-Body simulation in O(N log N) using the Barnes-Hut algorithm.
 * <p>
 * Compilation:  javac NBodyBH.java
 * Execution:    java NBodyBH < inputs/[filename].txt
 * Dependencies: BHTree.java Body.java Quad.java StdDraw.java
 * Input files:  ./inputs/*.txt
 *
 * @author chindesaurus
 * @version 1.00
 */

import java.awt.Color;

public class NBodyBH {

    public static void main(String[] args) {


        final double dt = 0.1;                     // time quantum
        int N = 10000;                 // number of particles
        double radius = 1000;      // radius of universe

        // turn on animation mode and rescale coordinate system
        StdDraw.show(0);
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        // read in and initialize bodies
        Body[] bodies = new Body[N];               // array of N bodies
        for (int i = 0; i < N; i++) {
            double px = radius * 0.5 * (Math.random() - 1);
            double py = radius * 0.5 * (Math.random() - 1);
            Color color = new Color(225, 225, 0);
            bodies[i] = new Body(px, py, 2, 2, 1, color);
        }


        // simulate the universe
        for (double t = 0.0; true; t = t + dt) {

            Quad quad = new Quad(0, 0, radius * 2);
            BHTree tree = new BHTree(quad);

            // build the Barnes-Hut tree
            for (int i = 0; i < N; i++)
                if (bodies[i].in(quad))
                    tree.insert(bodies[i]);

            // update the forces, positions, velocities, and accelerations
            for (int i = 0; i < N; i++) {
                bodies[i].resetForce();
                tree.updateForce(bodies[i]);
                bodies[i].update(dt);
            }

            // draw the bodies
            StdDraw.clear(StdDraw.BLACK);
            for (int i = 0; i < N; i++)
                bodies[i].draw();

            StdDraw.show(10);
        }
    }
}
