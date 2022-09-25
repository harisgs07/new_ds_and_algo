print(mapping)
        for j in mapping.keys():
            mapping[j][1] = mapping[j][1]+ i
            mapping[j][2] = mapping[j][2]+ 1
            if mapping[j][1] == sum:
                return mapping[j][0], mapping[j][2]