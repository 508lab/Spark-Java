import org.apache.spark.sql.SparkSession;

public class SimpleApp {
    public static void main(String[] args){
        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();

    }

}
