package hob.spring.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LogAspect {
    private val logger = LoggerFactory.getLogger(LogAspect::class.java)

    @Around("execution(* hob.spring.controller.*.*(..))")
    @Throws(Throwable::class)
    fun logging(pjp: ProceedingJoinPoint): Any {
        logger.info("connenct in : ${pjp.signature.declaringTypeName} -> ${pjp.signature.name}") // 함수 실행 전
        val result = pjp.proceed() // 함수 실행
        logger.info("connenct out : ${pjp.signature.declaringTypeName} -> ${pjp.signature.name}") // 함수 실행 후
        return result
    }
}