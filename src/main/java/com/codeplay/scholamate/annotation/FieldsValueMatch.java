package com.codeplay.scholamate.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(FieldsValueMatch.List.class)
public @interface FieldsValueMatch {

    String message() default "Fields value don't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // Configuration Keys (parameters of this annotation)

    String field();

    String fieldMatch();

    // Container annotation for repeatable usage
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        FieldsValueMatch[] value();
    }
}
