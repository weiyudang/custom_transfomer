
from  pyspark.ml.feature  import  Binarizer
def __get_class(clazz):
        """
        Loads Python class from its name.
        """
        parts = clazz.split('.')
        module = ".".join(parts[:-1])
        m = __import__(module)
        for comp in parts[1:]:
                m = getattr(m, comp)
        return m

from pyspark.ml.wrapper import  JavaParams
py_type=__get_class("pyspark.ml.feature.Binarizer")


if issubclass(py_type, JavaParams):
        # Load information from java_stage to the instance.
        py_stage = py_type()
        # py_stage._java_obj = java_stage
        # py_stage._resetUid(java_stage.uid())
        # py_stage._transfer_params_from_java()
=