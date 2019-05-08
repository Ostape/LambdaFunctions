Task 1:
The method takes a list of names. Returns a string of the form "1. Ivan, 3. Peter ...", only with names on odd indices, respectively.

Task 2:
The method map list of string to uppercase and then sort descending.

Task 3:
Given  and collection = Arrays.asList ("1, 2, 0", "4, 5")
From the collection get all the numbers listed, separated by commas from all the elements

Task 4:
Using Stream.iterate, make an infinite stream of random numbers — not by calling Math.random but by directly implementing a linear congruential generator. In such a generator, you start with x[0] = seed and then produce x[n + 1] = 1 (a x[n] + c) % m, for appropriate values of a, c, and m. You should implement a method with parameters a, c, m, and seed that yields a Stream<Long>. Try out a = 25214903917, c = 11, and m = 2^48.

Task 5:
Write a method public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) that alternates elements from the stream first and second, stopping when one of them runs out of elements.


Task 6(Optional):
It should be possible to concurrently collect stream results in a single ArrayList, instead of merging multiple array lists, provided it has been constructed with the stream's size, since concurrent set operations at disjoint positions are threadsafe. How can you achieve this?

