# How to Get the Max or Min Using Java API

# In Several Numbers

## 1. Use Collections  👍

```java
	Collections.max(Arrays.asList(2,8,3,6,4,7));
```

## 2. Use Stream

```java
	IntStream.of(2,8,3,6,4,7).max().getAsInt();
```

**Note**: Stream is a Java 8 feature and it requires `import java.util.stream.*`

# In an Array

Convert to a stream and then get the max/min. 👍

```java
	int[] nums={2,8,3,6,4,7};
	Arrays.stream(nums).max().getAsInt();
```

Note: Using Arrays do not require to import stream package becuase it is  `java.util.Arrays`

# In a List

## 1. Use Collections 👍

```java
    List<Integer> list=Arrays.asList(2,8,3,6,4,7);
    int max = Collections.max(list);
    int min = Collections.min(list);
```

## 2. Use Stream

```java
    List<Integer> list=Arrays.asList(2,8,3,6,4,7);
    list.stream().mapToInt(e->e.intValue()).max().getAsInt();
    list.stream().mapToInt(e->e.intValue()).min().getAsInt();
```

**Note**: list.stream() is a general stream<T>, so use the mapToInt() to get a intstream.

# In a Stream

```java
	stream.max(); stream.min();
```

**Note:** Use get stream.max().getAsint() to transform to int etc. And it may need to conduct a comparator to compare comstomzied objects.

# Conclusion

Java Collections are very powerful, so try to use Arrays + Collections to get the max and min value. For exampe: 

Use Arrays.asList(...) and then Collections.max()/min() to get the max/min value in some numbers. This could be very useful if you need to get the max/min in a 3 or 4 numbers. (It is very painful to use several Math.max(), Math.min() to do so)

Use Arrays.stream(array[]) to transform the array[] to a stream and use the max(), min(). Again, this doesn't require to import the stream package. 