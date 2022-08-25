res = 0
k=3
n = 1
while(True):
    if (n == 8):
        break
    else:
        # //goes circle (1+)
        res = (res+k)%n
        print(res)
        n = n+1
print(res)
