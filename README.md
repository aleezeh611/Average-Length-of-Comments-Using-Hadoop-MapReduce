# Finding average number of words in all the comments in a data set
### Mapper Function
In the mapper function we first tokenize entire data and then find first occurrence of ‘Text=”’ which signifies the beginning of the comment and then count number of words in the 
comment until ‘”’ is found which signifies end of comment. 

### Reducer function
Length of each comment is sent to reducer with one single standard key – ‘key’.
Reducer sums each value and counts number of values which depicts total number of comments. The sum is divided by number of comments which gives us the average which is sent back to main main and displayed. 
