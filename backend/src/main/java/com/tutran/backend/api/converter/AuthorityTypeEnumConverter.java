package com.tutran.backend.api.converter;

import com.tutran.backend.api.entity.UserAuthority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AuthorityTypeEnumConverter implements AttributeConverter<UserAuthority.AuthorityType, String> {

    private static final String ROLE_PREFIX = "ROLE_";

    @Override
    public String convertToDatabaseColumn(UserAuthority.AuthorityType attribute) {
        return ROLE_PREFIX + attribute.name();
    }

    @Override
    public UserAuthority.AuthorityType convertToEntityAttribute(String dbData) {
        return UserAuthority.AuthorityType.valueOf(dbData.substring(ROLE_PREFIX.length()));
    }

}
