res = 0
k=4
max = 7
n =1
while(True):
    if (n > max):
        break
    else:
        res = (res+k)%n
        print(res)
        n = n+1
print(res)
