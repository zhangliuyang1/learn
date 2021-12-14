package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/11/13 下午5:44
 */
@Aspect
@Component
public class LogAspect {

    @Around("execution(* spring.aop.*.*(..))")
    public Object advice(ProceedingJoinPoint point){
        Signature signature = point.getSignature();
        Class declaringType = signature.getDeclaringType();
        String name = signature.getName();
        System.out.println(declaringType.getName() +"@"+name);
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.out.println("finally");
        }

        return result;
    }
}
