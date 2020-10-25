import java.lang.Math;

interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();

 boolean isBigger(int e);

 /**
  * Determines if the given BT's root is smaller than the int e
  * @param e the root of a BT / Heap
  * @return returns true if the BT's root is smaller than the int e
  */
 boolean isSmaller(int e);

 /**
  * Determines if every part of the Heap meets the requirements of being classified as a valid heap,
  * smallest element on top, left and right subtrees both heaps.
  * @return returns true if the Heap / BT meets requirements of being a valid heap,
  * false otherwise
  */
 boolean isValidHeap();

 /**
  * Finds the number of times the given int elt occurs in the BT / Heap, excluding occurences
  * of the item being added
  * @param elt the root of a BT / Heap
  * @return returns the number of occurences of the given elt
  */
 int numOccurences(int elt);

 /**
  * Determines if the given BT has the same elements as the Heap excluding occurrences
  * of the item being added or removed
  * @param aHeap a Heap
  * @param elt the value of the element being added or removed
  * @return True if the the given Heap contains the same elements as the BT,
  * false otherwise.
  */
 boolean sameAs(IHeap aHeap, int elt);

 /**
  * Gets the element that is being removed then determines if the given BT
  * has the same elements as the Heap excluding occurrences of the item being removed
  * @param aHeap a Heap
  * @return True if the the given BT contains the same elements as the Heap,
  * false otherwise.
  */
 boolean sameAs(IHeap aHeap);
}

class MtBT implements IBinTree {
 MtBT(){}

 /**
  * Detemines if both the given BT and the Heap contain a empty BT / empty Heap respectively
  * @param aHeap a Heap
  * @return True always since they both must contain a empty BT / empty Heap respectively
  */
 public boolean sameAs(IHeap aHeap){
  return true;
 }

 /**
  * Determines if both the given Heap and BT contain a empty Heap and empty BT respectively
  * @param aHeap a Heap
  * @param elt the element being added or removed
  * @return True always since they both must contain a empty Heap / empty BT respectively
  */
 public boolean sameAs(IHeap aHeap, int elt){
  return true;
 }

 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }

 // Determines if the given BT's root is bigger than the int e
 public boolean isBigger(int e) {
  return false;
 }

 /**
  * Determines if the given BT's root is smaller than the int e
  * @param e the root of a BT / Heap
  * @return returns false since empty tree has no elements
  */
 public boolean isSmaller(int e){
  return false;
 }

 /**
  * Determines if every part of the Heap meets the requirements of being classified as a valid heap
  * (smallest element on top, left and right subtrees both heaps).
  * @return returns true since an empty heap is a valid heap
  */
 public boolean isValidHeap(){
  return true;
 }

 /**
  * Finds the number of times the given int elt occurs in the Heap / BT
  * @param elt the root of a BT / Heap
  * @return returns 0 since there are no elements in an empty Heap / BT
  */
 public int numOccurences(int elt){
  return 0;
 }

 // returns 0 since enpty tree has no elements
 public int size() {
  return 0;
 }

 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }
}

class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;

 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }

 /**
  * Finds the number of times the given int elt occurs in the BT / Heap
  * @param elt the root of a BT / Heap
  * @return returns the number of occurences of the given elt
  */
 public int numOccurences(int elt){
  if (this.data == elt){
   return 1 + this.left.numOccurences(elt) + this.right.numOccurences(elt);
  }
  return this.left.numOccurences(elt) + this.right.numOccurences(elt);
 }

 /**
  * Determines if the given BT has the same elements as the Heap excluding occurences
  * of the item being added or removed
  * @param aHeap a Heap
  * @param elt the value of the element being added or removed
  * @return True if the the given Heap contains the same elements as the BT,
  * false otherwise.
  */
 public boolean sameAs(IHeap aHeap, int elt){
  if (this.data == elt){
   return left.sameAs(aHeap, elt) && right.sameAs(aHeap, elt);
  }
  return aHeap.hasElt(this.data) && left.sameAs(aHeap, elt) && right.sameAs(aHeap, elt);
 }

 /**
  * Gets the element that is being removed then determines if the given BT
  * has the same elements as the Heap excluding occurences of the item being removed
  * @param aHeap a Heap
  * @return True if the the given BT contains the same elements as the Heap,
  * false otherwise.
  */
 public boolean sameAs(IHeap aHeap){
  int elt = this.data;
  return this.sameAs(aHeap, elt);
 }

 /**
  * Determines if every part of the Heap meets the requirements of being classified as a valid heap,
  * smallest element on top, left and right subtrees both heaps.
  * @return returns true if the Heap / BT meets requirements of being a valid heap,
  * false otherwise
  */
 public boolean isValidHeap(){
  if(left.isSmaller(data) || right.isSmaller(data))
  {
   return false;
  }
  else
  {
     return right.isValidHeap() && left.isValidHeap();
  }
 }

 /**
  * Determines if the given BT's root is smaller than the int e
  * @param e the root of a BT / Heap
  * @return returns true if the BT's root is smaller than the int e
  */
 public boolean isSmaller(int e) {
  return (this.data < e);
 }

 // Determines if the given BT's root is bigger than the int e
 public boolean isBigger(int e) {
  return (this.data >= e);
 }
 
 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
   this.data = data;
   this.left = new MtBT();
   this.right = new MtBT();
 }


 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
 }

 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }

 // adds 1 to the height of the taller subtree
 public int height() {
  return 1 + Math.max(this.left.height(), this.right.height());
 }
}