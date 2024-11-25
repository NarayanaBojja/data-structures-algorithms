package heap;

public class MinHeap {
	int[] array;
	int size;
	int capacity;

	public MinHeap(int c) {
		size = 0;
		capacity = c;
		array = new int[c];
	}

	public int left(int i) {
		return (2 * i + 1);
	}

	public int right(int i) {
		return (2 * i + 2);
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public void insert(int x) {
		if (size == capacity) {
			return;
		}
		size++;
		array[size - 1] = x;
		for (int i = size - 1; i != 0 && array[parent(i)] > array[i];) {
			int temp = array[i];
			array[i] = array[parent(i)];
			array[parent(i)] = temp;
			i = parent(i);
		}
	}

	public static void main(String[] args) {

		MinHeap h = new MinHeap(11);
		h.insert(3);
		h.insert(2);
		h.insert(15);
		h.insert(20);
	}

}
