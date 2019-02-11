package com.example.openAPI.kakao;

import reactor.core.publisher.Mono;

/**
 * webflux -> Mono를 사용하는 이유
 * :: 데이터를 중간 과정에서 변환없이 사용할 예정임.
 * 데이터를 2개 이상의 데이터로 전달하면 Flux로 정의하면 된다. 
 *
 */
public interface BookUseCase {
  Mono<ResponseKakaoBook> findBookByQuery(String query);
}
