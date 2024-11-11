# findNeedles () API Documentation

## Overview

The `findNeedles()` API method takes a `haystack` string and an array of string called `needles[]`, then counts the occurrence of each needle in the `haystack` and logs the results.

## Method Signature
```yaml
    public static void
    findNeedles(String haystack, String[] needles)
```

## findNeedles()

```
       public static void findNeedles(String haystack, String[] needles) {
       if (needles.length > 5) {
           System.err.println("Too many words!");
       } else {
           int[] countArray = new int[needles.length];
           for (int i = 0; i < needles.length; i++) {
               String[] words = haystack.split("[ \"\'\t\n\b\f\r]", 0);
               for (int j = 0; j < words.length; j++) {
                   if (words[j].compareTo(needles[i]) == 0) {
                       countArray[i]++;
                   }
               }
           }
           for (int j = 0; j < needles.length; j++) {
               System.out.println(needles[j] + ": " + countArray[j]);
           }
       }
   }

```
#### Input Parameters
* haystack: A main `String` in which to search for each needle.
* needles: An array of `String` containing the words to search for in the haystack.
#### Output
* For each needle, the method logs the word `needles[]` and the the number of times it was found in the `haystack`.
* If `needles.length` is greater than five, it logs the error "Too many words!"


## Calling the API Method

```
   
    String haystack = "The quick brown fox jumps over the lazy dog the quick fox!";

    String[] needles = {"the", "quick", "fox", "dog", "cat"};
    
    findNeedles(haystack, needles);

```
## Limitations

* The method splits the haystack using whitespace and basic punctuations only `([\"\'\t\n\b\f\r])`.This does not take in commas, periods, or other punctuation marks, and may lead to incorrect word splitting and inaccurate counts.
    
* The method uses `compareTo`, which is case-sensitive, meaning it treats "The" and "the" as different words.
* The method only checks for the length of the needle array but does not handle other potential issues such as null inputs or empty string.

## Test Examples

<strong>Test Example 1: Basic Input</strong> 

```
   String haystack = "The quick brown fox jumps over the lazy dog. The fox is quick";
   String [] needles={"fox", "quick", "dog", "lazy", "the"};

   findNeedles(haystack, needles);

```

![TestCase1](/images/Example_1.png)

<strong>Test Example 2: Case Sensitivity Checks</strong>

`compareTo` is case-sensitive.

```
   String haystack = "Hello, world! HELLO everyone. hello.";
   String [] needles={"hello", "world"};

   findNeedles(haystack, needles)
```

```
    Hello,: 1
    world!: 1
    HELLO: 1
    everyone.: 1
    hello.: 1
    hello: 0
    world: 0
```


 ![TestCase2](/images/test_4.jpg)  

<strong>Test Example 3: Exceeding Needle Count Limit</strong>

```
   String haystack = "hello world hello everyone";
   String [] needles={"hello", "world", "everyone", "extra", "text", "123"};

   findNeedles(haystack, needles)
```
![TestCase3](/images/too_many_words.png) 


## Future Improvement

```yaml
   public static void findNeedles(String haystack, String[] needles) {
        if (needles.length > 5) {
            System.err.println("Too many words!");
        } else {
            String[] words = haystack.split("[ \"\'\t\n\b\f\r]", 0); // Splitting once before the loop
            int[] countArray = new int[needles.length];
 
            for (int i = 0; i < needles.length; i++) {
                for (String word : words) {
                    if (word.compareTo(needles[i]) == 0) {
                        countArray[i]++;
                    }
                }
            }
 
            for (int j = 0; j < needles.length; j++) {
                System.out.println(needles[j] + ": " + countArray[j]);
            }
        }
    }
}
    
```
### Benefits
* <strong>Reduced Redundant Computation: </strong>`Split ()` is only called once, reducing the number regex operations.
* <strong>Lower CPU Usage: </strong>By avoiding repeated `split()` calls, we can save CPU cycle.
* <strong>Memory Efficiency:</strong> Reusing `words` array across iterations reduces memory allocations that would have occurred with each repeated `split()`.




