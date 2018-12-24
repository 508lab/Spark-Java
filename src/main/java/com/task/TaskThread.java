package com.task;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class TaskThread extends Thread {
    private SparkSession spark = null;
    private String filePath = "";
    public TaskThread(SparkSession spark, String filePath){
        super();
        this.spark = spark;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        Dataset<Row> df = spark.read().json(filePath);
        df.show();
    }
}
