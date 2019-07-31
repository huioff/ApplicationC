#include <jni.h>
#include <cstring>
#include <string>
#include <iostream>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplicationc_MainActivity_stringFromJNI(JNIEnv* env,jobject /* this */) {
    char hello[] = "Hello from C++";
    return env->NewStringUTF(hello);
}

extern "C" JNIEXPORT void  JNICALL
Java_com_example_myapplicationc_MainActivity_updateName(JNIEnv* env, jobject obj /* this */) {
   //反射Java类
   jclass cls  = env->GetObjectClass(obj);
   //参数1: 反射的类 参数2: 属性名称 参数3: 属性签名(数据类型简称)
   jfieldID  jfid = env->GetFieldID(cls,"name","Ljava/lang/String;");
   //获取属性的值(类似Java反射中)根据属性类型 如 env->GetBooleanField() 获取boolean 类型
    auto name = (jstring) env -> GetObjectField(obj,jfid);//GetObjectField
    char str1[] = "abcdef";
    const char* str = (env) ->GetStringUTFChars(name, nullptr);
//    //将str1 拼接到 str 后面
    strncpy(str1,str,6);

   //再将C/C++数据类型转换成jni数据类型
    name = (env)->NewStringUTF(str1);

    //更新Java对象中的属性
    env-> SetObjectField(obj,jfid,name);
}
extern "C" JNIEXPORT void  JNICALL
Java_com_example_myapplicationc_MainActivity_updateAge(JNIEnv* env, jobject obj /* this */) {
    //反射Java类
    jclass cls  = env->GetObjectClass(obj);
    //参数1: 反射的类 参数2: 属性名称 参数3: 属性签名(数据类型简称)
    jfieldID  jfid = env->GetStaticFieldID(cls,"age","I");
    //获取属性的值(类似Java反射中)根据属性类型 如 env->GetStatic<类型>Field() 获取boolean 类型
    jint age =  env -> GetStaticIntField(cls,jfid);//GetObjectField
    //Lang类型 直接加减
    age += 50;
    //更新Java对象中的属性
    env-> SetStaticIntField(cls,jfid,age);
}