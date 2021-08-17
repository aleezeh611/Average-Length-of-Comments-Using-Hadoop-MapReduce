
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AvgCommentReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
      int sum = 0;
      int totalrecords = 0;
      for (IntWritable val : values) {
        sum += val.get();
        totalrecords += 1;
      }
      int avg = sum/totalrecords;
      result.set(avg);
      Text ans = new Text("AVERAGE LENGTH OF COMMENTS: ");
      context.write(ans, result);
    }
}