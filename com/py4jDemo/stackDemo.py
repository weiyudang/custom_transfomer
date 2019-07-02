from py4j.java_gateway import  JavaGateway,java_import
from py4j.java_collections import   ListConverter
gateway=JavaGateway()

stack=gateway.entry_point.getStack()

stack.push("First")
stack.push("Second")
stack.push("wyd")

# print stack.pop()
internal_list=stack.getInternalList()

print  len(internal_list)
print internal_list[0]
internal_list.append("200")
print internal_list
print type(internal_list
)

# gateway.help(stack)
java_list=gateway.jvm.java.util.ArrayList()
java_list.append(244)
java_list.append(120)
gateway.jvm.java.util.Collections.sort(java_list)

print  java_list


# Array
int_class=gateway.jvm.int
int_array=gateway.new_array(int_class,2)
int_array[0]=10
int_array[1]=20

#
# for o in int_array:
#         print o

string_class= gateway.jvm.java.lange.String
# sarray=gateway.new_array(string_class,2,3)
sarray = gateway.new_array(gateway.jvm.java.lang.String,2,3)
len(sarray)

student=gateway.entry_point.getStudentInstance()

# gateway.help(student)

print(student.study())
print(student.sum(1,2))

a=[2,34,1,324]
java_a=ListConverter().convert(a,gateway._gateway_client)
print student.sort(java_a)



