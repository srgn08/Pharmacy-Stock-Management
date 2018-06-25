import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author Sergen
 * @since 07.03.2016
 *
 */

public class Main {
	public static void main(String[] args) throws ParseException  {
		
		
		/**
		 * define 2 array
		 */
	    String [] array1=new String[200];
	    String [] array2=new String[200];
	    /**
	     * define 2 array medicaments and prescription
	     */
	    String [][] medicaments=new String[200][200];
	    String [][] prescription=new String[200][200];
	    
	    /**
	     * args[1] is medicaments.txt
	     * args[0] is prescription.txt
	     */
		ReadFromFile read=new ReadFromFile(array1,args[1]);
		ReadFromFile read2=new ReadFromFile(array2,args[0]);
		    int x=0;
		    /**
		     * go tokenizer class and split string
		     */
			Tokenizer t=new Tokenizer();
			medicaments=t.tokenizer(array1);
			prescription=t.tokenizer(array2);
			Medicaments[] medical=new Medicaments[1000];
			String[] temp=new String[100];
			String[] temp2=new String[100];
			int v=0;
			int i=0;
			int value1=0;	
			while(medicaments[i][v]!=null)
			{		
					medical[x++]=new Medicaments(medicaments[i][v],medicaments[i][v+1],medicaments[i][v+2],
							medicaments[i][v+3],
							Double.parseDouble(medicaments[i][v+4]));
					v=0;
					i++;
					value1++;
			}
			Prescription p;
			p=new Prescription(prescription[0][0],prescription[0][1],prescription[0][2]);
			int y=0;
			int s=0;
			
			/**
			 * temp keep medicament name
			 * temp2 keep quantity
			 */
			while(prescription[y++][0]!=null)
			{
				temp[s]=prescription[y][0];
				temp2[s]=prescription[y][1];
				s++;	
			}
			int p1=0,p2=0,p3=0,p4=0;
			double[] min=new double[30];
			String date1,date2,date3;
			int newDate1,newDate2,newDate3;
			int control=0;
			double last=1000.0;
			
			while(temp[p1]!=null){	
				while(control<value1)	
				{
					if(temp[p1].equals(medical[p2].getMedicament_name() ))
					{
							if(medical[p2].getSocial_security().equals(p.getSocial_security()))
							{
								 date1=p.getDate();
								 date2=medical[p2].getEffective_date();
								 date3=medical[p2].getExpiry_date();
								 String a1=parseDate(date1);
								 String a2=parseDate(date2);
								 String a3=parseDate(date3);
								 newDate1=Integer.parseInt(a1);
								 newDate2=Integer.parseInt(a2);
								 newDate3=Integer.parseInt(a3);
								 
								 if(newDate1>newDate2 && newDate1<newDate3 && medical[p2].getPrice()<last)
								 {
									 last=medical[p2].getPrice();
									 
								 }
								 min[p3]=last;
							}					
					}
					p2++;
					p4++;
					control++;
				}
				p2=0;
				p1++;
				p3++;
				last=1000;
				control=0;		
			}
			int control2=0;
			double[] result=new double[100];
			
			while(temp[control2]!=null)
			{
				result[control2]=min[control2]*Integer.parseInt(temp2[control2]);
				control2++;
			}
			
			control2=0;
			/**
			 * decimal format turn dot instead of comma
			 */
			DecimalFormat df = new DecimalFormat("#.##");
			String formatted;
			while(temp[control2]!=null)
			{
				System.out.print(temp[control2]+"\t"+ min[control2]+ "\t"+
			temp2[control2]);
				formatted=String.format("%.2f",result[control2]);
				formatted = formatted.replace(",", ".");
			System.out.println("\t"+formatted);
				control2++;
			}
			int control3=0;
			float output=0;
			while(control2>control3)
			{
				output+=result[control3];
						control3++;
			}		
			System.out.print("Total\t");
			String formatted2=String.format("%.2f",output);	
			formatted2 = formatted2.replace(",", ".");
			System.out.println(formatted2);
		    }
			
	/**
	 * 
	 * @param prescription
	 * @return traversal date but not use dot(.)
	 * @throws ParseException
	 */
			public static String parseDate(String prescription ) throws ParseException
			{
				String strDate = prescription;
		        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		        Date dateStr = formatter.parse(strDate);
		        String formattedDate = formatter.format(dateStr);
		        Date date1 = formatter.parse(formattedDate);

		        formatter = new SimpleDateFormat("yyyy.MM.dd");
		        formattedDate = formatter.format(date1);
		       
		        formattedDate=formattedDate.replaceAll("\\.","");
		        return formattedDate;
			}
		}