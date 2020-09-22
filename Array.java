//ARRAY

/* The actual code for creating an Array to hold DVD's.*/
DVD[] dvdCollection = new DVD[15];
// A simple definition for a DVD.
public class DVD {
    public String name;
    public int releaseYear;
    public String director;

    public DVD( final String name, final int releaseYear, final String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public String toString() {
        System.out.println(this.name + ", directed by " + 
                           this.director + ", released in " +
                           this.releaseYear);
    }
}

// Firstly, we need to actually create a DVD object for The Avengers.
DVD avengersDVD = new DVD("The Avengers", 2012, "Joss Whedon");

// Next, we'll put it into the 8th place of the Array. Remember, because we
// started numbering from 0, the index we want is 7.
dvdCollection[7] = avengersDVD;

DVD incrediblesDVD = new DVD("The Incredibles", 2004, "Brad Bird");
DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
DVD lionKingDVD = new DVD("The Lion King", 2019, "Jon Favreau");

// Put "The Incredibles" into the 4th place: index 3.
dvdCollection[3] = incrediblesDVD;

// Put "Finding Dory" into the 10th place: index 9.
dvdCollection[9] = findingDoryDVD;

// Put "The Lion King" into the 3rd place: index 2.
dvdCollection[2] = lionKingDVD;

DVD starWarsDVD = new DVD("Star Wars", 1977, "George Lucas");
dvdCollection[3] = starWarsDVD;

// Print out what's in indexes 7, 10, and 3.
System.out.println(dvdCollection[7]);
System.out.println(dvdCollection[10]);
System.out.println(dvdCollection[3]);

// Will print:

// The Avengers, directed by Joss Whedon, released in 2012
// null
// Star Wars, directed by George Lucas, released in 1977


int[] squareNumbers = new int[10];

// Go through each of the Array indexes, from 0 to 9.
for (int i = 0; i < 10; i++) {
    // We need to be careful with the 0-indexing. The next square number
    // is given by (i + 1) * (i + 1).
    // Calculate it and insert it into the Array at index i.
    int square = (i + 1) * (i + 1);
    squareNumbers[i] = square;
}

// Go through each of the Array indexes, from 0 to 9.
for (int t = 0; t < 10; t++) {
    // Access and print what's at the i'th index.
    System.out.println(squareNumbers[i]);
}

// Will print:
// 1
// 4
// 9
// 16
// 25
// 36
// 49
// 64
// 81
// 100

// For each VALUE in the Array.
for (int square : squareNumbers) {
    // Print the current value of square.
    System.out.println(square);
}
// Prints exactly the same as the previous example.

DVD[] array = new DVD[6];

int capacity = array.length;
System.out.println("The Array has a capacity of " + capacity);
//The Array has a capacity of 6


// Create a new array with a capacity of 10.
int[] arra = new int[6];

// Current length is 0, because it has 0 elements.
int length = 0;

// Add 3 items into it.
for (int p = 0; p < 3; p++) {
    arra[p] = p * p;
    // Each time we add an element, the length goes up by one.
    length++;
}

System.out.println("The Arra has a capacity of " + arra.length);
System.out.println("The Arra has a length of " + length);

/*
The Array has a capacity of 6
The Array has a length of 3
*/

class Solution {
    public int findConsecutiveOnes(int[] nums) {
        // Hint: Initialise and declare a variable here to 
        int count = 0;
        for(int i=0; i < nums.length; i++){
                if(nums[i]==1){
                    count++;
                }
        }
        return count; 
    }
}
// [1,0,1,1,0,1]
// 4

/*
PROBLEM 1 
consiste en encontrar la maxima cantidad de unos consecutivos en un array
ejemplo
imput = [1,0,1,1,1,1,0,1]
out = 4
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Hint: Initialise and declare a variable here to 
 
        int max = 0,count=0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                max = (max > count) ? max : count;
                count=0;
            }
            else{
                count++;
            }
        }         //if true do this else this        
        return (count > max) ? count  :  max;
    }

}




/*PROBLEM 2 
consiste en encontrar los numeros cuya longitud sea par
ejemplo 
imput = [123,6653,232,5553]
out = 2
123 --> son tres numeros entonces impar
6653 --> son 4 numeros entonces par
232 --> son tres numeros entonces impar
5553 --> son 4 numeros entonces par
se encontraron 2 pares en ese array
*/

class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            if((100000>=nums[i])&&(nums[i]>=1)){
                String s =  String.valueOf(nums[i]);
                if((s.length()%2)==0){
                    count++;
                }  
            }
          }
        
        return count;
    }

 }


