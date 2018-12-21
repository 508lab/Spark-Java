## Spark Java api的学习

- ## 开发环境
    - ### 主机: ubuntu16.04
    - ### 开发工具: idea-2018.2.4
    - ### Spark: spark2.4


- ## 下载并运行
```
    1.下载：wget https://www.apache.org/dyn/closer.lua/spark/spark-2.4.0/spark-2.4.0-bin-hadoop2.7.tgz

    2.解压：tar zxvf spark-2.4.0-bin-hadoop2.7.tgz

    3.运行：./spark-2.4.0-bin-hadoop2.7/sbin/start-master.sh

    4.打开：http://localhost:8080/   看到关于Spark Master的字样即表示成功。
```



- ## 运行官方示例
```
    1. 示例代码为 src/main/java/SimpleApp.java
    
    2. 之后使用idea将项目打包为jar文件

    3. 验证jar文件中是否包含： jar tf spark.jar | grep Simple.class  (如果没有请查看打包过程是否正确)

    4. zip -d spark.jar META-INF/*.RSA META-INF/*.DSA META-INF/*.SF  (默认idea打包好像会将MEIA-INF目录打包进去)

    5. YOUR_SPARK_HOME/bin/spark-submit --class "SimpleApp" --master local[4] spark.jar

    6. 看到输出 Lines with a: ... 的字样即成功
```

#### 持续更新...
    

