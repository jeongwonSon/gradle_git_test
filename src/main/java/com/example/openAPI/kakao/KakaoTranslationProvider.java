package com.example.openAPI.kakao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class KakaoTranslationProvider implements TranslationUseCase{

  @Value("${kakao.openapi.translation.url}")
  private String kakaoOpenApiBookUrl;
  
  @Value("${kakao.openapi.authorization}")
  private String kakaoOpenApiAuthorization;
  
  @Override
  public Mono<ResponseKakaoTranslation> translate(String query) {
    // TODO Auto-generated method stub
    return WebClient.create(kakaoOpenApiBookUrl)
        .method(HttpMethod.GET)
        .uri("?query="+query +"&src_lang="+ "en" + "&target_lang=" + "kr")
        .header("Authorization", "KakaoAK " + kakaoOpenApiAuthorization)
        .retrieve()
        .bodyToMono(ResponseKakaoTranslation.class);
  }

}