/*
PROBLEM 3

Given an array of integers A sorted in non-decreasing order, return an array of the squares 
of each number, also in sorted non-decreasing order.

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.

Solution
Approach 1: Sort
Intuition and Algorithm

Create an array of the squares of each element, and sort them.
*/
class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }
}
/*
///// python
class Solution(object):
    def sortedSquares(self, A):
        return sorted(x*x for x in A)

Complexity Analysis

Time Complexity: O(N log N), where N is the length of A.

Space Complexity: O(N).        

Approach 2: Two Pointer
Intuition

Since the array A is sorted, loosely speaking it has some negative elements with squares in
decreasing order, then some non-negative elements with squares in increasing order.

For example, with [-3, -2, -1, 4, 5, 6], we have the negative part [-3, -2, -1] with squares
[9, 4, 1],and the positive part [4, 5, 6] with squares [16, 25, 36]. Our strategy is to iterate over
the negative part in reverse, and the positive part in the forward direction.

Algorithm

We can use two pointers to read the positive and negative parts of the array - one pointer j
in the positive direction, and another i in the negative direction.

Now that we are reading two increasing arrays (the squares of the elements), we can merge these
arrays together using a two-pointer technique.
*/
// JAVA 
class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}

//// PYTHON
/*
class Solution(object):
    def sortedSquares(self, A):
        N = len(A)
        # i, j: negative, positive parts
        j = 0
        while j < N and A[j] < 0:
            j += 1
        i = j - 1

        ans = []
        while 0 <= i and j < N:
            if A[i]**2 < A[j]**2:
                ans.append(A[i]**2)
                i -= 1
            else:
                ans.append(A[j]**2)
                j += 1

        while i >= 0:
            ans.append(A[i]**2)
            i -= 1
        while j < N:
            ans.append(A[j]**2)
            j += 1

        return ans


Complexity Analysis

Time Complexity: O(N), where N is the length of A.

Space Complexity: O(N).       

*/

// Inserting items into an array
//Insert a new element at the end of the Array
// Declare an integer array of 6 elements

int intArray = new int[6];
int leng = 0;

// Add 3 elements to the Array
for (int i = 0; i < 3; i++) {
    intArray[leng] = i;
    length++;

for (int i = 0; i < intArray.length; i++) {
    System.out.println("Index " + i + " contains " + intArray[i]);
}


// Insert a new element at the end of the Array. Again,
// it's important to ensure that there is enough space
// in the array for inserting a new element.
intArray[length] = 10;
length++;

//Inserting at the Start of an Array
// First, we will have to create space for a new element.
// We do that by shifting each element one index to the right.
// This will firstly move the element at index 3, then 2, then 1, then finally 0.
// We need to go backwards to avoid overwriting any elements.
for (int i = 3; i >= 0; i--) {
    intArray[i + 1] = intArray[i];
}

// Now that we have created space for the new element,
// we can insert it at the beginning.
intArray[0] = 20;


//Inserting at the middle of an Array
// Say we want to insert the element at index 2.
// First, we will have to create space for the new element.
for (int i = 4; i >= 2; i--)
{
    // Shift each element one position to the right.
    intArray[i + 1] = intArray[i];
}

// Now that we have created space for the new element,
// we can insert it at the required index.
intArray[2] = 30;

/*PROBLEM 4 
duplicar los 0 moviendo todos los otros elementos a la derecha
dejando ese espacio para q se rellene por default */
class Solution {
    public void duplicateZeros(int[] arr) {
        // recorre todos los elementos del array
        for (int i = 0; i < arr.length; i++){
            // de los elementos recorridos elije los que son iguales a 0
            if(arr[i]==0){ 
                // de la longitud del array
                // busca el elemento 0 y mueve el resto a la derecha
                // haciendo espacio para que el elemento 0 se duplique
                // por el hecho de que si el array no tiene elementos
                // se llena por default con 0
                for(int j=arr.length-1; j>i; j--){
                    arr[j]=arr[j-1];
                }
                i++; //pasar al siguiente elemento
            }else{
                continue;
            }
        }
    }
}

//PROBLEM 5 
//UNIR DOS array 

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c = 0;//primer elemento del segundo array(banderita)
        for(int i=m+c;i<nums1.length;i++){//i es igual a la suma de m+c
                                           //(la longitud del segundo array mas la banderita)
                                 //y mientras i sea menor que la longitud del array mas largo
            nums1[i]=nums2[c];//agregar el elemento marcado con bandertita(del segundo array) a la posicion 
            //marcada por i en el array mas largo
            c++;//pasa al siguiente elemento
        }Arrays.sort(nums1); //ordena los elementos en orden ascendente
    }
}
}




