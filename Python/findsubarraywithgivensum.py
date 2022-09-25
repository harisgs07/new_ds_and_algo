arr = [10,15,-5,15,-10,5]
sum = 5
mapping={}
def givensumarr(arr, sum):
    for i in arr:
        if i == sum:
            start = end = arr.index(i)
            return start, end
        else:
            # if i  not in mapping.keys():
            mapping[i] = [arr.index(i),0,arr.index(i)-1]
        for j in mapping.keys():
            mapping[j][1] = mapping[j][1]+ i
            mapping[j][2] = mapping[j][2]+ 1
            if mapping[j][1] == sum:
                print(mapping)
                return mapping[j][0], mapping[j][2]
        print(mapping)
        if arr.index(i) == len(arr)-1:
            return -1, -1

start, end = givensumarr(arr, sum)
print( start)
print(end)