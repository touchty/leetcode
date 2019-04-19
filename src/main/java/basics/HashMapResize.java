package basics;

/*
7

All (positive) powers of two have exactly 1 bit set; and (power of 2 - 1) has all of the bits set less than the most significant bit. So, we can find the next largest power of two by

Subtracting 1
Setting all of the less significant bits
Adding 1 back
These bit shifting operations are implementing the second step of this process, by "smearing" the set bits.

So:

n |= n >>> 1;
Would do something like:

  01010000
| 00101000
= 01111000
If you do this again, you "smear" the number down again (still shifting by just 1):

  01111000
| 00111100
= 01111100
Keep on doing this, and you will end up with a number with all of the less significant bits set:

01111111
In the worst case, you'd have to do this 30 times (for a positive, signed 32 bit integer), when the most significant bit is the 31st bit:

   01xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
=> 011xxxxxxxxxxxxxxxxxxxxxxxxxxxxx
=> 0111xxxxxxxxxxxxxxxxxxxxxxxxxxxx
=> 01111xxxxxxxxxxxxxxxxxxxxxxxxxxx
=> 011111xxxxxxxxxxxxxxxxxxxxxxxxxx
...
=> 01111111111111111111111111111111
(x just means it could be a zero or a one)

But you might notice something interesting: after the first smear, when shifting by 1, we have the two most significant bits set. So, instead of shifting by 1, we can skip an operation by shifting by 2:

   01xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
=> 011xxxxxxxxxxxxxxxxxxxxxxxxxxxxx
=> 01111xxxxxxxxxxxxxxxxxxxxxxxxxxx
Continuing with this pattern, shift by 4 next:

=> 011111111xxxxxxxxxxxxxxxxxxxxxxx
Shift by 8:

=> 01111111111111111xxxxxxxxxxxxxxx
Shift by 16:

=> 01111111111111111111111111111111
So, instead of taking 30 operations to set all the less significant bits, we have taken 5.
 */
public class HashMapResize {
    static int MAXIMUM_CAPACITY = 100;
    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static void main(String[] args) {
        tableSizeFor(20);
    }
}
