/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

import static pool.VectorPoolManager.getVector;

/**
 *
 * @author naimish
 */
public class ThreadedAccess
        implements Runnable {

    static int ThreadCount = 0;

    public void run() {
        //simple test just accesses the thread local vector, adds the
        //thread specific string to it, and sleeps for two seconds before
        //again accessing the thread local and printing out the value.
        String s = "This is thread " + ThreadCount++;
        System.out.println(s);
        Obj v = VectorPoolManager.getVector();
        v.setId(1);
        System.out.println(v.getId());
        v = VectorPoolManager.getVector();
        v.setId(2);
        System.out.println(v.getId());
        try {
            Thread.sleep(2000);
            VectorPoolManager.returnVector(v);
        } catch (Exception e) {
        }

        v = getVector();
        v.setName("hello");
        System.out.println(v.getName());
        VectorPoolManager.returnVector(v);
    }

    public static void main(String[] args) {
        try {
            //Four threads to see the multithreaded nature at work
            Thread t1 = new Thread();
            VectorPoolManager v = new VectorPoolManager(10);
            for (int i = 0; i < 5; i++) {
                ThreadedAccess t = new ThreadedAccess();
                t1 = new Thread(t);
                t1.start();
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
