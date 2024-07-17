package SnapshotArray1146;

public class Main {
    public static void main(String[] args) {
        SnapshotArray snapshotArr1 = new SnapshotArray(3);
        snapshotArr1.set(0, 5);
        snapshotArr1.snap();
        snapshotArr1.set(0, 6);
        System.out.println(snapshotArr1.get(0, 0) == 5);

        SnapshotArray snapshotArr2 = new SnapshotArray(1);
        snapshotArr2.set(0, 15);
        snapshotArr2.snap();
        snapshotArr2.snap();
        snapshotArr2.snap();
        System.out.println(snapshotArr2.get(0, 2) == 15);
        snapshotArr2.snap();
        snapshotArr2.snap();
        System.out.println(snapshotArr2.get(0, 0) == 15);

        SnapshotArray snapshotArr3 = new SnapshotArray(4);
        snapshotArr3.snap();
        snapshotArr3.snap();
        System.out.println(snapshotArr3.get(3, 1) == 0);
        snapshotArr3.set(2, 4);
        snapshotArr3.snap();
        snapshotArr3.set(1, 4);

        SnapshotArray snapshotArr4 = new SnapshotArray(4);
        snapshotArr4.snap();
        snapshotArr4.snap();
        snapshotArr4.snap();
        snapshotArr4.snap();
        System.out.println(snapshotArr4.get(1, 2) == 0);
        snapshotArr4.set(0, 10);
        snapshotArr4.set(3, 18);
    }
}
