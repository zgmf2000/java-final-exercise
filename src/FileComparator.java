import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileComparator {

    public static Stream<String> getFileContent(String filename)
    {
        Stream<String> content;
		try 
		{
			content = Files.lines(Paths.get(filename));
			return content;
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.printf("EXCEPTION: %s", e);
			return null;
		}
    }
    
    public static boolean compareFile(String filename1, String filename2)
    {
    	List<String> content1 = getFileContent(filename1).collect(Collectors.toList());
    	List<String> content2 = getFileContent(filename2).collect(Collectors.toList());
    	
    	return content1.equals(content2);
    }

    public static void copyFile(String newFilename, Stream<String> content)
    {
        try(PrintWriter out = new PrintWriter(Files.newBufferedWriter(Paths.get(newFilename), Charset.defaultCharset())))
        {
        	List<String> res = content.collect(Collectors.toList());
            res.forEach(e -> out.printf("%s%n", e));
        }
        catch(IOException ioe)
        {
            System.out.printf("%s.%n", ioe);
        }
    }
    
    public static void getFileInformation(String filename)
    {
    	Path source = Paths.get(filename);
    	
    	try 
    	{
	    	System.out.printf("Filename: %s%n", source.getFileName());
	    	System.out.printf("File Location: %s%n", source.toAbsolutePath());
			System.out.printf("File Size: %d bytes %n", Files.size(source));
			System.out.println("Last modified on " + new SimpleDateFormat().format(Files.getLastModifiedTime(source).toMillis()));
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			System.out.printf("EXCEPTION: %s", e);
		}
    }
    
    public static int wordCount(String filename)
    {
    	Stream<String> content = getFileContent(filename);
    	return content.mapToInt(e->e.trim().split(" ").length).sum();
    }

    public static void fileOperation(int option, String... filename)
    {
        Stream<String> content = getFileContent(filename[0]);
        switch(option)
        {
            //Copy File.
            case 1:
                copyFile(filename[1], content);
                break;
            //Compare File Contents.
            case 2:
            	if (compareFile(filename[0], filename[1]))
            		System.out.println("Files match!");
            	else
            		System.out.println("Files don't match!");
                break;
            //Show File Information.    
            case 3:
            	getFileInformation("sample.txt");
                break;
            //Count Words in a file.    
            case 4:
            	System.out.printf("There are %d words in %s", wordCount(filename[0]), filename[0]);
            default:
                break;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	fileOperation(1, "sample.txt", "sample-copy.txt");
    	fileOperation(2, "sample.txt", "sample2.txt");
        fileOperation(3, "sample.txt");
    	fileOperation(4, "sample.txt");
    }

}
