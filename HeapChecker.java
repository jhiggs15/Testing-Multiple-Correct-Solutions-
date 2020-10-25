
/**
 * Tests whether addElt and remMinElt produce valid answers
 */
public class HeapChecker {
    /**
     * Determines if the result of addElt is a valid result. Valid results are defined by
     * The resulting BT if it
     *      satisfies the definition of a heap
     *      retains all elements in the original heap
     *      only adds the element once
     * @param hOrig Original Heap
     * @param elt element being added
     * @param hAdded Result of addElt() on hOrig
     * @return returns true if the returned heap is satisfies all conditions of the resulting BT
     * otherwise returns false
     */
    public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded){
        // If addElt ran correctly the following conditions must be met
        //      - The result is a valid heap
        //      - The number of occurrences of the added element only has
        //        increased by one when compared to the original
        //      - The result only is one element larger than the original
        //      - Both heaps have the same branches ignoring the added element
        return hAdded.isValidHeap() && (hOrig.numOccurences(elt) + 1 == hAdded.numOccurences(elt)) &&
                hOrig.size()+ 1 == hAdded.size() && hAdded.sameAs(hOrig, elt) && hOrig.sameAs(hAdded, elt);//bool1 && bool2;
}

    /**
     * Determines if the result of addElt is a valid result. Valid results are defined by
     * The resulting BT if it
     *      satisfies the definition of a heap
     *      retains all elements in the orginal heap
     *      only removes one occurrence of the smallest element
     * @param hOrig Original Heap
     * @param hRemoved Result of remMinElt() on hOrig
     * @return returns true if the returned heap is satisfies all conditions of the resulting BT
     * otherwise returns false
     */
    public boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved){
        // if the heap is originally empty and the resulting heap is empty then the element was removed correctly
        if (hOrig.size() == 0 && hRemoved.size() == 0){
            return true;
        }
        // since the original heap is not empty the following conditions must be checked
        //      - the resulting heap is valid
        //      - An element was removed (the original size is one less than the resulting size)
        //      - Both heaps have the same branches ignoring the removed element
        return hRemoved.isValidHeap() && hOrig.size() - 1 == hRemoved.size() && hRemoved.sameAs(hOrig) && hOrig.sameAs(hRemoved);
    }



}
