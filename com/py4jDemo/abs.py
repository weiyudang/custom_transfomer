# coding:utf-8
from py4j.java_gateway import JavaGateway, java_import

#  将自定义的jars 放在spark home jars 中，
# java -cp py4jDemo-1.0-SNAPSHOT.jar:ml-1.0-SNAPSHOT.jar:.  -Djava.ext.dirs=/Users/weiyudang/software/spark/jars   -jar py4jDemo-1.0-SNAPSHOT.jar
gateway = JavaGateway()
java_import(gateway.jvm, "org.apache.spark.ml.feature.Abs")
dd = gateway.jvm.Abs()
gateway.help(dd)
