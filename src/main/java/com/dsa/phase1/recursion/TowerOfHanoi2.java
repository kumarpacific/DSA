package com.dsa.phase1.recursion;

public class TowerOfHanoi2 {

    public static void main(String[] args) {
        int n = 3;
        char a = 'A', b = 'B', c = 'C';

        toh(a, b, c, n);
    }

    /**
     * This recursive method will move 1 disk, from source A to destination B using the tower C.
     *
     * @param s - represents tower A
     * @param d - represents tower B
     * @param h - represents tower C
     * @param n - represents number of disks
     */

    private static void toh(char s, char d, char h, int n) {
        if (n == 0) {
            return;
        }

        toh(s, h, d, n - 1); // this will take care the movement of disk 1 and 2, to go from S to H. with help of D.
        System.out.println("Move disk: " + n + " from " + s + " to " + d);  // this will take care of moving disk 3, from S to D
        toh(h, d, s, n - 1); // this will take care the movement of disk 1 and 2. to go from H to D, with help of S.

        // In recursion, based on how much you practice. You develop s skill of faith with recursive call,
        // we can make our understanding better
        // by making Eular Tour of Tree - this let us know about the actual flow of Recursive calls.
        // by switching parameters in recursive method call, we are moving the disks from 1st to 2nd using the 3rd parameter.
    }
}
