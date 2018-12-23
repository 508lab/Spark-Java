/* SimpleApp.java */

// $example on:schema_merging$

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.List;

/**
 * https://spark.apache.org/docs/latest/sql-getting-started.html
 */

public class SimpleApp {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local[2]")
                .getOrCreate();
        List<String> jsonData = Arrays.asList(
                "{\"name\":\"Yin\",\"address\":{\"city\":\"Columbus\",\"state\":\"Ohio\"}}");
        Dataset<String> anotherPeopleDataset = spark.createDataset(jsonData, Encoders.STRING());
        Dataset<Row> anotherPeople = spark.read().json(anotherPeopleDataset);
        anotherPeople.show();
        String filePath = System.getProperty("user.dir") + "/resources/people.json";
        Dataset<Row> fileDataset = spark.read().json(filePath);
        fileDataset.printSchema();
    }
}