package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.CurrentRange;

public class CurrentRangeTestSuite {
	

	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
    public void setup() { 
		System.setOut(new PrintStream(outputStreamCaptor));		
	}

	 @Test
	    public  void givenReadings_whenIsEmpty_thenTrue() {
				//given
		 		List<Integer> list =new ArrayList<>();
		 		CurrentRange currentRange = new CurrentRange(list);
		 		
				//when
		 		boolean actualValue = currentRange.isEmpty();
				//verify
				assertTrue(actualValue);
		    }
	 
	@Test
	    public  void givenReadings_whenDetectAndCountReadingsInRange_thenGetExpectedOutput() {
				//given
		 		Integer[] arr = {3, 3, 5, 4, 10, 11, 12};
		 		List<Integer> list = Arrays.asList(arr);
		 		CurrentRange currentRange = new CurrentRange(list);
		 		
				//when
		 		currentRange.detectAndPrintReadingsInRange();
				//verify
		 	assertTrue(outputStreamCaptor.toString()
			      .trim().equals("Range, Readings\r\n" + 
			      		"3-5, 4\r\n" + 
			      		"10-12, 3"));
		    }
	 
	 @Test
	    public  void givenNoReadings_whenDetectAndCountReadingsInRange_thenGetExpectedOutput() throws IOException {
				//given
		 		Integer[] arr = {};
		 		List<Integer> list = Arrays.asList(arr);
		 		CurrentRange currentRange = new CurrentRange(list);
				//when
		 		currentRange.detectAndPrintReadingsInRange();
				//verify
		 		assertEquals(outputStreamCaptor.toString()
			      .trim(),"Range, Readings");
		    }
	 
	 @Test(expected = IllegalArgumentException.class)
	    public  void givenNullReadings_whenDetectAndCountReadingsInRange_thenGetExpectedOutput() throws IOException {
				//given
		 		CurrentRange currentRange = new CurrentRange(null);
				//when
		 		currentRange.detectAndPrintReadingsInRange();
		    }
}
