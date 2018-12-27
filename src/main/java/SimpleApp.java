/* SimpleApp.java */



import org.apache.spark.*;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.streaming.*;
import org.apache.spark.streaming.api.java.*;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Spark官方文档: https://spark.apache.org/docs/latest/structured-streaming-programming-guide.html
 */

public class SimpleApp {
    public static void main(String[] args) throws InterruptedException {

        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream(
                "localhost",  9999, StorageLevels.MEMORY_AND_DISK_SER);
        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
        JavaPairDStream<String, Integer> wordCounts = words.mapToPair(s -> new Tuple2<>(s, 1))
                .reduceByKey((i1, i2) -> i1 + i2);

        wordCounts.print();
        jssc.start();
        jssc.awaitTermination();

    }
}