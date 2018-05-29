package com.example.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.PreviousMember;

/*
 * 한 번 조회할 때마다 2초 이상의 시간이 필요하다고 가정한 뒤,
 * 캐시에 따라 수행속도 차이가 나는 지 비교를 함
 */
@Repository
public class MemberRepositoryImpl implements MemberRepository{
  
  private static Logger logger = LoggerFactory.getLogger(MemberRepositoryImpl.class);
  
  @Override
  public PreviousMember findByNameNoCache(String name) {
    slowQuery(2000);
    return new PreviousMember(0, name+"@gmail.com", name);
  }
  
  /**
   * @Cacheable(value="findMemberCache", key ="#name")
   * :: ehcache.xml에서 지정한 findMemberCache 캐시를 사용하겠다는 의미
   * (key에 따라 캐시 설정, 제거를 선택할 수 있다.)
   */
  @Override
  @Cacheable(value="findMemberCache", key ="#name")
  public PreviousMember findByNameCache(String name) {
    slowQuery(2000);  // slowQuery 호출
    return new PreviousMember(0, name+"@gmail.com", name);
  }
  
  @Override
  @CacheEvict(value="findMemberCache", key="#name")
  public void refresh(String name) {
    logger.info(name + "의 Cache Clear!");
  }
  
  // 대용량 쿼리를 실행한다는 가정
  private void slowQuery(long seconds) {
    try {
    	Thread.sleep(seconds);
    } catch (InterruptedException e) {
      // TODO: handle exception
      throw new IllegalStateException(e);
    }
  }
  
}
