package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotation {

    @Target(ElementType.TYPE) // 클래스와 인터페이스에 어노테이션을 적용할 수 있다
    @Retention(RetentionPolicy.RUNTIME) // 어노테이션을 실행 시간에 이용(리플렉션 API로 접근)
    @Component
    public @interface Controller {
    }

    @Target(ElementType.TYPE) // 클래스와 인터페이스에 어노테이션을 적용할 수 있다
    @Retention(RetentionPolicy.RUNTIME) // 어노테이션을 실행 시간에 이용(리플렉션 API로 접근)
    @Component
    public @interface Service {
    }

    @Target(ElementType.ANNOTATION_TYPE) // 클래스와 인터페이스에 어노테이션을 적용할 수 있다
    @Retention(RetentionPolicy.RUNTIME) // 어노테이션을 실행 시간에 이용(리플렉션 API로 접근)
    public @interface Component {
    }


}
