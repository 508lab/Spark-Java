package com.spark;

import org.apache.spark.sql.*;
import java.util.ArrayList;
import java.util.List;



public class SparkSqlServer {
    private SparkSession sparkSession = null;

    public SparkSqlServer(SparkSession session){
        sparkSession = session;
    }

    /**
     * �����json�ļ�ʹ��sql���˲������µ��ļ�
     * @param files  �ļ�·��
     * @param sql    sql���
     * @param output ����ļ���·��
     * @throws AnalysisException
     */
    public void parsingMoreJson(List<String> files, String sql, String output) throws AnalysisException {
        Dataset<Row> list = null;
        List<Row> list1 = new ArrayList<Row>();
        for (int i = 0; i < files.size(); i++) {
            Dataset<Row> dataset = this.sparkSession.read().json(files.get(i));
            list1.addAll(dataset.collectAsList());
            if (list == null){
                list = dataset;
            }
        }
        Dataset<Row> dataFrame = sparkSession.createDataFrame(list1, list.schema());
        dataFrame.createTempView("qs");
        sparkSession.sql(sql).write().json(output);
    }
}
