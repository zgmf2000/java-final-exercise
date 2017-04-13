import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class FileComparatorTest {

	@Test
	public void getFileContent() {
		Assert.assertNotNull("File not found!", FileComparator.getFileContent("testfiles/sample.txt"));
	}
	
	@Test
	public void compareFile() {
		Assert.assertTrue(FileComparator.compareFile("testfiles/sample.txt", "testfiles/sample-match.txt"));
		Assert.assertFalse(FileComparator.compareFile("testfiles/sample.txt", "testfiles/sample-wrong.txt"));
	}
	
	@Test
	public void wordCount() {
		Assert.assertEquals(134, FileComparator.wordCount("testfiles/sample.txt"));
	}

}
