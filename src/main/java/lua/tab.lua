local a = {}
local b = {"red","black","green","peer"}

print(a)
print(b)
for k, v in pairs(a) do
    print("table a: " .. k .. "=" .. v)
end

for k, v in pairs(b) do
    print("table b: " .. k .. "=" .. v)
end


a["name"]="zly"
key=10
a[key]=30
a[key] = a[key] + 10
for k, v in pairs(a) do
    print(k .. ':' .. v)
end

c={}
for i = 1, 10 do
    c[i]=i
end
for k, v in pairs(c) do
    print(k .. ":" .. v)
end

print("==========")


d={nn='1',mm='2'}
for k, v in pairs(d) do
    print(k .. "=" .. v)
end

print("=========")

local map={name='sss',age=10}

for i, v in pairs(map) do
    print(i .. "=" .. v)
end