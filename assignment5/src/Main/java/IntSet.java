package Main.java;

public final class IntSet {
    private final boolean[] elements;
    private final int size;

    public IntSet() {
        this.elements = new boolean[1001];
        this.size = 0;
    }

    public IntSet(int[] values) {
        this.elements = new boolean[1001];
        int count = 0;
        for (int value : values) {
            if (value >= 1 && value <= 1000 && elements[value] == false) {
                elements[value] = true;
                count++; // adding to the size of set
            }
        }
        this.size = count;
    }

    /**
     * 
     * @return int[] - returns the setelements
     */
    public int[] getSetElements() {
        int[] ans = new int[elements.length];
        for (int i = 1; i <= 1000; i++) {
            if (elements[i] == true)
                ans[i] = i;
        }
        return ans;
    }

    /**
     * To find if a value 'X' is present or not in set
     * 
     * @param x - the vlaue to be find which is present or not in array
     * @return boolean- return true if present otherwise false
     */
    public boolean isMemberOfSet(int x) {

        if (x < 1 || x > 1000)
            return false;

        return elements[x];
    }

    public int size() {
        return size; // returns the size of the set
    }

    /**
     * to check if 's' is a subset of the given set
     * 
     * @param s - the input set 's'
     * @return boolean- if s is subset of universal set
     */
    public boolean isSubSet(IntSet s) {
        for (int i = 1; i <= 1000; i++) {
            if (s.elements[i] == true && this.elements[i] == false) // if s contains the element but the universal set
                                                                    // // doesnt
                return false;
        }
        return true; //
    }

    /**
     * To find complement of set1 and set2
     * 
     * @param set1 - input set1
     * @param set2 - input set2
     * @return Intset- having complement of set1 and set2
     */

    public IntSet getComplement(IntSet set1, IntSet set2) {
        // complemnet - members that present in set 2 only, not in set 1
        IntSet result = new IntSet();
        for (int i = 1; i <= 1000; i++) {
            if (set1.elements[i] == false && set2.elements[i] == true && result.elements[i] == false) {
                result.elements[i] = true;
            }
        }

        return result;
    }

    /**
     * To find intersection of set1 and set2
     * 
     * @param set1 - input set1
     * @param set2 - input set2
     * @return Intset- having intersection of set1 and set2
     */

    public IntSet getIntersection(IntSet set1, IntSet set2) {
        // intersection- elements presenst in both set
        IntSet result = new IntSet();
        for (int i = 1; i <= 1000; i++) {
            if (set1.elements[i] == true && set2.elements[i] == true && result.elements[i] == false) {
                result.elements[i] = true;
            }
        }
        return result;
    }

    /**
     * To find difference of set1 and set2
     * 
     * @param set1 - input set1
     * @param set2 - input set2
     * @return Intset- having difference of set1 and set2
     */

    public IntSet getDifference(IntSet set1, IntSet set2) {
        // difference- elements presentin set1 not in set2
        IntSet result = new IntSet();
        for (int i = 1; i <= 1000; i++) {
            if (set1.elements[i] == true && set2.elements[i] == false && result.elements[i] == false) {
                result.elements[i] = true;
            }
        }
        return result;
    }

    /**
     * To find union of set1 and set2
     * 
     * @param set1 - input set1
     * @param set2 - input set2
     * @return Intset- having union of set1 and set2
     */

    public IntSet getUnion(IntSet set1, IntSet set2) {
        // union-
        IntSet result = new IntSet();
        for (int i = 1; i <= 1000; i++) {
            if (set1.elements[i] == true || set2.elements[i] == true && result.elements[i] == false) {
                result.elements[i] = true;
            }
        }
        return result;
    }

}
