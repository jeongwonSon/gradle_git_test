package com.example.demo.domain;

import javax.persistence.AttributeConverter;

public class PasswordConverter implements AttributeConverter<String, String>{

  @Override
  public String convertToDatabaseColumn(String attribute) {
    // TODO perform encryption here(암호화)
    return attribute;
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    // TODO perform decryption here(복호화)
    return null;
  }

}
