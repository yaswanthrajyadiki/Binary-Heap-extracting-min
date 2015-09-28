interface BinaryHeapADT<T> {
	void insert(T element);
	T extract_min();
	T delete_min();
	void heapifyUp(int index);
	void heapifyDown();
}
