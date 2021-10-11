local te = {1,2,a=3,4}
for i, v in ipairs(te) do
    print(i,v)
end
print("-------")
for i, v in pairs(te) do
    print(i,v)
end

print("-------")
local tg = {key1="1",key2="2",key3="3",5,6,nil,key4=nil,8,9}
for i, v in ipairs(tg) do
    print(i,v)
end
print("-------")
for i, v in pairs(tg) do
    print(i,v)
end