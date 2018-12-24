/* SimpleApp.java */

// $example on:schema_merging$

import com.task.TaskThread;
import com.until.FileTool;
import org.apache.spark.sql.SparkSession;
import java.util.List;

/**
 * 官方文档: https://spark.apache.org/docs/latest/sql-getting-started.html
 */

public class SimpleApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local[2]")
                .appName("Java Spark SQL basic example")
                .getOrCreate();
        String fileRootPath = System.getProperty("user.dir") + "/resources/";
        List<String> files = FileTool.getFileByPath(fileRootPath);
        for (int i = 0; i < files.size(); i++) {
            new TaskThread(spark, fileRootPath + files.get(i)).start();
        }

    }
}