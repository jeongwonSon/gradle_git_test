package com.example.openAPI.kakao;

import reactor.core.publisher.Mono;

public interface TranslationUseCase {
  Mono<ResponseKakaoTranslation> translate(String query); 
}
