package com.example.openAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.openAPI.kakao.BookUseCase;
import com.example.openAPI.kakao.ResponseKakaoBook;
import com.example.openAPI.kakao.ResponseKakaoTranslation;
import com.example.openAPI.kakao.TranslationUseCase;

import reactor.core.publisher.Mono;

/**
 * 포스트맨으로 테스트 해본 결과, 앱키는 헤더에 검색값은 param
 * api 문서에도 적혀있음 
 *
 */
@RestController
@RequestMapping("/api")
public class OpenApiController {
  
  private final BookUseCase bookUseCase;
  private final TranslationUseCase translationUseCase;
  
  public OpenApiController(BookUseCase bookUseCase, TranslationUseCase translationUseCase) {
    this.bookUseCase = bookUseCase;
    this.translationUseCase = translationUseCase;
  }
  
  @GetMapping("/book")
  public Mono<ResponseKakaoBook> findBookByQuery(){
    List<ResponseKakaoBook.document> documentList = new ArrayList<>();
    return bookUseCase.findBookByQuery("스프링부트");
  }
  
  @GetMapping("/translation")
  public Mono<ResponseKakaoTranslation> translateByQuery(){
    return translationUseCase.translate("I like you");
  }
  
  @GetMapping("/testValue")
  public String testValue(){
    
    return "test";
    
  }
}
