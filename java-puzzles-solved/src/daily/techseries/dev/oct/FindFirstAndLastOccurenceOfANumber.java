package daily.techseries.dev.oct;
/**
 * Note: This does binary search to find out first occurence and then linear search to find any other occurrences.
 * But there is better way of doing. We could see binary search to find fist and last occurrences.
 * @author lxg8uju
 *
 */
public class FindFirstAndLastOccurenceOfANumber {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 3, 5, 5, 5, 5 ,7, 123 ,125 };
        int numberToFind = 5;
        int indexOfAnOccurence = binarySearch(0,numbers.length,numbers,numberToFind);
        System.out.println("indexOfAnOccurence = "+indexOfAnOccurence);
        doLinearSearch(numbers,indexOfAnOccurence);
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

    private static int binarySearch(int start, int end, int[] numbers, int numberToFind) {
        int mid = (start+end) /2 ;
        if(mid > end || mid <start) {
            return -1;
        }
        if(numbers[mid] == numberToFind) {
            return mid;
        }else if (numbers[mid] > numberToFind) {
            return binarySearch(start, mid-1, numbers, numberToFind);
        }
        else {
            return binarySearch(mid+1, end, numbers, numberToFind);
        }
    }
    
    
}
