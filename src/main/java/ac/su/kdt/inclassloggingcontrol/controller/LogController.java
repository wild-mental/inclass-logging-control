package ac.su.kdt.inclassloggingcontrol.controller;

import ac.su.kdt.inclassloggingcontrol.domain.CartForm;
import ac.su.kdt.inclassloggingcontrol.domain.OrderForm;
import ac.su.kdt.inclassloggingcontrol.logger.CustomLogger;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import java.util.stream.LongStream;

@RestController
public class LogController {
    Random random = new Random();
    // 로그 config 에 등록된 클래스 단위에서
    // 실제 로그 기록 메서드 호출 실행 -> 로그 기록
    // 아래 엔드포인트들은 DB 를 만들지 않습니다. (더미 호출 구현)
    // return 타입 ResponseEntity 로 하지 않고 String 으로 해도 됨

    // GET /products              (상품 리스트 조회)
    // #### 랜덤한 상품 5개 (1~100) 조회하는 로직 구현
    @GetMapping("/products")
    public String showProductList(
        @RequestParam(name = "userid", required = false) String userId,
        HttpServletRequest request
    ) {
        // 랜덤 상품 리스트 생성
        List<Long> productList = LongStream.range(0, 5)
            .mapToObj(i -> random.nextLong(100) + 1)
            .toList();

        // 로그 기록하기 (상품 하나하나에 대한 노출이 발생했음을 기록해야 함!)
        // 로그 스키마는 로그 한 줄의 구성을 가지고 특별한 의미 (로직 및 데이터 분석용) 부여할 수 있도록 구현
        // csv 형태로 다루면 한줄에 여러개의 컬럼 표현 가능
        for (Long productId : productList) {
            // 노출된 상품 ID 하나마다 로그 1행 기록
            // logger.info(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",  // 컬럼 개수 선언
            CustomLogger.logRequest(
                "l",  // 파라미터 이름으로 관리되지 못하고 있음 -> 메서드 분리
                "/products",
                "GET",
                userId != null ? userId : "-",
                "-",
                productId.toString(),
                "-",
                "-",
                "-",
                request
            );
//        ));
        }

        // 반환
        return productList.toString();
    }

    // GET /products/{productId}  (상품 상세 조회)
    // #### 접수된 상품 id가 있다 치고 응답하는 로직 구현
    @GetMapping("/products/{productId}")
    public String showProductDetail(
        @PathVariable Long productId
    ) {
        // 로그 기록하기 (상품 하나에 대한 상세 조회가 발생했음을 기록해야 함!)

        // 반환
        return productId + "번 상품 조회됨";
    }

    // POST /cart                 (상품을 장바구니에 추가)
    // #### 리퀘스트 바디 (CartForm)에 포함될 내용을 정의 후 해당 내용 성공응답 로직 구현
    @PostMapping("/carts")
    public String addProductToCart(
        @RequestBody CartForm cartForm
    ) {
        // 로그 기록하기 (장바구니에 상품 추가가 발생했음을 기록해야 함!)

        // 반환
        return "카트에 상품 추가 완료:\n" + cartForm.toString();
    }

    // POST /order                (장바구니에 담긴 상품 주문 또는 상품 즉시 주문)
    // #### 리퀘스트 바디 (OrderForm)에 포함될 내용을 정의 후 해당 내용 성공응답 로직 구현
    @PostMapping("/orders")
    public String orderProducts(
        @RequestBody OrderForm orderForm
    ) {
        // 로그 기록하기 (주문이 발생했음을 기록해야 함!)

        // 반환
        return "주문 완료:\n" + orderForm.toString();
    }

}
