package com.example.openAPI.kakao;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResponseKakaoTranslation implements Serializable{
  
  private List<List<String>> translated_text;
  
}
