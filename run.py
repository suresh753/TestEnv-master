lines=[]
total=0
fail=0
with open ('/home/ec2-user/.jenkins/jobs/TestEnv/lastSuccessful/log','rt') as in_file:
    for line in in_file:
        lines.append(line.rstrip('\n'))
index = 0
for element in lines:
    substr = "Tests run:"
    index = element.find(substr, index)
   # print(index)
    if index>0:
        total=int(element[23:25])
        fail=int(element[37:38])
        break
    index=0
print("TestCases Run :" +str(total))
print("Failures :" +str(fail))
percentage = (float(total-fail)/total)*100
print("Percentage :"+str(percentage)+"%")
