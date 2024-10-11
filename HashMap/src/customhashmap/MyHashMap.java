package customhashmap;

public class MyHashMap<K, V> {

  int size, threshold;
  static final int DEFAULT_INITIAL_CAPACITY = 1 << 16, MAXIMUM_CAPACITY = 1 << 30;
  static final float DEFAULT_LOAD_FACTOR = 0.75f;
  float loadFactor;
  Entry<K, V> table[];

  class Entry<K, V> {
    final int hash;
    final K key;
    V value;
    Entry<K, V> next;

    Entry(K k, V v, int hash, Entry<K, V> next) {
      this.next = next;
      this.hash = hash;
      this.key = k;
      this.value = v;
    }

    public final K getKey() {
      return key;
    };

    public final V getValue() {
      return value;
    };

    public String toString() {
      return key + "=" + value;
    }

    public final int hashCode() {
      return key.hashCode() ^ value.hashCode();
    }

    public final V setValue(V v) {
      V oldValue = value;
      value = v;
      return oldValue;

    }

    public final boolean equals(Entry<?, ?> o) {
      if (o == this)
        return true;
      return (o instanceof MyHashMap<?, ?>.Entry<?, ?>) &&
          (o.getKey() == key) && (o.getValue() == value);
    }
  }

  public MyHashMap(int iniCap, float loadFactor) {
    if (iniCap <= 0) {
      throw new IllegalArgumentException("initial capacity should be greater than 0");
    }
    if (loadFactor <= 0) {
      throw new IllegalArgumentException("Illegal load factor");
    }
    this.loadFactor = loadFactor;
    this.threshold = MyHashMap.tableSizeFor(iniCap);
  }

  public MyHashMap(int iniCap) {
    this(iniCap, DEFAULT_LOAD_FACTOR);
  }

  public MyHashMap() {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
  }

  static final int tableSizeFor(int cap) {
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;

    return n + 1 >= MyHashMap.MAXIMUM_CAPACITY ? MyHashMap.MAXIMUM_CAPACITY : n + 1;
  }

  static final int hash(Object k) {
    int h;
    return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
  }

  public final int size() {
    return size;
  }

  public final boolean isEmpty() {
    return size == 0;
  }

  Entry<K, V>[] resize() {
    Entry<K, V> oldTable[] = table;
    int oldCap = (oldTable == null) ? 0 : oldTable.length;
    int oldThr = threshold;
    int newCap, newThr = 0;

    if (oldCap > 0) {
      if (oldCap >= MAXIMUM_CAPACITY) {
        threshold = Integer.MAX_VALUE;
        return oldTable;
      } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY) {
        newThr = oldThr << 1;
      }
    } else if (oldThr > 0) {
      newCap = oldThr;
    } else {
      newCap = DEFAULT_INITIAL_CAPACITY;
      newThr = (int) (newCap * DEFAULT_LOAD_FACTOR);
    }

    if (newThr == 0) {
      float ft = newCap * loadFactor;
      newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY) ? (int) ft : Integer.MAX_VALUE;
    }
    threshold = newThr;

    Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[newCap];
    table = newTable;
    if (oldTable != null) {
      // resizing
      for (int j = 0; j < oldCap; ++j) {
        Entry<K, V> e;
        if ((e = oldTable[j]) != null) {
          oldTable[j] = null;
          do {
            Entry<K, V> next = e.next;
            int i = e.hash & (newCap - 1);
            e.next = newTable[i];
            newTable[i] = e;
            e = next;
          } while (e != null);
        }
      }
    }

    return newTable;
  }

  public V put(K k, V v) {
    Entry<K, V> tab[], p;
    int n, i, hash = (k == null) ? 0 : hash(k);
    if ((tab = table) == null || (n = tab.length) == 0)
      n = (table = resize()).length;

    if ((p = table[(i = (hash & (n - 1)))]) == null)
      table[i] = new Entry<K, V>(k, v, hash, null);
    else {
      Entry<K, V> e;
      K key;
      if ((p.hash == hash) && ((key = p.key) == k || (k != null && k.equals(key)))) {
        e = p;
      } else {
        for (int count = 0;; ++count) {
          if ((e = p.next) == null) {
            p.next = new Entry<K, V>(k, v, hash, null);
            break;
          }
          if (e.hash == hash && ((key = e.key) == k || (k != null && k.equals(key)))) {
            break;
          }
          p = e;
        }
      }
      if (e != null) {
        V oldValue = e.getValue();
        e.setValue(v);
        return oldValue;
      }
    }
    if (++size > threshold)
      resize();
    return null;
  }

  public V get(K k) {
    Entry<K, V> tab[], first, e;
    K key;
    int n, hash;
    if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(hash = hash(k)) & (n - 1)]) != null) {
      if ((first.hash == hash) && ((key = first.getKey()) == k) && (k != null && k.equals(key)))
        return first.getValue();
      if ((e = first.next) != null) {
        do {
          if ((e.hash == hash) && ((key = e.getKey()) == k) && (k != null && k.equals(key)))
            return e.getValue();
        } while ((e = e.next) != null);
      }
    }
    return null;
  }

  public boolean containsKey(K k) {
    return get(k) != null;
  }

  @Override
  public String toString() {
    String res = "";
    Entry<K, V> tab[], p;
    int n;
    if ((tab = table) != null && (n = tab.length) > 0) {
      for (int i = 0; i < n; i++) {
        if ((p = tab[i]) != null)
          res = res + p.toString() + ", ";
      }

    }
    if (!res.equals("")) {
      res = res.substring(0, res.length() - 2);
    }
    return "{" + res + "}";
  }

}
