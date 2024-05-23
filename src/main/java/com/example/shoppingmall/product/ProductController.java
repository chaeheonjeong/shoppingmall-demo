package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@RestController
@AllArgsConstructor
public class ProductController {

//    @Autowired // DI
    ProductService productService;

    // 상품 개별 등록
    @PostMapping("/products")
    public ApiUtils.ApiResult registerProduct(@Valid @RequestBody ProductDTO productDTO) {

//        if(Validator.isAlpha(product.getName()) &&
//                Validator.isNumber(product.getPrice())) {
//            log.info(product.getName());
//
//            Product savedProduct = productService.registerProduct(product);
//
//            try {
//                log.info(savedProduct.getName());
//            } catch (NullPointerException e) {
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } else
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Product requestProduct = productDTO.convertToEntity();

        Product product = productService.registerProduct(requestProduct);
        return success(product);
    }

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public ApiUtils.ApiResult<Optional<Product>> findProduct(@PathVariable(value="id") int id) {
//        if(!Validator.isNumber(id)) {
////            Logger log = LoggerFactory.getLogger(ProductController.class);
//            log.info(id + " haha");
//            log.trace("id {}", "haha");
//
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        Product resultProduct = productService.findProduct(id);
//
//        if(resultProduct == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        return new ResponseEntity<>(resultProduct, HttpStatus.OK);

        Optional<Product> resultProduct = productService.findProduct(id);
        return success(resultProduct);
    }

    // 상품 전체 조회
    @GetMapping("/products")
    public ApiUtils.ApiResult<List<Product>> findProducts(
            @RequestParam("limit") int limit,
            @RequestParam("currentPage") int currentPage,
            @RequestParam(value = "categoryId", required = false) Integer categoryId
        ) {
//        log.info("limit = {}", limit);
//        log.info("currentPage = {}", currentPage);
//        log.info("categoryId = {}", categoryId);

//        if(categoryId == null) {
//            List<Product> products = productService.findProducts(limit, currentPage);
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } else {
//            List<Product> products = productService.findProducts(limit, currentPage, categoryId);
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        }

        List<Product> products = productService.findProducts(limit, currentPage);
        return success(products);
    }

//    @DeleteMapping("/products/{id}")
//    public ResponseEntity deleteProduct(@PathVariable("id") int id) {
//        if(!Validator.isNumber(id))
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        productService.deleteProduct(id);
//        Product product = productService.findProduct(id);
//
//        if(product == null)
//            return new ResponseEntity<>(HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @PostMapping("/products/delete")
//    public ResponseEntity deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest) {
//
//        List<Integer> productIds = deleteRequest.get("productIds");
//
//        if (productIds.isEmpty()) {
//            log.info("productIds가 없어..");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        productService.deleteProducts(productIds);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
