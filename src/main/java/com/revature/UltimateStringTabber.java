package com.revature;

import java.util.List;

public class UltimateStringTabber {
    public static List<String> tabColumn(List<String> stringList, boolean makeBars) {

		// Optional decorative bars
		if (makeBars) {
			for (int i = 0; i < stringList.size(); i++) {
				stringList.set(i, "| " + stringList.get(i));
			}
		}
		
		// The tab size in my console is 8 characters
		int tabSize = 8;
		int maxSize = 0;
		
		// Find the length of the longest string in the list
		for (String string : stringList) {
			if (string.length() > maxSize) {
				maxSize = string.length();
			}
		}
		// Find the number of tabs needed to reach that length
		int tabLength = maxSize / tabSize;
		for (int i = 0; i < stringList.size(); i++) {
			String currString = stringList.get(i);
			int tabDiff = tabLength - (currString.length() / tabSize);
			for (int x = 0; x < Math.max(0, tabDiff); x++) {
				// Tab string up to the block the longest one is in
				currString += "\t";
			}
			// Add one more tab so everything aligns
			currString += "\t";
			stringList.set(i, currString);
		}
		return stringList;
	}
}