/*Here is some code that creates an Array with room for 10 elements,
and then adds elements into the first 6 indexes of it.*/

// Declare an integer array of 10 elements.
int[] intArray = new int[10];

// The array currently contains 0 elements
int length = 0;

// Add elements at the first 6 indexes of the Array.
for(int i = 0; i < 6; i++) {
    intArray[length] = i;
    length++;
}

// Deletion from the end is as simple as reducing the length
// of the array by 1.
length--;

for (int i = 0; i < intArray.length; i++) {
    System.out.println("Index " + i + " contains " + intArray[i]);
}

for (int i = 0; i < length; i++) {
    System.out.println("Index " + i + " contains " + intArray[i]);
}



// Starting at index 1, we shift each element one position
// to the left.
for (int i = 1; i < length; i++) {
    // Shift each element one position to the left
    int_array[i - 1] = int_array[i];
}

// Note that it's important to reduce the length of the array by 1.
// Otherwise, we'll lose consistency of the size. This length
// variable is the only thing controlling where new elements might
// get added.
length--;



// Say we want to delete the element at index 1
for (int i = 2; i < length; i++) {
    // Shift each element one position to the left
    int_array[i - 1] = int_array[i];
}

// Again, the length needs to be consistent with the current
// state of the array.
length--;



/*PROBLEM 6

dado un array y un entero, eliminar el numero dado que se repita
ejemplo: num =[4,5,2,4,4] int = 4
return num=[5,2] length = 2 
*/
class Solution_6 {
    public int removeElement(int[] nums, int val) {
        int u = 0;
        int i = 0;
        while(i<nums.length){
            if(nums[i]!=val){
              nums[u]=nums[i];
              u++;
            }
        i++;
        }return u;
    }
}

//OTRA SOLUCION 
class Solution6 {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        for(int i=len-1;i>=0;i--){
            if(nums[i]==val)
                nums[i]=nums[--len];
            
        }
        
        return len;
    }
}

//PROBLEM 7

//dado un array ordenado eliminar los elementos duplicados

class Solution_7 {
    public int removeDuplicates(int[] nums) {
        int u = 1;
        int i = 1;
        while(i<nums.length){
            if(nums[i-1]!=nums[i]){
              nums[u]=nums[i];
              u++;
            }
        i++;
        }return u;
    }
}

//buscar en un array 
//busqueda lineal 
public static boolean linearSearch(int[] array, int length, int element) {
    // Check for edge cases. Is the array null or empty?
    // If it is, then we return false because the element we're
    // searching for couldn't possibly be in it.
    if (array == null || length == 0) {
        return false;
    }

    // Carry out the linear search by checking each element,
    // starting from the first one.
    for (int i = 0; i < length; i++) {
        // We found the element at index i.
        // So we return true to say it exists.
        if (array[i] == element) {
            return true;
        }
    }

    // We didn't find the element in the array.
    return false;
}


