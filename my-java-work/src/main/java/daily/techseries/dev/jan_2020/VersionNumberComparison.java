package daily.techseries.dev.jan_2020;

public class VersionNumberComparison {

	public static void main(String[] args) {

		String version1 = "1.0.33";
		String version2 = "1.0.27";
		String[] version1_splits = version1.split(".");
		String[] version2_splits = version2.split(".");
		int length = version1_splits.length >= version2_splits.length ? version1_splits.length : version2_splits.length;
		int i=0;
		for(;i<length;i++){
			int version1_int = getValue(version1_splits,i);
			int version2_int = getValue(version2_splits,i);
			if(version1_int > version2_int){
				System.out.println("version1 > version2");
				break;
			}
			else if(version1_int < version2_int){
				System.out.println("version2 > version1");
				break;
			}
		}
		if(i==length){
			System.out.println("version1 = version2");
		}
	}

	private static int getValue(String[] version1_splits, int i) {
		int temp;
		try{
			temp = Integer.valueOf(version1_splits[i]);
		}
		catch(IndexOutOfBoundsException e){
			temp=0;
			version1_splits[i]="0";
		}
		
		return temp;
	}

}
