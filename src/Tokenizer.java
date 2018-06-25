import java.util.*;

public class Tokenizer {
	/**
	 * split string
	 * @param array1
	 * @return tokenizer_array
	 */
	public String[][] tokenizer(String []array1)
	{
		int j=0,k=0,i=0;
		String [][] tokenizer_array=new String[200][200];
		
		while(array1[k]!=null){
	 StringTokenizer st = new StringTokenizer(array1[k],"\t");
	 while (st.hasMoreTokens()) {
	     tokenizer_array[i][j++]=st.nextToken();
	 }
	 k++;
	 j=0;
	 i++; 
		}	
		return tokenizer_array;
		 
	}
}
