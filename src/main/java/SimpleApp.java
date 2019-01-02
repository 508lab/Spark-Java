/* SimpleApp.java */


import com.spark.SparkSqlServer;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Spark官方文档: https://spark.apache.org/docs/latest/structured-streaming-programming-guide.html
 */

public class SimpleApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local[2]")
                .appName("Java Spark SQL basic example")
                .getOrCreate();
        List<String> list = new ArrayList<String>();
        list.add("/home/ubuntu/Documents/a.json");
        list.add("/home/ubuntu/Documents/b.json");
        try {
            new SparkSqlServer(spark).parsingMoreJson(list, "select * from qs",
                    "/home/ubuntu/sql");
        } catch (AnalysisException e) {
            e.printStackTrace();
        }

    }
}