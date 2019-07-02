from  py4j.java_gateway import  JavaGateway

gate=JavaGateway()
gate.launch_gateway(jarpath='./test2.jar',classpath='test2.jar')

gate
