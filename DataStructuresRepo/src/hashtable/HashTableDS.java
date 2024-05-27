package hashtable;

public class HashTableDS {

	private static final int DEFAULT_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	private Entry[] table;
	private int size;
	private float loadFactor;

	public HashTableDS() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public HashTableDS(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}

	public HashTableDS(int capacity, float loadFactor) {
		this.table = new Entry[capacity];
		this.size = 0;
		this.loadFactor = loadFactor;
	}

	public void put(String key, String value) {
		int index = hash(key);
		Entry entry = table[index];

		while (entry != null) {
			if (entry.key.equals(key)) {
				entry.value = value;
				return;
			}
			entry = entry.next;
		}

		table[index] = new Entry(key, value);
		size++;

		if (size >= loadFactor * table.length) {
			resize();
		}
	}

	public String get(String key) {
		int index = hash(key);
		Entry entry = table[index];

		while (entry != null) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
			entry = entry.next;
		}

		return null;
	}

	public void remove(String key) {
		int index = hash(key);
		Entry entry = table[index];
		Entry previous = null;

		while (entry != null) {
			if (entry.key.equals(key)) {
				if (previous == null) {
					table[index] = entry.next;
				} else {
					previous.next = entry.next;
				}
				size--;
				return;
			}

			previous = entry;
			entry = entry.next;
		}
	}

	private int hash(String key) {
		int hash = key.hashCode();
		return hash % table.length;
	}

	private void resize() {
		Entry[] newTable = new Entry[table.length * 2];

		for (Entry entry : table) {
			while (entry != null) {
				int index = hash(entry.key);
				Entry newEntry = new Entry(entry.key, entry.value);
				newEntry.next = newTable[index];
				newTable[index] = newEntry;
				entry = entry.next;
			}
		}

		table = newTable;
	}

	private static class Entry {
		private String key;
		private String value;
		private Entry next;

		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		HashTableDS hasTableDS = new HashTableDS();
		hasTableDS.put("5", "5");
		hasTableDS.put("7", "5");
		hasTableDS.put("1", "5");
		hasTableDS.put("2", "5");
		hasTableDS.put("6", "5");
	}

}
