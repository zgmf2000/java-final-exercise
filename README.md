# Java Final Exercise

This is a utility application focusing on files. The following functions are available:
1. Comparing two files.
    * To use this function, use the following method: _fileOperation(2, filename1, filename2)_. Of course, filename1 and filename2 must be present in order for this function to succeed.
    * This function will print whether the files are a match or not in the console.
2. Copying a file.
    * To use this function, use the following method: _fileOperation(1, filename1, filename2)_. Filename1 as the source file must be present.
    * filename1 is the source file, whereas filename2 is the destination file.
3. Viewing file information.
    * To use this function, use the following method: _fileOperation(3, filename1)_. Filename1 must be present or the function will fail.
    * This function will print useful information into the console such as filename, location, size, and last modified time.
4. Counting the number of words in a file.
    * To use this function, use the following method: _fileOperation(4, filename1)_. Filename1 must be present or the function will fail.
    * This function will print the number of words written in the file. Unexpected behavior is bound to happen if the filename1 is not a text file.
