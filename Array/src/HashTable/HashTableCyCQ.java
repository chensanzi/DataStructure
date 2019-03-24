package HashTable;
import java.util.Set;
import java.util.TreeMap;

/**
 * <p>
 /**
 * hashTable速度比较快的原因就在于其将TreeMap的O（log n）的算法复杂度转变成了 O（log n/M）的计算大小，下面做具体分析。
 * 底层红黑树生成的TreeMap的算法复杂度为O（log n）。但是将数据存储在数组中，并知道其存储地址时的时间复杂度为O（1）。
 * 那如何将待存储的数据放入数组成为了这一问题的关键。
 * 我们知道java中每一个对象实例都有一个地址，这个地址是唯一的，就是hashcode（int型）。
 * 理论上我们可以生成一个巨大的一个数组 Data[很大的正数]，数据存储时将hashcode作为索引。查询数据时因为我们指导待查询对象对应key的hashcode，
 * 可以直接由Data[key.hashcode]得到对象，这时候的时间复杂的是O（1）的，这就是计算机中的空间换时间。
 * 但是 new Data[很大的正数]本身就是一个不合理的存在，我们需要根据待存储数据的规模来开辟存储空间，这就是hashTable出现的意义。
 * 我们可以提前开辟一定大小的数组，希望待存储数据均匀的分布在数组中，这时候就产生了hash函数。我们代码中的hash函数为(key.hashCode() & 0x7fffffff)%M；
 * 任何一个数 T & 0x7fffffff 是取T的绝对值，因为数组索引是正数。T%M，就是取T与M的余数，|T%M|是一个正数，且一定小于M。这样将|T%M|作为数组Data[M]的索引就一定
 * 不会越界。数学上有证明当M是一个质数时（不要求会证明），|T%M|产生的余数是均匀分布在区间[0,M）上的正数，所以选择M为质数比较好。
 * 但无论M怎么取值也不能保证产生的hash值(key.hashCode() & 0x7fffffff)%M一定不一样，这时候就产生了hash冲突，这样就会导致一个数组空间需要存储两个对象，一般的数组
 * 明显不满足需求。
 * 为了解决上诉冲突，由两个方面出发：
 * 1.根据数据规模将质数M增大，由查询资料获得在不同的数据规模下，M由不同的合理的取值。{53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
 * 2.但就算M取的再大也会存在hash值一样，这时候我们就需要支持一个数组空间能存储多个元素，于是我们数组空间中可以存储一个链表，或者一个map（只要能存储多个元素即可）。
 * 这样存储数据时，先计算出待存储对象的hash值：(key.hashCode() & 0x7fffffff)%M，找到数组hashTable的空间hashTable[hash],然后根据待存储对象对应的key存储到链表中，或者
 * map中（java8 之前hashTable中存储的是一个链表，java8 及之后初始时是一个链表，当数据大时每个数组的存储空间中是以和TreeMap。）。我们程序中是在hashTable中存储
 * treeMap。
 * 这样我们查询（或其他操作）一个元素时，首先计算出该元素对应key的hash值，然后根据hash值找到hashTable中对应的存储空间hashTable[hash]，这个时间复杂度是O（1）的，
 * 然后根据key在hashTable[hash]中的treeMap中查找到对应的元素，由于hashTable中每个treeMap的size平均为 n/M，这样查询到具体的元素的时间复杂度为O（log（n/M））。总的
 * 计算复杂度为：O（1）+ O（log（n/M））= O（log（n/M）），即hashTable的复杂度为O（log（n/M））。这就是hashTable比较快的原因。
 * hashMap的原理也是如此，相当于用hashTable 实现了Map接口而已。
 *
 * @return
 * </p>
 *
 * @author chenqing
 * @version 1.0
 * @class_name HashTableCyCQ
 * @date 2019/3/19
 * @time 14:51
 */
public class HashTableCyCQ<K,V> {
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;
    private int capacityIndex = 0;

    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};


    private TreeMap<K,V>[] hashTable;
    private int M;
    private int size;

    public HashTableCyCQ(){
        this.M = capacity[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];
        for (int i=0;i<M;i++){
            hashTable[i] = new TreeMap<K,V>();
        }
    }

//    public HashTableCyCQ(int M){
//        this.M = M;
//        size = 0;
//        hashTable = new TreeMap[M];
//        for (int i=0;i<M;i++){
//            hashTable[i] = new TreeMap<>();
//        }
//    }

//    public HashTableCyCQ(){
//        this(initCapacity);
//    }

    /**
     * hash 函数
     *
     * @param key
     * @return
     */
    private int hash(K key){
        int hash = key.hashCode();
        int a = (key.hashCode() & 0x7fffffff)%M;
        return a;
    }

    public int getSize(){
        return size;
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void add(K key,V value){
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)){
            map.put(key,value);
        }else{
            map.put(key,value);
            size++;

            if (size>= upperTol*M && capacityIndex+1<capacity.length){
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
//        if (null != hashTable[hash(key)].get(key)){
//            hashTable[hash(key)].put(key,value);
//        }else{
//            hashTable[hash(key)].put(key,value);
//            size++;
//        }
    }

    /**
     * 删除元素
     * @param key
     * @return
     */
    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)){
            ret = map.remove(key);
            size--;

            if (size< lowerTol*M && capacityIndex-1>=0){
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
//        if (hashTable[hash(key)].get(key) == null){
////            throw new IllegalArgumentException("not exist this key");
//            return ret;
//        }else{
//            ret =hashTable[hash(key)].remove(key);
//            size--;
//            return ret;
//        }
    }

    public void set(K key,V value){
        TreeMap<K,V> treeMap = hashTable[hash(key)];
        if (!treeMap.containsKey(key)){
            throw new IllegalArgumentException("not exist this key");
        }else{
            treeMap.put(key,value);
        }
    }

    public V get(K key){
        V ret = null;
        TreeMap<K,V> treeMap = hashTable[hash(key)];
        if (treeMap.containsKey(key)){
            ret = treeMap.get(key);
        }
        return ret;
    }

    public boolean contains(K key){
        return hashTable[hash(key)].containsKey(key);
    }

    private void resize(int newM){

        TreeMap<K,V>[] newhashTable = new TreeMap[newM];
        for (int i=0;i<newM;i++){
            newhashTable[i] = new TreeMap<K,V>();
        }

        int oldM = this.M;
        this.M = newM;
        for (int i=0;i<oldM;i++){
            TreeMap<K,V> map = hashTable[i];
            for (K key:map.keySet()){
                newhashTable[i].put(key,map.get(key));
            }
        }

        this.hashTable = newhashTable;
    }
}

