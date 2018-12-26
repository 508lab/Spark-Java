/* SimpleApp.java */
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;
import org.elasticsearch.spark.sql.api.java.JavaEsSparkSQL;

/**
 * Spark官方文档: https://spark.apache.org/docs/latest/sql-getting-started.html
 * ElasticSearch官方文档: https://www.elastic.co/guide/en/elasticsearch/hadoop/current/spark.html
 */

public class SimpleApp {
    public static void main(String[] args) {

        /**
         * sql from ElasticSearch
         * ElasticSearch客户端是白金会员好像才可以连接...
         */
        SparkConf sparkConf = new SparkConf()
                .setAppName("writeEs").setMaster("local[*]")
                .set("es.index.auto.create", "true")
                .set("es.nodes", "url")
                .set("es.port", "prot").set("es.nodes.wan.only", "true");
        SparkSession sparkSession = SparkSession.builder().config(sparkConf).getOrCreate();
        SQLContext sql = new SQLContext(sparkSession);
        Dataset<Row> info = JavaEsSparkSQL.esDF(sql, "users");
        info.show();
    }
}