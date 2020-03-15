package model;

public class SampleSearch {

	public static void main(String[] args) {
		String resultSearch="yuriko android";
		String wordFromDB="初心者に優しいandroidあぷりの公開の手順、初めてのりりいすに大苦戦⁈java,android,androidあぷりyuriko";

		resultSearch = resultSearch.replace(" ", ")(?=.*");

		boolean isMatches=wordFromDB.matches("^(?=.*"+resultSearch+").*$") ;
		System.out.println(isMatches);

		if (wordFromDB.matches("^(?=.*"+resultSearch+").*$") ){

			System.out.println("追加");
		}

	}

}
