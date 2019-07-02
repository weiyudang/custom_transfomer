from py4j.java_gateway import JavaGateway, java_import
from pyspark.sql import SparkSession
from pyspark.ml.feature import HashingTF
from pyspark import since, keyword_only, SparkContext
from pyspark.rdd import ignore_unicode_prefix
from pyspark.ml.linalg import _convert_to_vector
from pyspark.ml.param.shared import *
from pyspark.ml.util import JavaMLReadable, JavaMLWritable
from pyspark.ml.wrapper import JavaEstimator, JavaModel, JavaParams, JavaTransformer, _jvm
from pyspark.ml.common import inherit_doc
from pyspark.ml.feature import Binarizer, HashingTF,VectorAssembler
from pyspark.ml import Pipeline, PipelineModel
from pyspark.ml.classification import   LogisticRegression


@inherit_doc
class Abs(JavaTransformer, HasInputCol, HasOutputCol, HasNumFeatures, JavaMLReadable,
          JavaMLWritable):

    @keyword_only
    def __init__(self, inputCol=None, outputCol=None):
        super(Abs, self).__init__()
        self._java_obj = self._new_java_obj("org.apache.spark.ml.feature.Abs", self.uid)
        kwargs = self.__init__._input_kwargs
        self.setParams(**kwargs)

    @keyword_only
    def setParams(self, inputCol=None, outputCol=None):
        kwargs = self.setParams._input_kwargs
        return self._set(**kwargs)


if __name__ == '__main__':
    sqlContext = SparkSession.builder.master("local").enableHiveSupport().getOrCreate()

    arr = [[1, 2.0], [2, -0.3], [10, 4.0], [12, 78.0], [13, -23.0], [14, 4.0], [15, 100.0]]

    df = sqlContext.createDataFrame(arr).toDF("id", "random")
    df.show()

    # gateway = JavaGateway()

    # stack = gateway.entry_point

    # gateway.help(stack)

    # stack=stack.setInputCol("feature").setOutputCol("abs_feature")
    #
    # jd_df=stack.transform(df._jdf)
    #
    # jd_df.show()

    sc = sqlContext.sparkContext

    gateway = sc._gateway
    # test 1
    java_import(gateway.jvm, "com.autohome.Student")

    student = gateway.jvm.Student("weiyduang")

    gateway.help(student)

    student.show()
    a = student.returnValue()

    # test 2
    java_import(gateway.jvm, "org.apache.spark.ml.feature.Abs")
    dd = gateway.jvm.Abs()
    gateway.help(dd)

    # test 3

    bin_ = Binarizer(threshold=0, inputCol='random', outputCol='bin_feature')
    abs_ = Abs(inputCol='random', outputCol='abs_feature')
    vc=VectorAssembler(inputCols=['random','abs_feature'],outputCol="features")
    lr=LogisticRegression()
    lr.setLabelCol("bin_feature")

    #
    pipline = Pipeline(stages=[bin_, abs_,vc,lr])
    model = pipline.fit(df)
    bin_df = model.transform(df)
    bin_df.show()

    print('load model and save model')
    print("---*-***--" * 20)
    model.write().overwrite().save("./abs.model")


    # save

    # load pipmodel
    models=PipelineModel.load('./abs.model')

    models.transform(df).show()


