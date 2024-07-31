package ac.su.kdt.inclassloggingcontrol.logger;

import ac.su.kdt.inclassloggingcontrol.controller.LogController;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class CustomLogger {
    // 선언된 로그 타입에 맞는 로거 생성
    public static final Logger logger = LogManager.getLogger(LogController.class);

    public static void logRequest(
        String logType,
        String url,
        String method,
        String userId,
        String transactionId,
        String productId,
        String cartId,
        String orderId,
        String payload,
        HttpServletRequest request
//        String clientIp,
//        String userAgent,
//        String referrer
    ) {
//        logger.info(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
        logger.info(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
            logType,
            LocalDateTime.now(),
            url,
            method,
            userId,
            transactionId,
            productId,
            cartId,
            orderId,
            payload,
            request.toString()
//            clientIp,
//            userAgent,
//            referrer
        ));
    }
}