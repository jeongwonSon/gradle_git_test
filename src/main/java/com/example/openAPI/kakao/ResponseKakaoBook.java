package com.example.openAPI.kakao;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResponseKakaoBook implements Serializable{

  private ResponseKakaoBook.Meta meta;
  private List<document> documents;
  
  public List<document> getDocuments(){
    return documents;
  }
  
  static class Meta{
    long total_count;
    long pageable_count;
    Boolean is_end;
  }
  
  public static class document{
    String title;
    String contents;
    String url;
    List<String> authors;
    String publisher;
    String thumbnail;
  }
}
