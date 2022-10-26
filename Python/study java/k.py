def available_feature(max_cost, kl, holiday_data):
    res = []
    def check(tempprm):
        if set(kl).issubset(set(tempprm)):
            return True

    [res.extend(i[0]) for i in holiday_data if i[1] <= max_cost and (check(i[2]))]
    return res
    
ha = [['a',45,['q','w','e']],['b',60,['e']]]
print(available_feature(100,['e'],ha))