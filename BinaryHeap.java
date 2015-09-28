import java.util.ArrayList;
@SuppressWarnings("unchecked")
class BinaryHeap<T extends Comparable<T>> implements BinaryHeapADT<T> {

	int size;
	T[] heapArray;
	int heapSize;
	BinaryHeap (int size) {
		this.size = size;
		heapArray = (T[]) new Comparable[size];
		heapSize = 0;
	}

	public T getParent(int index) {
		return heapArray[(index - 1)/2];
	}

	public void insert(T element) {
		heapArray[heapSize] = element;
		heapifyUp(heapSize);
		heapSize++;
	}
	
	public T extract_min() {
		return heapArray[0];
	}
	
	public T delete_min() {
		T deleteElement = heapArray[0];
		heapArray[0] = heapArray[--heapSize];
		heapifyDown();
		return deleteElement;
	}
	public T getRightChild(int index) {
		if (heapSize >= ((2 * index) + 1)) {
			return heapArray[((2 * index)+ 1)];			
		}
		return null;
	}

	public T getLeftChild(int index) {
		if (heapSize >= ((2 * index)+ 2)) {
			return heapArray[((2 * index) + 2)];			
		}
		return null;
	}
	
	public void heapifyUp(int index) {
		T element = heapArray[index];
		T temp;
		int ind = index;
		while (ind > 0) {
			if (heapArray[ind].compareTo(getParent(ind)) < 0) {
				temp = heapArray[(ind-1)/2];
				heapArray[(ind-1)/2] = heapArray[ind];
				heapArray[ind] = temp;
			}
			ind--;
		}
	}

	public void heapifyDown() {
		T temp;
		int ind = 0;
		if (ind >= 0 && getLeftChild(ind) != null && getRightChild(ind)!= null) {
			if (getRightChild(ind).compareTo(getLeftChild(ind)) > 0) {
				while (ind < heapSize) {
					if (getLeftChild(ind) != null && heapArray[ind].compareTo(getLeftChild(ind)) > 0) {
						swapChildParent(((2 * ind)+ 2), ind);
					}
					if (getRightChild(ind) != null && heapArray[ind].compareTo(getRightChild(ind)) > 0) {
						swapChildParent(((2 * ind)+ 1), ind);
					}					
					ind++;
				}
			} else {
				while (ind < heapSize) {
					if (getRightChild(ind) != null && heapArray[ind].compareTo(getRightChild(ind)) > 0) {
						swapChildParent(((2 * ind)+ 1), ind);
					}
					if (getLeftChild(ind) != null && heapArray[ind].compareTo(getLeftChild(ind)) > 0) {
						swapChildParent(((2 * ind)+ 2), ind);
					}
				    ind++;
			    }
			}
		}
	}

	public void swapChildParent(int index1, int index2) {
		T temp = heapArray[index1];
		heapArray[index1] = heapArray[index2];
		heapArray[index2] = temp;
	}


	public void print() {
		if (heapSize == 0) {
			System.out.println("Heap is empty");
		} else {
			for (int i = 0; i < heapSize; i++) {
				System.out.println(heapArray[i]);
			}
		}	 
	}

	public int getHeapSize() {
		return heapSize;
	}

	public static void main(String[] args) {
		BinaryHeap<Integer> bh =  new BinaryHeap<Integer>(10);
		bh.insert(1);
		bh.insert(2);
		bh.insert(3);
		bh.insert(4);
		bh.insert(5);
		bh.insert(6);
		bh.print();
		int size = bh.getHeapSize();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			nums.add(bh.delete_min());
		}
		System.out.println(nums);
	}
}