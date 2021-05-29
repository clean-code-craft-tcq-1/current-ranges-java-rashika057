package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrentRange {
	List<Integer> currentReadingList;
	public CurrentRange(List<Integer> list) {
		this.currentReadingList = list;
	}

	public boolean isEmpty() {
		return this.currentReadingList.isEmpty();
	}

	public void detectAndPrintReadingsInRange() {
		List<Integer> readingsInSequence = new ArrayList<>();		
		printOutPutHeading();
		this.currentReadingList.forEach(reading -> {
			if(readingsInSequence.isEmpty() || Math.abs(readingsInSequence.get(readingsInSequence.size()-1) - reading) <=2) {
				readingsInSequence.add(reading);
			}
			else {
				formatandSendMessageForPrinting(readingsInSequence);
				readingsInSequence.clear();
				readingsInSequence.add(reading);
			}
		});
		formatandSendMessageForPrinting(readingsInSequence);
		}
	
	private void formatandSendMessageForPrinting(List<Integer> readingsInSequence) {
		if(!readingsInSequence.isEmpty()) {
		Collections.sort(readingsInSequence);
		printReadingsinRange(readingsInSequence.get(0)+"-"+readingsInSequence.get(readingsInSequence.size()-1)+", "+Integer.toString(readingsInSequence.size()));
		}
		}

	private void printReadingsinRange(String readingsInSequence) {
		System.out.println(readingsInSequence);
	}
	private void printOutPutHeading() {
	System.out.println("Range, Readings");
	}

}
