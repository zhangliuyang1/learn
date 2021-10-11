--[[
nil 为 false
数字0为 true
--]]

print(type(true))
print(type(false))
print(type(nil))

if false or nil then
    print("at least true")
else
    print("false and nil all false")
end

if 0 then
    print("0 is true")
else
    print("0 is false")
end