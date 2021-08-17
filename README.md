# Finding average number of words in all the comments in a data set
### Mapper Function
In the mapper function we first tokenize entire data and then find first occurrence of ‘Text=”’ which signifies the beginning of the comment and then count number of words in the 
comment until ‘”’ is found which signifies end of comment. 

### Reducer function
Length of each comment is sent to reducer with one single standard key – ‘key’.
Reducer sums each value and counts number of values which depicts total number of comments. The sum is divided by number of comments which gives us the average which is sent back to main main and displayed. 

# Files included:
Code can be found in the .java files, while complete .jar file is also available

# Screenshots of output
Find below screenshot of testrun:

* **INPUT** - In the picture shown below, 11 rows were given as input so the average length given by Hadoop 
MapReduce could be manually checked


![task2-testoutput](https://user-images.githubusercontent.com/81144220/129814677-2526332a-ae41-441e-a8da-72d988c4b02c.JPG)

* **OUTPUT** - As we can see total number of words in each comment is divided by total number of comments, giving 
us the answer 33.

![task2-testinput](https://user-images.githubusercontent.com/81144220/129814600-d95f9e1b-f9ef-4297-aa3c-aa68b9a8d697.JPG)