public class ArraySearch {
    public static void main(String args[]) {

        // Declare a new array of 6 elements
        int[] array = new int[6];

        // Variable to keep track of the length of the array
        int length = 0;

        // Iterate through the 6 indexes of the Array.
        for (int i = 0; i < 6; i++) {
            // Add a new element and increment the length as well
            array[length++] = i;
        }

        // Print out the results of searching for 4 and 30.
        System.out.println("Does the array contain the element 4? - " + ArraySearch.linearSearch(array, length, 4));
        System.out.println("Does the array contain the element 30? - " + ArraySearch.linearSearch(array, length, 30));

        // Does the array contain the element 4? - true
        // Does the array contain the element 30? - false
    }

    public static boolean linearSearch(int[] array, int length, int element) {
        // Check for edge cases
        if (array == null || length == 0) {
            return false;
        }

        // Check each element starting from the first one
        for (int i = 0; i < length; i++) {
            // We found the element at index i, so return true.
            if (array[i] == element) {
                return true;
            }
        }

        // We didn't find the element in the array.
        return false;
    }
}


/*PROBLEM 8 
dado un array devolve true si hay un numero N y M tal que se cumpla la siguiente condicion
N=M*2
*/
class Solution_8 {
    public boolean checkIfExist(int[] arr) {
        
        for(int i =0; i<arr.length;i++){
            
            for(int j = 0; j<arr.length; j++){
                if((arr[j]==2*arr[i])&& i!=j){
                    return true;
                }
            }
           
        }return false;
    }
}

//PROBLEM 9
//montaña

class Solution_9 {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        // two pointers move toward mid to find the peak.
        int left = 0;
        int right = A.length - 1;
        
		// The peak cannot be the last index of array, so left < (A.length - 2) would make sure
		// the left pointer at most move to (A.length - 2)		
        while (left < (A.length -2) && A[left] < A[left + 1]) {
            left++;
        }
		
        // Similarly, the peak cannot be the fist index of array, so right > 1 would 
		// make sure the right pointer move at most to index 1.
        while (right > 1 && A[right] < A[right - 1]) {
            right--;
        }
        // if the peak climb from left is the same peak as from right, it is a valid mountain.      
        if (left == right) {
            return true;
        } else {
            return false;            
        }
    }
}

class Solution9 {
    public boolean validMountainArray(int[] A) {
       if (A == null || A.length < 3) {
            return false;
        }
        int f=A.length - 1;
        int g=0;
         
        for(int j=A.length - 1; j>1 && A[j] < A[j - 1]; j--){
           f--;             
        }
        for(int i=0; i<(A.length-2) && A[i] < A[i + 1]; i++){
           g++;
        } 
        
        if(f==g){
           return true;
        }else{
            return false;
        }
    }
}


/*
Given an Array of integers, return an Array where every element at an even-indexed position is squared.

Input: array = [9, -2, -9, 11, 56, -12, -3]
Output: [81, -2, 81, 11, 3136, -12, 9]
Explanation: The numbers at even indexes (0, 2, 4, 6) have been squared, 
whereas the numbers at odd indexes (1, 3, 5) have been left the same.*/
//CON UN ARRAY EXTRA 
public int[] squareEven(int[] array, int length) {

    // Check for edge cases.
    if (array == null) {
      return null;
    }
  
    // Create a resultant Array which would hold the result.
    int result[] = new int[length];
  
    // Iterate through the original Array.
    for(int i = 0; i < length; i++) {
  
      // Get the element from slot i of the input Array.
      int element = array[i];
  
      // If the index is an even number, then we need to square element.
      if (i % 2 == 0) {
        element *= element;
      }
  
      // Write element into the result Array.
      result[i] = element;
    }
  
    // Return the result Array.
    return result;
  }

//EN EN MISMO ARRAY(MEJOR)


public int[] squareEvenG(int[] array, int length) {

    // Check for edge cases.
    if (array == null) {
      return array;
    }
  
    // Iterate through the original array.
    for(int i = 0; i < length; i++) {
  
      // If the index is an even number, then we need to square the element
      // and replace the original value in the Array.
      if (i % 2 == 0) {
        array[i] *= array[i];
      }
      // Notice how we don't need to do *anything* for the odd indexes? :-)
    }
  
    // We just return the original array. Some problems on leetcode require you
    // to return it, and other's dont.
    return array;
  }
