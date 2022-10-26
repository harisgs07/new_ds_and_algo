# won't work for zeros

def a(arr):
    tryLeft = []
    tryRight = []
    prodLeft = 1
    ProdRight = 1
    tryLeft.append(1)
    tryRight.append(1)
    for i in range(1,len(arr)):
        tryLeft.append(arr[i-1]*prodLeft)
        prodLeft = arr[i-1]*prodLeft
    for i in range(len(arr)-1,-1):
        print(arr[i])
        tryRight.append(arr[i]*ProdRight)
        ProdRight = arr[i+1]*ProdRight
    # for j in tryRight:
    #     print(j)
    # for i in range(0,len(arr)):
    #     print(tryLeft[i] * tryRight[i])


aa = [4,3,2,1]
a(aa)