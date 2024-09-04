import java.util.LinkedList;
import java.util.Iterator;

/**
 * A generic Cache class that stores values of type V, where V extends KeyInterface<K>.
 * The cache allows adding, retrieving, removing, and clearing elements.
 *
 * @param <K> the type of keys maintained by this cache
 * @param <V> the type of cached values, which must implement KeyInterface<K>
 * 
 * @author Md Mashrur Arifin
 */
public class Cache<K, V extends KeyInterface<K>> implements CacheInterface<K, V> {

    private LinkedList<V> cache;

    /**
     * Constructor that initializes the cache.
     */
    public Cache() {
        this.cache = new LinkedList<>();
    }

    /**
     * Retrieves the value associated with the specified key from the cache.
     * If the key does not exist in the cache, this method returns null.
     * 
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if the key 
     *         does not exist in the cache
     */
    @Override
    public V get(K key) {
        for (V value : cache) {
            if (value.getKey().equals(key)) {
                return value;
            }
        }
        return null;
    }

    /**
     * Adds a value to the cache. If a value with the same key already exists in 
     * the cache, it is replaced with the new value. The method returns the 
     * previous value associated with the key, or null if there was no such value.
     * 
     * @param value the value to be added to the cache
     * @return the previous value associated with the key, or null if there was 
     *         no previous value
     */
    @Override
    public V add(V value) {
        V existingValue = remove(value.getKey());
        cache.addFirst(value); // Adding to the front for potential LRU cache pattern
        return existingValue;
    }

    /**
     * Removes the value associated with the specified key from the cache. 
     * If the key does not exist in the cache, this method returns null.
     * 
     * @param key the key whose associated value is to be removed
     * @return the removed value associated with the specified key, or null if 
     *         the key does not exist in the cache
     */
    @Override
    public V remove(K key) {
        Iterator<V> iterator = cache.iterator();
        while (iterator.hasNext()) {
            V value = iterator.next();
            if (value.getKey().equals(key)) {
                iterator.remove();
                return value;
            }
        }
        return null;
    }

    /**
     * Clears all entries from the cache, leaving it empty.
     */
    @Override
    public void clear() {
        cache.clear();
    }

    /**
     * Returns a string representation of the cache, typically including details
     * about its contents.
     * 
     * @return a string representation of the cache
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V value : cache) {
            sb.append(value.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example usage with Webpage
        Cache<String, Webpage> webCache = new Cache<>();

        Webpage page1 = new Webpage("https://example.com", "Example content");
        Webpage page2 = new Webpage("https://example.org", "Example org content");

        webCache.add(page1);
        webCache.add(page2);

        System.out.println("Cache after adding two pages:");
        System.out.println(webCache);

        Webpage retrievedPage = webCache.get("https://example.com");
        System.out.println("Retrieved page: " + retrievedPage);

        webCache.remove("https://example.com");
        System.out.println("Cache after removing one page:");
        System.out.println(webCache);

        webCache.clear();
        System.out.println("Cache after clearing:");
        System.out.println(webCache);
    }
}