//PROBLEM 10
//Dado un arreglo arr, reemplace cada elemento en ese arreglo con el elemento más 
//grande entre los elementos a su derecha, y reemplace el último elemento con -1.
//Después de hacerlo, devuelva la matriz.
  
class Solution_10 {
    public int[] replaceElements(int[] arr) {
        if (arr == null) {
          return arr;
        }
        int max=-1,flag=0;
        for(int i=arr.length-1; i>=0;i--){
            flag=arr[i];
            arr[i]=max;
            if(flag>max){
                max = flag;
            }
            
        }
        return arr;
    }
}

// crea un nuevo array de enteros unicos osea removiendo los duplicados
public int[] copyWithRemovedDuplicates(int[] nums) {
        
  // Check for edge cases.
  if (nums == null || nums.length == 0) {
    return nums;
}

// Count how many unique elements are in the Array.
int uniqueNumbers = 0;
for (int i = 0; i < nums.length; i++) {
    // An element should be counted as unique if it's the first
    // element in the Array, or is different to the one before it.
    if (i == 0 || nums[i] != nums[i - 1]) {
        uniqueNumbers++;
    }
}

// Create a result Array.
int[] result = new int[uniqueNumbers];

// Write the unique elements into the result Array.
int positionInResult = 0;
for (int i = 0; i < nums.length; i++) {
  // Same condition as in the previous loop. Except this time, we can write
  // each unique number into the result Array instead of just counting them.
    if (i == 0 || nums[i] != nums[i - 1]) {
        result[positionInResult] = nums[i];
        positionInResult++;
    }
}
return result;
}

//PROBLEM 10 SOLUTION

public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}

// PROBLEM 11 
// LOS CEROS AL FINAL
class Solution11 {
    public void moveZeroes(int[] nums) {
        int flag=0;
        for(int i=0;i<nums.length&&flag<nums.length;i++){
            if(nums[i]!=0){
                int o = nums[flag];
                nums[flag]=nums[i];
                nums[i]=o;
                flag++;
            }
        }
    }
}
//IMPARES AL  FINAL

class Solution {
    public int[] sortArrayByParity(int[] A) {
       if (A == null) {
          return A;
        }
        int len = A.length;
        //int[] out = new int[len];
        int flag = 0;
        for(int i=0;i<len&&flag<len;i++){
            if((A[i])%2==0){
                int o = A[flag];
                A[flag] = A[i];
                A[i] = o;
                flag++;
            }
        }
        return A;
    }
}


//PROBLEM 12 
// LOS IMPARES AL FINAL
class Solution12 {
    public int[] sortArrayByParity(int[] A) {
        int p=0;
        for(int i=0;i<A.length&&p<A.length;i++){
            if(A[i]%2==0){
                int k=A[p];
                A[p]=A[i];
                A[i]=k;
                p++;
            }
        }return A;
    }
}

// PROBLEM 13 
// RAIZ CUADRADA DE UN ARRAY ORDENADO EN FORMA CRECIENTE O NO DECRECINTE
class Solution13 {
    public int[] sortedSquares(int[] A) {
        int Arraylength = A.length, j = 0;
        while (j < Arraylength && A[j] < 0){j++;}
        int i = j-1;
        int[] out = new int[Arraylength];
        int t = 0;
        while (i >= 0 && j < Arraylength) {
            if (A[i] * A[i] < A[j] * A[j]) {
                out[t++] = A[i] * A[i];
                i--;
            } else {
                out[t++] = A[j] * A[j];
                j++;
            }
        }
        while (i >= 0) {
            out[t++] = A[i] * A[i];
            i--;
        }
        while (j < Arraylength) {
            out[t++] = A[j] * A[j];
            j++;
        }
        return out;
    }
}

