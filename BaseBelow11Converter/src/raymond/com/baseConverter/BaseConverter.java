package raymond.com.baseConverter;

public class BaseConverter {


	
    //only works for bases <= 10
    
    public int baseConverter(int wantedBase, int givenNum, int givenBase) 
    { 
        if (givenNum == 0)  
        {
        	return 0;
        }
              
        //the multiplication by the given base here shifts the number one digit to the left, ready for the next digit to be added on
        else
        {
        	return (givenNum % wantedBase + givenBase * baseConverter(wantedBase,(givenNum / wantedBase), givenBase));
        }
       
        	 
    }

}
