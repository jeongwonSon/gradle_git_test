package com.example.openAPI.kakao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * 카카오 책 검색
 */
@Component
public class KakaoBookProvider implements BookUseCase{
  
  @Value("${kakao.openapi.book.url}")
  private String kakaoOpenApiBookUrl;
  
  @Value("${kakao.openapi.authorization}")
  private String kakaoOpenApiAuthorization;
  
  @Override
  public Mono<ResponseKakaoBook> findBookByQuery(String query) {
    // TODO Auto-generated method stub
    /*
     * 마지막 체인 메서드를 보면 .bodyToMono(ResponseKakaoBook.class)를 호출함
     * 최종 리턴 값을 Mono로 전달하면서 ResponseKakaoBook class에 데이터를 매핑함
     * 리턴 타입은 Mono<ResponseKakaoBook>이다.
     */
    return WebClient.create(kakaoOpenApiBookUrl)
        .method(HttpMethod.GET)
        .uri("?query=" + query)
        .header("Authorization", "KakaoAK " + kakaoOpenApiAuthorization)
        .retrieve()
        .bodyToMono(ResponseKakaoBook.class);
  }

}
