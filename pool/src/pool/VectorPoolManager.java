/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

import java.util.Vector;

public class VectorPoolManager {

    static Obj[] pool;
    static boolean[] inUse;

    public VectorPoolManager(int initialPoolSize) {
        pool = new Obj[initialPoolSize];
        inUse = new boolean[initialPoolSize];
        for (int i = pool.length - 1; i >= 0; i--) {
            inUse[i] = false;
        }
    }

    public static synchronized Obj getVector() {

        for (int i = 0; i <= inUse.length - 1; i++) {
            if (!inUse[i]) {
                inUse[i] = true;
                
                if(pool[i]==null)
                {
                    System.out.println("Object "+(i+1)+"created");
                    pool[i]= new Obj();
                }
                else
                {
                    System.out.println("return from thread pool");
                }
                
                return pool[i];
            }
        }
        throw new RuntimeException("All the Resources are Allocated");
    }

    public static synchronized void returnVector(Obj v) {
        for (int i = inUse.length - 1; i >= 0; i--) {
            if (pool[i] == v) {
                inUse[i] = false;
                System.out.println("object with out reference "+(i+1));
                v.clear();
                return;
            }
        }
        throw new RuntimeException("Object was not obtained from the pool: " + v);
    }
}
