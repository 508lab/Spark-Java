## Spark Java api的学习

- ## 开发环境
    - ### 主机: ubuntu16.04
    - ### jdk: java8
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
    1. 下载示例代码: https://github.com/schizobulia/Spark-Java
    
    2. git reset 69babb84a5d88b5a986d2d368a54645aa8ef03ef    之后使用idea将项目打包为jar文件

    3. 验证jar文件中是否包含： jar tf spark.jar | grep Simple.class  (如果没有请查看打包过程是否正确)

    4. zip -d spark.jar META-INF/*.RSA META-INF/*.DSA META-INF/*.SF  (默认idea打包好像会将MEIA-INF目录打包进去)

    5. YOUR_SPARK_HOME/bin/spark-submit --class "SimpleApp" --master **local**[4] spark.jar

    6. 看到输出 Lines with a: ... 的字样即成功
```

### 目录
 1. [Spark-sql](https://github.com/schizobulia/Spark-Java/tree/c40a605f9aff1e0daf501506b0ee07890cb32c74)
 2. [Spark-ElasticSearch](https://github.com/schizobulia/Spark-Java/tree/77ba7c9f6e7d6e2a6b807227858f6f6fc753b124)
 3. [Spark-Streaming](https://github.com/schizobulia/Spark-Java/tree/58685e2b8a5a01743d1f1354933522f072c28e69)


### 说明
    1. 每个commit都是可以运行的Demo.(请注意commit说明)

#### 持续更新...
    

