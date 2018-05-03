package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/*
 * Ehcache 설정이 되었는지 확인을 위한 component 추가
 * :: 현재 어플리케이션에서 사용중인 CacheManager가 무엇인지 확인하기 위함
 */
@Component
public class CacheManagerCheck implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CacheManagerCheck.class);
	
	private final CacheManager cacheManager;
	
	public CacheManagerCheck(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

	/*
	 * application 실행 시 무조건 run()이 됨 -> cacheManager 확인
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info("\n\n" + "=========================================================\n" + "Using cache manager: "
				+ this.cacheManager.getClass().getName() + "\n"
				+ "=========================================================\n\n");
	}

}
