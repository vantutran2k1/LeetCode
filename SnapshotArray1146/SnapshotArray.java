package SnapshotArray1146;


import java.util.ArrayList;
import java.util.List;

public class SnapshotArray {
    private class SnapObj {
        private final int snapId;
        private final int value;

        public SnapObj(int snapId, int value) {
            this.snapId = snapId;
            this.value = value;
        }
    }

    private class SnapValue {
        private final List<SnapObj> snapObjs;

        public SnapValue() {
            snapObjs = new ArrayList<>();
            snapObjs.add(new SnapObj(0, 0));
        }

        public void add(SnapObj snapObj) {
            snapObjs.add(snapObj);
        }

        public int size() {
            return snapObjs.size();
        }

        public SnapObj get(int index) {
            return snapObjs.get(index);
        }
    }

    private final SnapValue[] values;
    private int snapId;

    public SnapshotArray(int length) {
        values = new SnapValue[length];
        for (int i = 0; i < length; i++)
            values[i] = new SnapValue();
    }

    public void set(int index, int val) {
        SnapObj obj = new SnapObj(snapId, val);
        values[index].add(obj);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        SnapValue snapValue = values[index];
        int left = 0, right = snapValue.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            SnapObj snapObj = snapValue.get(mid);
            if (snapObj.snapId <= snap_id)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return snapValue.get(right).value;
    }
}
