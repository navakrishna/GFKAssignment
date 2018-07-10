This project consits of 3 problems and solutions 

# Problem 1

You are given the following information, which you might already know: 1st Jan 1900 was a Monday. September, April, June and November have 30 days. February has 28 days, or 29 days, when it’s a leap year. All other months have 31 days  A leap year occurs on any year divisible by 4, but not on a century unless it is divisible by 400.Question: How many Sundays fell on the first of the month during the entire twentieth century (1st Jan 1901 to 31st Dec 2000)?

   Solution is in CountOfDOWAsBeginingOfMonth class


 # Problem 2

 The Eurozone currency is made up of euros (€) and cents (c) and there are eight coins in general circulation:1c, 2c, 5c, 10c, 20c, 50c, €1 (100c) and €2 (200c).Before the Euro was officially introduced in 11 countries in 2002, citizens of those countries were able to purchase “euro starter kits” from local banks. The nominal price of the French starter kit was of 100 French francs equivalent to €15.25. It contained the following Euro coins (see https://en.wikipedia.org/wiki/Euro_starter_kits#France):

 How many different ways can € 15.25 euro be made using any number of coins?

 		Solution is in ComputeWaysToCountCoins class.



 # Problem 3

 Problem 3Roman numerals are based on seven symbols: Symbol Value
I 1V5X 10L50C 100D500M 1,000Numbers are formed by combining symbols and adding the values, so II  is two (two ones) and XIII is thirteen (a ten and three ones). There is no zero in this system and characters do not represent tens, hundreds and so on according to position as in 207 or 1066; those numbers are written as CCVII (two hundreds, a five and two ones) and MLXVI (a thousand, a fifty, a ten, a five and a one).Symbols are placed from left to right in order of value, starting with the largest. However, in a few specific cases, to avoid four characters being repeated in succession (such as IIII or XXXX), subtractive notations often used as follows:  I placed before V or X indicates one less, so four is IV (one less than five) and nine is IX (one less than ten) X placed before L or C indicates ten less, so forty is XL (ten less than fifty) and ninety is XC (ten less than a hundred) C placed before D or M indicates a hundred less, so four hundred is CD (a hundred lessthan five hundred) and nine hundred is CM (a hundred less than a thousand)

Find the number of characters saved by writing every number from 1 to 1000 in its Arabic representation as compared to its minimal Roman representation.

   Solution is in ComputeDiffOfDigitsInArabicAndRomanNums class.