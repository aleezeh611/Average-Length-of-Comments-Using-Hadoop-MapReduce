
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AvgCommentMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	   private final static IntWritable comment_length = new IntWritable(1);
	    private Text word = new Text();
	    private Text ig_key = new Text("KEY");
	    
	    
	    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	      StringTokenizer itr = new StringTokenizer(value.toString());
	      int stoploop = 0;
	      int sum = 0;
	    		  
	      while (itr.hasMoreTokens()) {
	        word.set(itr.nextToken());
	        if (word.find("Text=") != -1) {
	        	 while (itr.hasMoreTokens()) {
	        		sum += 1;
	     	        word.set(itr.nextToken());
	     	        if(word.find(Character.toString('"')) != -1 ) {
	     	        	sum += 1;
	     	        	stoploop = 1;
	     	        	break;
	     	        }
	        	 }
	        	 if(stoploop == 1) {
	        		 comment_length.set(sum);
	        		 context.write(ig_key, comment_length);
	        		 break;
	        	 }
	        }
	      }
	    }
}