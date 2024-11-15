package tn.foyer.mohamedbenmohamedtpfoyer.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class FoyerAspects {
    @Before("execution(* tn.foyer.mohamedbenmohamedtpfoyer.Services..*.*(..))")
    public void method(JoinPoint jp){
        log.info("hello "+ jp.getSignature().getName());
    }

    @After("execution(* tn.foyer.mohamedbenmohamedtpfoyer.Services..*.add*(..))")
    public void method2(JoinPoint jp){
        log.info("BYE "+ jp.getSignature().getName());
    }
}
