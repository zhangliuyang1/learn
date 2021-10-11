function f1(a,b)
    return a+b
end

print(f1(1,1))

function f2(c,d)
    return c+d(1)
end

print(f2(2,function(e)
    return e+1;
end));