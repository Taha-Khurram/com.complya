package com.complya.framework.retry;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {
        if (getRetryAnalyzerClass(annotation) == null) {
            setRetryAnalyzerClass(annotation, RetryAnalyzer.class);
        }
    }

    private static Class<?> getRetryAnalyzerClass(ITestAnnotation annotation) {
        try {
            Method method = annotation.getClass().getMethod("getRetryAnalyzerClass");
            return (Class<?>) method.invoke(annotation);
        } catch (NoSuchMethodException ignored) {
            try {
                Method method = annotation.getClass().getMethod("getRetryAnalyzer");
                return (Class<?>) method.invoke(annotation);
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException("Unable to read retry analyzer from ITestAnnotation", e);
            }
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Unable to read retry analyzer from ITestAnnotation", e);
        }
    }

    private static void setRetryAnalyzerClass(ITestAnnotation annotation, Class<?> retryAnalyzerClass) {
        try {
            Method method = annotation.getClass().getMethod("setRetryAnalyzerClass", Class.class);
            method.invoke(annotation, retryAnalyzerClass);
        } catch (NoSuchMethodException ignored) {
            try {
                Method method = annotation.getClass().getMethod("setRetryAnalyzer", Class.class);
                method.invoke(annotation, retryAnalyzerClass);
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException("Unable to set retry analyzer on ITestAnnotation", e);
            }
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Unable to set retry analyzer on ITestAnnotation", e);
        }
    }
}
