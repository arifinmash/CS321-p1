/**
 * Represents a cache interface that defines basic operations for a cache system.
 * <p>
 * This interface supports adding, retrieving, removing, and clearing entries in the cache.
 * It uses a generic key type <code>K</code> and a generic value type <code>V</code> where <code>V</code>
 * must implement the <code>KeyInterface&lt;K&gt;</code> interface.
 * </p>
 * 
 * @param <K> The type of the key used in the cache.
 * @param <V> The type of the value stored in the cache, which must implement the <code>KeyInterface&lt;K&gt;</code> interface.
 * @see KeyInterface
 * @see java.util.Map
 * @author CS321 Instructors
 * @author Md Mashrur Arifin
 */
public interface CacheInterface<K, V extends KeyInterface<K>> {

    /**
     * Retrieves the value associated with the specified key from the cache.
     * <p>
     * If the key does not exist in the cache, this method may return <code>null</code> or throw an exception
     * depending on the implementation.
     * </p>
     * 
     * @param key The key whose associated value is to be retrieved.
     * @return The value associated with the specified key, or <code>null</code> if the key does not exist in the cache.
     */
    V get(K key);

    /**
     * Adds the specified value to the cache.
     * <p>
     * If the cache already contains a value associated with the key of the provided value, this method may
     * overwrite the existing value, depending on the implementation.
     * </p>
     * 
     * @param value The value to be added to the cache. The value must implement <code>KeyInterface&lt;K&gt;</code>.
     * @return The value that was added to the cache. This may be the same value or a replacement if the key already existed.
     */
    V add(V value);

    /**
     * Removes the entry associated with the specified key from the cache.
     * <p>
     * If the key does not exist in the cache, this method may have no effect or return <code>null</code>.
     * </p>
     * 
     * @param key The key of the entry to be removed from the cache.
     * @return The value that was removed from the cache, or <code>null</code> if the key was not found.
     */
    V remove(K key);

    /**
     * Clears all entries from the cache.
     * <p>
     * After this method is called, the cache should be empty, and subsequent calls to <code>get</code> should
     * return <code>null</code> for any key.
     * </p>
     */
    void clear();

    /**
     * Returns a string representation of the cache.
     * <p>
     * This method is intended to provide a human-readable representation of the cache's contents.
     * The default implementation from <code>Object</code> may be overridden to provide more specific information.
     * </p>
     * 
     * @return A string representation of the cache.
     */
    @Override
    String toString();
}
