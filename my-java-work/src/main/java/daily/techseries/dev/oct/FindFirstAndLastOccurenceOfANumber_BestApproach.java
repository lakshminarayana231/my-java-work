package daily.techseries.dev.oct;

/**
 * I did it  .... wowwwwwwwwww
 * @author lxg8uju
 *
 */
public class FindFirstAndLastOccurenceOfANumber_BestApproach {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 1, 1, 1, 1, 1 ,7, 7 ,125 }; // 8+5/2 = 6,8
        int numberToFind = 7;
        int firstOccurence = firstOccurenceBinarySearch(0,numbers.length,numbers,numberToFind);
        int lastOccurence = lastOccurenceBinarySearch(0,numbers.length,numbers,numberToFind);
        System.out.println("firstOccurence = "+firstOccurence);
        System.out.println("lastOccurence = "+lastOccurence);
    }

    private static int lastOccurenceBinarySearch(int start, int end, int[] numbers, int numberToFind) {
        int mid = (start+end) /2 ;
        if(mid > end || mid <start) {
            return -1;
        }
        if(numbers[mid] == numberToFind ) {
            if(end == mid) {
                return mid;
            }
            return lastOccurenceBinarySearch(mid, end, numbers, numberToFind);
        }
        else if (numbers[mid] > numberToFind) {
            return lastOccurenceBinarySearch(start, mid-1, numbers, numberToFind);
        }
        else {
            return lastOccurenceBinarySearch(mid+1, end, numbers, numberToFind);
        }
    }

    private static void doLinearSearch(int[] numbers, int indexOfAnOccurence) {
        int minIndex = -1;
        int maxIndex = -1;
        int linearSearchCount=0;
        if(indexOfAnOccurence != -1) {
            int temp = indexOfAnOccurence; 
            
            while(temp >=0 && numbers[temp]==numbers[indexOfAnOccurence]) {
                linearSearchCount++;
                minIndex = temp;
                temp = temp -1;
            }
            temp = indexOfAnOccurence;
            while(temp <=numbers.length && numbers[temp]==numbers[indexOfAnOccurence]) {
                linearSearchCount++;
                maxIndex = temp;
                temp = temp + 1;
            } 
        }
         System.out.println(minIndex+" "+maxIndex+"linearSearchCount = "+linearSearchCount);   
    }

    private static int firstOccurenceBinarySearch(int start, int end, int[] numbers, int numberToFind) {
        int mid = (start+end) /2 ;
        if(mid > end || mid <start) {
            return -1;
        }
        if(numbers[mid] == numberToFind ) {
            if(start == mid) {
                return mid;
            }
            return firstOccurenceBinarySearch(start, mid, numbers, numberToFind);
        }
        else if (numbers[mid] > numberToFind) {
            return firstOccurenceBinarySearch(start, mid-1, numbers, numberToFind);
        }
        else {
            return firstOccurenceBinarySearch(mid+1, end, numbers, numberToFind);
        }
    }
    
    
}
