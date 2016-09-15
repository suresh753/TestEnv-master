from exceptions import Exception
lines=[]
total=0
fail=0
Req_Test_Per = 50
with open ('TEST-TestEnvTestCases.txt','rt') as in_file:
    for line in in_file:
        lines.append(line.rstrip('\n'))
index = 0
for element in lines:
    substr = "Tests run:"
    index = element.find(substr, index)
    if index>0:
        total_start = element.find(':',index)
        total_end = element.find(',',total_start)
        fail_start=element.find(':',total_end)
        fail_end = element.find(',',fail_start)
        total=int(element[total_start+2:total_end])
        fail=int(element[fail_start+2:fail_end])
        break
    index=0
print("TestCases Run :" +str(total))
print("Failures :" +str(fail))
Out_Per = (float(total-fail)/total)*100
print("Percentage :"+str(Out_Per)+"%")

if  Out_Per >= Req_Test_Per:
    print ("Passed for deploying in testenv")
else:
    raise Exception("build failed because of Required Percentage "+str(Req_Test_Per)+"%")
