
tab1 = {key1="val1",key2="val2","val3"}

for k, v in pairs(tab1) do
    print(k .. "-" .. v)
end


print("========")
tab1.key1 = nil

for i, v in pairs(tab1) do
    print(i .. "-" .. v)
end



print(type(x))
print(type(x)==nil)
print(type(x)=='nil')
print(type(x)=="nil")
