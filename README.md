# findNeedle () API Documentation

## Overview

The `findNeedles()` API method takes a haystack `string` and an array of search terms(`needles[]`), then counts the occurrence of each needle in the `haystack`.

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
#### Inputs
* haystack: `String`
* 

