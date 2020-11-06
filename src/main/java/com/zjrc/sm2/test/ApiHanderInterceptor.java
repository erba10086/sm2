//package com.zjrc.sm2.test;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.rd.occ.api.model.SCRequest;
//import com.rd.occ.api.model.response.AbstractResponseHead;
//import com.rd.occ.api.util.CodeEnum;
//import com.rd.occ.api.util.CodeUtil;
//import com.rd.occ.api.util.auth.AuthorizationTool;
//
//
///**
// * 风险决策接口授权认证切面类
// * @author wenf.h
// *
// */
//@Aspect
//@Component
//public class ApiHanderInterceptor {
//
//	private ApiHanderInterceptor() {}
//
//	private static final Logger logger = LoggerFactory.getLogger(ApiHanderInterceptor.class);
//
//	// 切点
//	@Pointcut("execution(* com.rd.occ.api.controller.DataPoolController.do*(..))")
//	public void executeDataService(){
//
//	}
//
//
//	//@ResponseBody
//	@Around("executeDataService()")
//	public Object aroundApi(ProceedingJoinPoint  joinPoint) throws Throwable {
//		logger.info("------- OCC CHECKSECURITY -------");
//		// 获取执行方法名
//		String methodName = joinPoint.getSignature().getName();
//		// 获取请求参数列表
//		Object[] obj = joinPoint.getArgs();
//		SCRequest scRequest = (SCRequest) obj[0];
//		HttpServletRequest request = (HttpServletRequest) obj[1];
//		// 声明认证需要的参数
//		String bankCode = scRequest.getBankCode(),instCode = scRequest.getInstCode(),tokenId = scRequest.getAccessToken(),ipAddr = request.getRemoteAddr();
//		logger.info("BANKCODE:{},INSTCODE:{},TOKENID:{},IP:{},METHOD:{}",bankCode,instCode,tokenId,ipAddr,methodName);
//		// 校验当前授权认证是否通过
//		boolean ifAuth = AuthorizationTool.getInstance().ifAuth(bankCode, instCode, tokenId, ipAddr);
//		// 未授权
//		if(!ifAuth){
//			logger.info("------- FAILED -------");
//			Map<String,Object> securityMap = new HashMap<String,Object>();
//			Map<String,String> bodyMap = new HashMap<String,String>();
//		    securityMap.put("head", new AbstractResponseHead(scRequest, CodeEnum.CODE_00008.getCode(), CodeEnum.CODE_00008.getCodeDesc()));
//		    bodyMap.put("identityNo ", scRequest.getIdentityNo());
//		    bodyMap.put("name", scRequest.getUserName());
//		    securityMap.put("body", bodyMap);
//			return securityMap;
//		}
//		logger.info("------- SUCCESS -------");
//		// 已授权,执行回调
//		return joinPoint.proceed();
//    }
//}
