from collections import OrderedDict

def filter_max_length(list, max):
    for item in list:
        if item[1]==max:
            yield item

class Item:
    def __init__(name, length):
        this.name = name
        this.length = length


t = int(input())  # read a line with a single integer
names_length_dict={}

result=[]
for i in range(1, t + 1):
    how_many_names = input()
    for _ in range(int(how_many_names)):
        name=input()
        processed_name=name.replace(" ","")
        names_length_dict[name] = len(set(processed_name))
    ordered_name_length_dict=sorted(names_length_dict.items(), key=lambda x:x[1], reverse=True)
    max_length=ordered_name_length_dict[0][1]
    print(ordered_name_length_dict)


    for value in Orderedmax_name_length_list:
        print(value)
    # print(value for value in max_name_length_list)
    # sorted_name=sorted(list(names.keys()))
    # result.append('Case #'+str(i)+': '+list(names.keys())[0])

with open("small_result", 'w') as f:
    for item in result:
        f.write(item + '\n')