//PROBLEMA 14
//DADO UN ARRAY DESORDENADO, CONTAR LA CANTIDAD DE MOVIMIENTOS QUE TIENE QUE HACERSE
//PARA ORDENARLO EN ORDE CRECIENTE 
class Solution14 {
    public int heightChecker(int[] heights) {
        int arrL = heights.length;//longitud del array
        int count=0;//inicio el contador
        int[] arr = new int[arrL];// nuevo array de la misma longitud que el anterior
        // relleno el array con los mismos numeros que el anterior
        for(int i=0; i<arrL;i++){
            arr[i]=heights[i];
        }
        // aqui los ordeno de menor a mayor
        Arrays.sort(arr);
        // contar la cantidad de movimientos a hacer 
        for(int j=0;j<arrL;j++){
            if(arr[j]!=heights[j]){
                count++;
            }
        }
        return count;
    }
}


// PROBLEM 15

class Solution15 {
    public int thirdMax(int[] nums) {
        int len = nums.length;//longitud del array
        int point = 0;//punto bandera para contar
        Arrays.sort(nums);//ordenar ascendentemente 
        // si la longitud es menor a 3 devolver el mas grande
        if (len < 3) {
            return nums[len - 1];
        }
        //recorrer el array desde atras o del ultimo elemento
        for (int i=len-1; i > 0; i--) {
            // si el elemento actual es distinto al elemento anterior 
            if (nums[i] != nums[i - 1]) {
                point++;//sumar 1 
            }
            // si se consigue 2 puntos devolver el elemento anterior al actual
            if (point == 2) {
                return nums[i - 1];
            }
        }
        //devolver el ultimo elemento
        return nums[len-1];
        
    }
}


//PROBLEM 16
class Solution16 {
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer>ans=new LinkedList();
        if(nums.length==0)return ans;
        int[] freq=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        for(int i=1;i<freq.length;i++)if(freq[i]==0)ans.add(i);   //skip 0 as N!=0
        return ans;
    }

//O(1) space
public List<Integer> findDisappearedNumbers(int[] nums){
    List<Integer>ans=new LinkedList();
    if(nums.length==0)return ans;
    int n=nums.length;
    
        //marking if a no. n is present by making -ve the val at that n-1th idx
    //theres no zero so at 0th idx will have no.1 and so on
    for(int i=0;i<n;i++){
        int idx=Math.abs(nums[i]);
        nums[idx-1]=Math.abs(nums[idx-1])*-1;    
        //here taking abs. val cause in case duplicates same idx will be negated over and             //over and turn positive          
        
    }
    for(int i=0;i<n;i++){
        if(nums[i]>0)ans.add(i+1);
    }
    return ans;
}


/////////

/*Best Time to Buy and Sell Stock
Easy

5595

244

Add to List

Share
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.*/

class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;//MAXIMO VALOR POSIBLE EN JAVA
        int flag = 0;// bandera 
        for(int i=0;i<prices.length;i++){//recorrer el array desde pos[0] a la ultima
            if(prices[i]<min){//para buscar el valor minimo
                min = prices[i];// valor minimo del array
                //flag = i;
            }
            flag = Math.max(flag, prices[i]-min);//profit 
        }
        return flag;
    }
}

class Solution {
    public int maxProfit(int[] prices) {    
        int min = 0;//minimo
        int max = 0;
        int flag = 0;// bandera 
        for(int i=0;i<prices.length-1;i++){//recorrer el array desde pos[0] a la ultima
            if(prices[i]<prices[i+1]){//para buscar el valor minimo
                flag += max-min; 
                min = prices[i];// valor minimo del array
                max = prices[i+1];
            }
            
        }
        flag += max-min;
        return flag; 
    }
}

// thanks to lkjhlkjhasdf1 and amoghrajesh1999

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int fb=-prices[0], fs=Integer.MIN_VALUE;
        int sb=Integer.MIN_VALUE, ss=Integer.MIN_VALUE;
        
        for(int i=1;i<prices.length;i++){
            fb=Math.max(fb,-prices[i]);
            fs=Math.max(fs,fb+prices[i]);
            sb=Math.max(sb,fs-prices[i]);
            ss=Math.max(ss,sb+prices[i]);
        }
        return Math.max(0,ss);
    }
}