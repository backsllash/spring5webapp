package com.backsllash.spring5webapp.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class toString {
    private Object o;

    public toString(Object o) {
        this.o = o;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        boolean methodsFound = false;
        try {
            Class<?> clazz = o.getClass();
            s.append(clazz.getSimpleName() + "(");
            Method[] methods = clazz.getMethods();
            for (int x = 0; x < methods.length; x++) {
                Method method = methods[x];
                if (Modifier.isPublic(method.getModifiers()) && (method.getName().startsWith("get") || method.getName().startsWith("is")) && method.getParameterTypes().length == 0) {
                    Method m = clazz.getMethod("set" + (method.getName().startsWith("get") ? method.getName().substring(3) : method.getName().substring(2)), new Class[]{method.getReturnType()});

                    if (m != null) {
                        s.append((method.getName().startsWith("get") ? method.getName().substring(3) : method.getName().substring(2)) + "[");
                        Object result = method.invoke(o, new Object[]{});
                        s.append(result != null ? result.toString() : "null");
                        s.append("], ");
                        methodsFound = true;
                    }
                }
            }
        } catch (Exception e) {
        }
        if (methodsFound) {
            s.replace(s.length() - 2, s.length(), "");
        }
        s.append(")");
        return (s.toString());
    }

}
