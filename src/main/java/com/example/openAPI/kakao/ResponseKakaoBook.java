package com.example.openAPI.kakao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ResponseKakaoBook implements Serializable{

  private static final long serialVersionUID = 1L;
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