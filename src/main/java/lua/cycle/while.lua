
local a = 0

while a < 10
do
    print(a)
    a= a +1
end


--while true do
--    print("true")
--end

for i = 1, 10,2 do
    print(i)
end

print("--------")
for i = 10, 1,-1 do
    print(i)
end

print("--------")

function fa(x) 
    return x*2;
end

for i = 1, fa(10) do
    print(i)
end

print("---------")

local ta = {"one","two","three"}
for i, v in ipairs(ta) do
    print(i,v)
end

