package org.example;

import org.example.annotation.CustomAnnotation.Component;


import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class SimpleContainer {


    public void MySimpleContainer(String basePackage) throws Exception{
        for (Class<?> aClass : findClassesWithController(basePackage)) {
            if(aClass.isAnnotationPresent())
        }
    }

    public static List<Class<?>> findClassesWithController(String packageName) throws Exception{
        /**
         * ClassLoader := 클래스나 리소스를 JVM 메모리로 이동
         * currentThread() := 현재 이 코드를 실행하는 스레드에 엑세스
         * getContextClassLoader() := 현재 스레드에 대한 클래스 로더 반환
         */
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/'); // org.example -> org/example
        Enumeration<URL> resources = classLoader.getResources(path); // file:/Users/minwoo/IdeaProjects/.../org/example
        List<File> dirs = new ArrayList<>();


        // Print out the resources
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile())); // file: 를 제외한 URL을 dirs에 추가
        }

        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }

        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        // 찾은 클래스 객체를 보관할 새로운 리스트를 생성합니다.
        List<Class<?>> classes = new ArrayList<>();

        // 디렉토리가 실제로 존재하는지 확인하고, 존재하지 않으면 빈 리스트를 반환합니다.
        if (!directory.exists()) {
            return classes;
        }

        // 디렉토리에 있는 모든 파일들을 리스트로 가져옵니다.
        File[] files = directory.listFiles();

        // 디렉토리에 있는 각 파일에 대해 반복합니다.
        for (File file : files) {
            // 파일이 디렉토리라면, 그것은 하위 패키지로 가정합니다.
            if (file.isDirectory()) {
                // 디렉토리(하위 패키지) 이름에 점이 포함되어 있지 않은지 확인합니다.
                // 패키지 이름에는 점이 들어갈 수 없습니다.
                assert !file.getName().contains(".");
                // 재귀적으로 서브디렉토리에서 클래스를 찾으며, 패키지 이름에 서브디렉토리 이름을 추가합니다.
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                // 방금 구성한 클래스 이름에 대한 클래스 객체를 로드합니다.
                Class<?> cls = Class.forName(className);
                if (!cls.isAnnotation() && isAnnotatedWithComponent(cls)) { // 컴포넌트 어노테이션이 내부에 있는지 확인
                    classes.add(cls);
                }
            }
        }
        // @Controller 어노테이션이 있는 클래스 객체의 리스트를 반환합니다.
        return classes;
    }

    private static boolean isAnnotatedWithComponent(Class<?> cls) {

        if (cls.isAnnotationPresent(Component.class)) {
            return true;
        }

        for (Annotation annotation : cls.getAnnotations()) {
            if (annotation.annotationType().isAnnotationPresent(Component.class)) {
                return true;
            }
        }
        
        return false;
    }


}
