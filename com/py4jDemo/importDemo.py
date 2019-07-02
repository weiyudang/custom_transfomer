from py4j.java_gateway import  JavaGateway,JavaMember,get_java_class
from py4j.java_gateway import   java_import,find_jar_path

from pyspark.ml.feature import HashingTF
gateway=JavaGateway(auto_convert=True)
java_import(gateway.jvm,"com.autohome.Student")


student=gateway.jvm.Student("weiyduang")

gateway.help(student)


student.show()
a=student.returnValue()
print a
print student.getName()






