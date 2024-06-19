package com.gianpc.restapis.utils.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLogginAspect {

    // tu auditLoggable eres padre de todoservice y todotypeservice
    @DeclareParents(value = "com.gianpc.restapis.services.*", defaultImpl = AuditLoggableImpl.class)
    public static AuditLoggable auditLoggable;
}
