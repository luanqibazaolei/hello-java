package com.shen.asp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

@Aspect
@Configuration
public class aspect {

    private static final Logger log = LoggerFactory.getLogger(aspect.class);


    @Pointcut("execution(public * com.shen.asp.controller..*.*(..)))")
    public void webLog(){}

    @Before(value = "webLog()")
    public void before(JoinPoint joinPoint) {


        log.info("\n\n----------------- before start -------------");
        // 获取目标方法参数信息
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            log.info("目标方法参数信息:");
            Arrays.stream(args).forEach(arg -> {
                Optional.ofNullable(arg).ifPresent(a -> log.info(a.toString()));
            });
        }

        // 获取 AOP 代理对象：CGLib代理和JDK动态代理
        log.info("AOP 代理对象:");
        Object thisObj = joinPoint.getThis();
        log.info("-" + thisObj.getClass().getName() + ":" + thisObj.toString());

        // 获取被代理的目标对象
        log.info("被代理的目标对象:");
        Object object = joinPoint.getTarget();
        log.info("-" + object.getClass().getName() + ":" + object.toString());

        // 获取连接点Joint Point类型
        log.info("连接点Joint Point类型:");
        String kind = joinPoint.getKind();
        log.info("-" + kind);// -method-execution

        // 获取连接点的方法签名对象
        log.info("连接点的方法签名对象:");
        Signature signature = joinPoint.getSignature();
        log.info("-" + signature.toLongString());
        log.info("-" + signature.toShortString());
        log.info("-" + signature.toString());
        log.info("-方法名:" + signature.getName());
        log.info("-获取声明类型 方法所在类的class对象" + signature.getDeclaringType().toString());
        log.info("-获取声明类型名" + signature.getDeclaringTypeName());

        // 获取连接点方法所在类文件中的位置 打印报异常
        log.info("连接点方法所在类文件中的位置:");
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        log.info("-" + sourceLocation.toString());
        // log.info("-" + sourceLocation.getFileName());
        // log.info("-" + sourceLocation.getLine() + "");
        // log.info("-" + sourceLocation.getWithinType().toString());

        // 返回连接点静态部分
        log.info("连接点静态部分:");
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        log.info("-" + staticPart.toLongString());// execution(public com.lzq.selfdiscipline.business.bean.MessageBean com.lzq.selfdiscipline.business.controller.UserFileManagerController.queryFiles(java.lang.String,java.lang.Integer,java.lang.Integer))

        // attributes可以获取request信息 session信息等
        log.info("request信息:");
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("-" + request.getRequestURL().toString());
        log.info("-" + request.getRemoteAddr());
        log.info("-" + request.getMethod());
        log.info("-" + request.getParameterMap().toString());
        log.info("----------------- before end -------------");
    }


}


